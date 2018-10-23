package cn.clay.thread.impl2;


import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
@ComponentScan
//开始异步支持
@EnableAsync
public class MyThreadPoolConfig2 implements AsyncConfigurer {

    @Override
    @Bean("executor3")
    public Executor getAsyncExecutor() {
        //线程池
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        //核心线程数
        taskExecutor.setCorePoolSize(5);
        //最大线程数
        taskExecutor.setMaxPoolSize(10);
        //队列容量
        taskExecutor.setQueueCapacity(25);

        taskExecutor.setThreadNamePrefix("nice-");
        taskExecutor.initialize();
        return taskExecutor;
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return null;
    }

}