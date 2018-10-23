package cn.clay.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class AppListener implements ApplicationListener<ContextRefreshedEvent> {

    @Value("${machine.id}")
    private String machine_id;
//    @Override
//    public void onApplicationEvent(ApplicationEvent event) {
////        System.out.println(machine_id);
//        System.out.println(event.getTimestamp());
//    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println(machine_id);
        System.out.println(event.getTimestamp());
    }
}
