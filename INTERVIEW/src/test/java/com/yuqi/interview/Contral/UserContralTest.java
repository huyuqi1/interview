package com.yuqi.interview.Contral;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.Assert;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserContralTest {

    private MockMvc mockMvc;

    @Resource
    private WebApplicationContext webApplicationContext;


    @BeforeEach
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }


//    @Test
//    public void updategradetest() throws Exception{
//        MvcResult mvcResult = mockMvc.perform(
//                MockMvcRequestBuilders
//                        .get("/updategrade")
//                        .param("name", "ch")
//                        .param("grade", String.valueOf(14))
//                        .accept(MediaType.APPLICATION_JSON)
//                        ).andExpect(MockMvcResultMatchers.status().isOk())
//                       .andDo(MockMvcResultHandlers.print()) //andDo
//                        .andReturn();//andReturn
//    }

}