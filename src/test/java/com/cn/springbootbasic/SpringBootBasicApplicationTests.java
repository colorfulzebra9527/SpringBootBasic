package com.cn.springbootbasic;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class SpringBootBasicApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void test1() throws Exception {
        mockMvc.perform(get("/mc1/t1")
                        .param("id", "5")
                        .param("name", "zxx")
                )
                .andExpect(status().isOk());
    }

    @Test
    void test2() throws Exception {
        mockMvc.perform(get("/mc1/t2")
                        .param("id", "5")
                        .param("name", "zxx")
                )
                .andExpect(status().isOk());
    }

    @Test
    void test3() throws Exception {
        mockMvc.perform(get("/mc1/t3")
                        .param("id", "5")
                        .param("name", "zxx")
                        .param("gender", "male")
                        .param("age", "19")
                )
                .andExpect(status().isOk());
    }

    @Test
    void test4() throws Exception {
        String jsonData = "{\"id\":5,\"name\":\"zxx\",\"gender\":\"male\",\"age\":19}";

        mockMvc.perform(
                        post("/mc1/t4")
                         // 设置Content-Type
                        .contentType(MediaType.APPLICATION_JSON)
                        // 发送JSON字符串
                        .content(jsonData)
                )
                .andExpect(status().isOk());
    }

    // =========================================================

    @Test
    void test5() throws Exception {
        mockMvc.perform(get("/mc2/t1")
                        .param("name", "zxx")
                )
                .andExpect(status().isOk());
    }

    // =========================================================

    @Test
    void test6() throws Exception {
        mockMvc.perform(get("/mc3/t1"))
                .andExpect(status().isOk());
    }

    // =========================================================

    @Test
    void test7() throws Exception {
        mockMvc.perform(get("/mc4/t1"))
                .andExpect(status().isOk());
    }

    // =========================================================
    @Test
    void test8() throws Exception {
        mockMvc.perform(get("/users/5"))
                .andExpect(status().isOk());
    }

    @Test
    void contextLoads() {
    }

}
