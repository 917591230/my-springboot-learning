package cn.clay.thread;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication//，这个注解等同于@ComponmentScan、@EnableAsync注解达到相同的功效
//@ComponentScan
//@EnableAsync
public class ThreadPoolApplication {

    public static void main(String[] args){
        ConfigurableApplicationContext context = SpringApplication.run(ThreadPoolApplication.class, args);


    }
}
