package theory.spring.async;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AsyncWriter {
    @Async("threadPoolTaskExecutor")
    @SneakyThrows
    public void asyncWrite() {
        log.info("Hello! " + Thread.currentThread().getName());
        Thread.sleep(1000);
    }
}
