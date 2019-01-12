package airly.client;

import airly.client.entity.Measurements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Service
public class AirlyService {

    private static final String MEASUREMENTS_URI = "/measurements/installation?installationId=";
    private static final MediaType[] ACCEPT = {MediaType.APPLICATION_JSON};

    @Autowired
    ApplicationProperties applicationProperties;

    @Autowired
    AirlyProperties airlyProperties;

    public Measurements getMeasurements(Integer installationId) {
        String url = applicationProperties.getApiUrl() + MEASUREMENTS_URI + installationId;
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(ACCEPT));
        headers.set("apikey", airlyProperties.getKey());
        HttpEntity<?> requestEntity = new HttpEntity<>(headers);
        RestTemplate template = new RestTemplate();
        ResponseEntity<Measurements> response = template.exchange(url, HttpMethod.GET, requestEntity, Measurements.class);
        return response.getBody();
    }

}
