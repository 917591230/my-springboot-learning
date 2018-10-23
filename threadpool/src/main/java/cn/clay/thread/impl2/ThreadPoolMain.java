package cn.clay.thread.impl2;


import cn.clay.thread.HelloService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 16:20:39.950 [main] DEBUG org.springframework.core.env.PropertySourcesPropertyResolver - Could not find key 'spring.liveBeansView.mbeanDomain' in any property source
 * Exception in thread "main" org.springframework.beans.factory.NoSuchBeanDefinitionException: No qualifying bean of type 'cn.clay.thread.HelloService' available
 * 	at org.springframework.beans.factory.support.DefaultListableBeanFactory.getBean(DefaultListableBeanFactory.java:347)
 * 	at org.springframework.beans.factory.support.DefaultListableBeanFactory.getBean(DefaultListableBeanFactory.java:334)
 * 	at org.springframework.context.support.AbstractApplicationContext.getBean(AbstractApplicationContext.java:1107)
 * 	at cn.clay.thread.impl2.ThreadPoolMain.main(ThreadPoolMain.java:10)
 */
public class ThreadPoolMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ThreadPoolMain.class);

        HelloService bean = context.getBean(HelloService.class);
        for (int i = 0; i < 10; i++) {
            bean.sayHello2("clay");
            bean.sayHello2("caly");
        }
        context.close();
    }
}
