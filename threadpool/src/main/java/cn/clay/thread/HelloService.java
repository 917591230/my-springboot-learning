package cn.clay.thread;

import cn.clay.beans.UserBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;
import org.springframework.util.IdGenerator;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

@Component
public class HelloService {
    private static final Logger logger = LoggerFactory.getLogger(HelloService.class);

    /**
     * 没有返回值
     * @param name
     */
    @Async
    public void sayHello1(String name) {
        logger.info(name + "hello world !");

    }

    /**
     * 返回jdk对象
     * @param name
     * @return
     */
    @Async("executor3")
    public ListenableFuture<String> sayHello2(String name) {
        String res = name + "hello world !";
        logger.info(res);
        return new AsyncResult<>(res);
    }

    /**
     * 返回自定义类的对象
     * @param name
     * @return
     */
    @Async("taskExecutor1")
    public ListenableFuture<UserBase> sayHello3(String name) {
        UserBase userBase = new UserBase();
        userBase.setUsername(name);
        logger.info(userBase.toString());
        return new AsyncResult<>(userBase);
    }
    /**
     * 使用指定线程池处理异步方法，返回自定义类的对象
     * @param name
     * @return
     */
    @Async("executor2")
    public ListenableFuture<UserBase> sayHello4(String name) {
        UserBase userBase = new UserBase();
        userBase.setUsername(name);
        logger.info(userBase.toString());
        return new AsyncResult<>(userBase);
    }
    @Async("executor2")
    public ListenableFuture<UserBase> sayHello5(String name) {
        UserBase userBase = new UserBase();
        userBase.setUsername(name);
        try {
            System.out.println(1/0);
        } catch (Exception e) {
            throw new RuntimeException("分母不能为零！");
        }
        logger.info(userBase.toString());
        return new AsyncResult<>(userBase);

    }

    public ListenableFuture<UserBase> sayHello6(String name) {
        UserBase userBase = new UserBase();
        userBase.setUsername(name);

        userBase.setPassword(idGenerator.generateId().toString());

        return new AsyncResult<>(userBase);
    }
    IdGenerator idGenerator = new IdGenerator() {
        @Override
        public UUID generateId() {
            UUID uuid = new UUID(1000l,2000l);
            long leastSignificantBits = uuid.getLeastSignificantBits();
            long mostSignificantBits = uuid.getMostSignificantBits();
            System.out.println(leastSignificantBits+"-"+mostSignificantBits);
            return uuid;
        }
    };
}
