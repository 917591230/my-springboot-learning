package cn.clay;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
//配置事务的回滚,对数据库的增删改都会回滚,便于测试用例的循环利用
//@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
//@Transactional
public class UserControllerTest {

    protected String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJsb2dpbl9uYW1lIjoiaHJtXzIwMTgiLCJ1c2VyX25hbWUiOiLnrqHnkIYiLCJpZCI6MSwiZXhwIjoxNTM2OTk4MDM2fQ.VwxmI-jvrCQYiJP-N7VCSxkBHpPuPW3Fpf3E5CggsNU";

    private MockMvc mockMvc;
    @Autowired
    private WebApplicationContext wac;
    @Autowired
    private UserController userController;
    private Map<String, Object> map;
    private ObjectMapper mapper = new ObjectMapper();

    @Before
    @SneakyThrows
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
        Map<String, Object> map = new HashMap<>();
        map.put("name", "张三");
        map.put("sex", new Character('男'));
//        map.put("sex", "男性");
        map.put("age", 11);
        map.put("hobby", new String[]{"游戏", "动漫"});
        map.put("nickname", new String[]{});
        map.put("birthday", new Date());
//        map.put("birthday", "2018-09-26 23:37:29");
        //map转json，json转Bean
        User user = mapper.readValue(mapper.writeValueAsString(map), User.class);
        this.map = map;
    }


    @Test
    @SneakyThrows(Exception.class)
    public void insertUserAge() throws InvocationTargetException, IllegalAccessException {
//        User user = new User();
//        BeanUtils.populate(user,this.map);
//        System.out.println(user);
        User user = mapper.readValue(mapper.writeValueAsString(this.map), User.class);
        userController.insertUser(user);
    }

    @Test
    @SneakyThrows(Exception.class)
    public void insertUser() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "张三");
        map.put("sex", "男");
        map.put("age", "11");
        map.put("hobby", new String[]{"游戏", "动漫"});
        map.put("nickname", new String[]{});
        map.put("birthday", 1538005049000L);
        ObjectMapper mapper = new ObjectMapper();
        RequestBuilder request = post("/user/insert/user")
                .content(mapper.writeValueAsString(map))
//                .header("Authorization", token)
                .contentType(MediaType.APPLICATION_JSON_UTF8);
        MvcResult result = mockMvc.perform(request)
                .andReturn();
        int statusCode = result.getResponse().getStatus();
        Assert.assertEquals(statusCode, 200);
    }


    @Test
    public void getUserTest() throws Exception {
        String responseString = mockMvc.perform(
                post("/user/insert/user")    //请求的url,请求的方法是get
                        .content(mapper.writeValueAsBytes(this.map))
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
        ).andExpect(status().isOk())
                .andDo(print())
                .andReturn().getResponse().getContentAsString();   //将相应的数据转换为字符串
        System.out.println("--------返回的json = " + responseString);
    }

    @Test
    @SneakyThrows(Exception.class)
    public void getUserAsertTest() {
        MockHttpServletRequestBuilder Request = post("/user/insert/user")    //请求的url,请求的方法是get
                .content(mapper.writeValueAsBytes(this.map))
                .contentType(MediaType.APPLICATION_JSON_UTF8);
        mockMvc.perform(Request).andExpect(status().isOk()).andExpect(jsonPath("$.data.msg","成功"));


    }
}