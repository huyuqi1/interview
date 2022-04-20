package com.yuqi.interview.util;

import com.yuqi.interview.pojo.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;

@ServerEndpoint(value = "/ws/asset")
@Component
public class WebSocketServer {

    @PostConstruct
    public void init() {
        System.out.println("websocket Loading");
    }
    private static Logger log = LoggerFactory.getLogger(WebSocketServer.class);
    private static final AtomicInteger OnlineCount = new AtomicInteger(0);
    // A thread-safe Set of the concurrent package, used to hold the corresponding Session object for each client.
    private static CopyOnWriteArraySet<Session> SessionSet = new CopyOnWriteArraySet<Session>();




    /**
     * Methods called for successful connection establishment
     */
    @OnOpen
    public void onOpen(Session session) {
        SessionSet.add(session);
        int cnt = OnlineCount.incrementAndGet(); //
        log.info("There are connections joined and the current number of connections is：{},sessionId={}", cnt,session.getId());
        SendMessage(session, "Connection successful");
    }

    /**
     * Methods for connection closure calls
     */
    @OnClose
    public void onClose(Session session) {
        SessionSet.remove(session);
        int cnt = OnlineCount.decrementAndGet();
        log.info("There are connections closed and the current number of connections is：{}", cnt);
    }

    /**
     * Methods called after receiving a client message
     *
     * @param message
     *
     */
    @OnMessage
    public void onMessage(String message, Session session) {
        log.info("Message from the client：{}",message);
        SendMessage(session, "Message received, message content："+message);

    }

    /**
     * An error has occurred
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session, Throwable error) {
        log.error("An error has occurred：{}，Session ID： {}",error.getMessage(),session.getId());
        error.printStackTrace();
    }

    /**
     * Sending messages, practice shows that the session changes every time the browser is refreshed。
     * @param session
     * @param message
     */
    public static void SendMessage(Session session, String message) {
        try {
//            session.getBasicRemote().sendText(String.format("%s (From Server，Session ID=%s)",message,session.getId()));
            session.getBasicRemote().sendText(message);
        } catch (IOException e) {
            log.error("Error sending a message：{}", e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Group Messaging
     * @param message
     * @throws IOException
     */
    public static void BroadCastInfo(String message) throws IOException {
        for (Session session : SessionSet) {
            if(session.isOpen()){
                SendMessage(session, message);
            }
        }
    }

    /**
     * Specifying a Session to send a message
     * @param sessionId
     * @param message
     * @throws IOException
     */
    public static void SendMessage(String message,String sessionId) throws IOException {
        Session session = null;
        for (Session s : SessionSet) {
            if(s.getId().equals(sessionId)){
                session = s;
                break;
            }
        }
        if(session!=null){
            SendMessage(session, message);
        }
        else{
            log.warn("The session for which you specified the ID was not found：{}",sessionId);
        }
    }
}