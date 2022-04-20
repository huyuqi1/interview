package com.yuqi.interview;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.SQLException;

@SpringBootTest
class InterviewApplicationTests {

    @Autowired
    DataSource dataSource;

    @Test
    void contextLoads() throws SQLException {
        System.out.println("aaaaaaaaaaaaa"+dataSource.getClass());
        System.out.println("aaaaaaaaaaaaa"+dataSource.getConnection());

    }

}

