package cn.clay.ngqualitymdl.web.component;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class AsyncComponment {

    @Async("threadPool")
    public void asyncTask() {
        
    }
}
