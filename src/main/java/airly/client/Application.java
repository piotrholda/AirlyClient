package airly.client;

import airly.client.entity.Measurements;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@EnableConfigurationProperties({ApplicationProperties.class, AirlyProperties.class})
public class Application {

    public static void main(String... args) {
        ApplicationContext context = SpringApplication.run(Application.class);
        AirlyService airlyService = context.getBean(AirlyService.class);
        Measurements measurements = airlyService.getMeasurements(479/*474*//*65*//*2052*/);
        System.out.println(measurements);
    }

}
