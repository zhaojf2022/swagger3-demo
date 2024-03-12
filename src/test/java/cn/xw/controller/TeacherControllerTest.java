package cn.xw.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@AutoConfigureMockMvc
class TeacherControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @Transactional
    @Rollback()
    public void save() throws Exception {
        String json = "{……}";

        //执行一个RequestBuilder请求，会自动执行SpringMVC的流程并映射到相应的控制器执行处理；
        mockMvc.perform(MockMvcRequestBuilders
                        .post("/XXX/save")
                        .content(json.getBytes()) //传json参数

                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .header("Authorization","Bearer ********-****-****-****-************")
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(print());
    }

}