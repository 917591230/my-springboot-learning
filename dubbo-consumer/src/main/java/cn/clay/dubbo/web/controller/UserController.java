package cn.clay.dubbo.web.controller;


import cn.clay.dubbo.iservice.UserService;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * {@link @Reference} dubbo注入注解需要配置url属性，
 */
@RestController
@RequestMapping("/")
public class UserController {

    @Reference(group = "test",version = "1.0",url = "dubbo://192.168.67.1:28888")
    private UserService userServiceImpl;

    @RequestMapping("showUser")
    public String showUser() {
        String userInfo = userServiceImpl.showUser();
        String json="{\n" +
                "\t\"params\": {\n" +
                "\t\t\"priviewId\": 2017109071601,\n" +
                "\t\t\"uuid\": \"$UUID\",\n" +
                "\t\t\"provinceCode\": \"37110086\",\n" +
                "\t\t\"modelId\": \"$MODELID\",\n" +
                "\t\t\"createTime\": \"2017-08-12 14:19:46\",\n" +
                "\t\t\"modelName\": \"测试上线模型只音量文本\",\n" +
                "\t\t\"updateTime\": \"2017-08-28 14:19:46\"\n" +
                "\t},\n" +
                "\t\"object\": {\n" +
                "\t\t\"energyRule\": [{\n" +
                "\t\t\t\"id\": \"2354367\",\n" +
                "\t\t\t\"dimensionCode\": \"OBJ004\",\n" +
                "\t\t\t\"fragmentNum\": \"1\",\n" +
                "\t\t\t\"value\": [{\n" +
                "\t\t\t\t\t\"propertyCode\": \"ATR003\",\n" +
                "\t\t\t\t\t\"value\": \"20\",\n" +
                "\t\t\t\t\t\"relativeobject\": \"\",\n" +
                "\t\t\t\t\t\"operationCode\": \"OP001\"\n" +
                "\t\t\t\t},\n" +
                "\t\t\t\t{\n" +
                "\t\t\t\t\t\"propertyCode\": \"ATR001\",\n" +
                "\t\t\t\t\t\"operationCode\": \"OP002\",\n" +
                "\t\t\t\t\t\"value\": \"n0\"\n" +
                "\t\t\t\t}\n" +
                "\t\t\t]\n" +
                "\t\t}],\n" +
                "\t\t\"modelFragments\": [{\n" +
                "\t\t\t\t\"ruleType\": \"1\",\n" +
                "\t\t\t\t\"fragmentNum\": \"2\",\n" +
                "\t\t\t\t\"fragmentId\": \"201703242364528150\",\n" +
                "\t\t\t\t\"fragmentContent\": \"((睡觉|再见))\",\n" +
                "\t\t\t\t\"channel\": \"2\",\n" +
                "\t\t\t\t\"tagText\": \"\",\n" +
                "\t\t\t\t\"isTag\": \"0\"\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"ruleType\": \"1\",\n" +
                "\t\t\t\t\"fragmentNum\": \"3\",\n" +
                "\t\t\t\t\"fragmentId\": \"2431644654352532817\",\n" +
                "\t\t\t\t\"fragmentContent\": \"(帮我)\",\n" +
                "\t\t\t\t\"channel\": \"1\",\n" +
                "\t\t\t\t\"tagText\": \"({服务})\",\n" +
                "\t\t\t\t\"isTag\": \"0\"\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"ruleType\": \"1\",\n" +
                "\t\t\t\t\"fragmentNum\": \"4\",\n" +
                "\t\t\t\t\"fragmentId\": \"2431644654352532817\",\n" +
                "\t\t\t\t\"fragmentContent\": \"(对不起)\",\n" +
                "\t\t\t\t\"channel\": \"1\",\n" +
                "\t\t\t\t\"tagText\": \"({服务})\",\n" +
                "\t\t\t\t\"isTag\": \"0\"\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"ruleType\": \"1\",\n" +
                "\t\t\t\t\"fragmentNum\": \"5\",\n" +
                "\t\t\t\t\"fragmentId\": \"2431644654352532817\",\n" +
                "\t\t\t\t\"fragmentContent\": \"(好的)\",\n" +
                "\t\t\t\t\"channel\": \"1\",\n" +
                "\t\t\t\t\"tagText\": \"({服务})\",\n" +
                "\t\t\t\t\"isTag\": \"0\"\n" +
                "\t\t\t}\n" +
                "\t\t],\n" +
                "\t\t\"modelFragmentRelation\": {\n" +
                "\t\t\t\"ruleType\": \"2\",\n" +
                "\t\t\t\"fragmentId\": \"20171030092250409813\",\n" +
                "\t\t\t\"fragmentContent\": \"1&2+3|4-5|2-5\"\n" +
                "\t\t}\n" +
                "\t}\n" +
                "}";

        String offline="{\"params\":{\"modelId\": \"201611115,2016111114,2016111113\",\"uuid\": \"be0f3908-ff44-4688-a8e2-6d445c16c0b5\",\"provinceCode\": \"37110086\"}}";
        return "success";
    }
}
