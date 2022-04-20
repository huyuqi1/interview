package com.yuqi.interview.Contral;

import com.yuqi.interview.mapper.Usermapper;
import com.yuqi.interview.pojo.User;
import com.yuqi.interview.util.WebSocketServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@RestController
public class UserContral {

    @Autowired
    Usermapper usermapper;

    @GetMapping("/updategrade")
    @Async("threadPoolTaskExecutor")
    public String updategrade(String name, int grade, String updatetime) {
        User user = new User();
        user.setName(name);
        user.setGrade(grade);
        user.setUpdatetime(updatetime);
        User recorduser = usermapper.getgrade(user);
        try {
            if (recorduser == null) {
                usermapper.insert(user);
                WebSocketServer.BroadCastInfo(user.getName()+" update grade success,grade is "+user.getGrade());
            } else if (new SimpleDateFormat("yyyy-MM-DD HH:mm:ss").parse(updatetime)
                    .after(new SimpleDateFormat("yyyy-MM-DD HH:mm:ss").parse(recorduser.getUpdatetime()))) {
                WebSocketServer.BroadCastInfo(user.getName()+" update grade success,grade is "+user.getGrade());
                usermapper.update(user);
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
            return "error";
        }
        return "success";
    }


    @GetMapping("/getgrade")
    public float getgradebyname(String name) {
        User user = usermapper.getgradebyname(name);
        System.out.println(user);
        if (user != null) {
            return user.getGrade();
        } else
            return 0.0f;
    }

}
