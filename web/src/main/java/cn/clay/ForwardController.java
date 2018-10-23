package cn.clay;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Controller
@RequestMapping("/login")
@Slf4j
public class ForwardController {

    public static ObjectMapper mapper = new ObjectMapper();

    private static Logger logger = LoggerFactory.getLogger(ForwardController.class);


    @RequestMapping("/loginf")
    public String loginf(Model model) {
        model.addAttribute("name", "小倩");
        model.addAttribute("id", 12345123L);
        model.addAttribute("hobby", new String[]{"KTV", "游泳", "旅游"});
        model.addAttribute("birthday", new Date());
        model.addAttribute("dsc", "转发");

        return "forward:hello?name='bbbbb'";
    }
    @RequestMapping("/logind")
    public String logind(Model model) {
        model.addAttribute("name", "小倩");
        model.addAttribute("id", 12345123L);
        model.addAttribute("hobby", new String[]{"KTV", "游泳", "旅游"});
        model.addAttribute("birthday", new Date());
        model.addAttribute("dsc", "重定向");

        return "redirect:hello";
    }
    @ResponseBody
    @RequestMapping("/hello")
    @SneakyThrows(Exception.class)
    public ResultBean hello(HttpServletRequest request, String name) {
//        String name, Long id, String[] hobby, Data birthday
        String aname = request.getParameter("name");
        String pname = (String)request.getAttribute("name");
        logger.info("aname="+aname);
        logger.info("pname="+pname);
        logger.info("自动装配：name="+name);
//        logger.info(String.valueOf(id));
////        logger.info(String.valueOf(hobby));
////        logger.info(String.valueOf(birthday));
        Person person = new Person("小艾", 1234L, new String[]{"KTV", "游泳", "旅游"}, new Date(),"dsc");

//        logger.info(mapper.writeValueAsString(model));
        ResultBean resultBean = new ResultBean(0L,"成功",null,person);
        return resultBean;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    class ResultBean{
        Long code;
        String msg;
        Integer count;
        Object bean;
    }


    @Getter
    @Setter
    @ToString
    @AllArgsConstructor
    @NoArgsConstructor
    class Person {
        String name;
        Long id;
        String[] hobby;
        Date birthday;
        String dsc;
    }

}
