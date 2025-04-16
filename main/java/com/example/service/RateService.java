package com.example.service;
import com.example.dto.RateRequestDTO;
import com.example.dto.RateResponseDTO; 
import com.example.entity.RateResponseEntity; 
import com.example.repository.RateResponseRepository;
import org.springframework.http.*; 
import org.springframework.stereotype.Service; 
import org.springframework.web.client.RestTemplate;

@Service 
public class RateService {

private final RestTemplate restTemplate = new RestTemplate();
private final RateResponseRepository repository = new RateResponseRepository();

public RateResponseDTO calculateRate(RateRequestDTO requestDTO) {
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    headers.set("accept", "application/json, text/plain, /");

    HttpEntity<RateRequestDTO> entity = new HttpEntity<>(requestDTO, headers);

    ResponseEntity<String> response = restTemplate.exchange(
        "https://appapinew.bigship.in/api/RateCalculate",
        HttpMethod.POST,
        entity,
        String.class
    );

    // Save response in mock DB
    RateResponseEntity rateEntity = new RateResponseEntity();
    rateEntity.status = response.getStatusCode().toString();
    rateEntity.responseJson = response.getBody();
    repository.save(rateEntity);

    RateResponseDTO rateResponse = new RateResponseDTO();
    rateResponse.status = rateEntity.status;
    rateResponse.data = response.getBody();

    return rateResponse;
}

}
