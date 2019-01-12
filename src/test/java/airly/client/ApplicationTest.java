package airly.client;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTest {

    @Autowired
    ApplicationProperties applicationProperties;

    @Autowired
    AirlyProperties airlyProperties;

    @Test
    public void contextShouldStart() {
    }

    @Test
    public void urlPropertyShouldBeRead() {
        assertThat(applicationProperties.getApiUrl()).isNotEmpty();
    }

    @Test
    public void keyPropertyShouldBeRead() {
        assertThat(airlyProperties.getKey()).isNotEmpty();
    }

}
