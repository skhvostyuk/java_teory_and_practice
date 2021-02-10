package theory.spring.async;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class Scheduler {
    private final AsyncWriter asyncWriter;

    @Scheduled(fixedDelay = 1000)
    public void scheduledWrite() {
        log.info("Scheduler");
        for(int i = 0; i < 10; i++) {
            asyncWriter.asyncWrite();
        }
    }
}
