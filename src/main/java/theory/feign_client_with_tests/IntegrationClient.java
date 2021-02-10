package theory.feign_client_with_tests;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "integrationClient", url = "http://localhost:9000")
public interface IntegrationClient {
    @GetMapping("/hello")
    String getHello();

}

