package theory.feign_client_with_tests;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class MockIntegrationClient implements IntegrationClient{

    @Override
    public String getHello() {
        return "Your mock logic";
    }
}
