package com.swifttech.sms.utils;

import com.swifttech.sms.dto.request.CredentialRequest;
import com.swifttech.sms.dto.request.SMSRequest;
import com.swifttech.sms.response.BaseResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@RequiredArgsConstructor
@Service
@Slf4j
public class SMSConnector {

    private final WebClient.Builder webClient;

    private static final Integer SUCCESS_STATUS_CODE = 100;


    public BaseResponse sendSMS(SMSRequest smsRequest) {
        try {
            CredentialRequest credentialRequest =
                    new CredentialRequest("N",
                            "RemitTest",
                            "Remit@Test123",
                            "RemitTest",
                            smsRequest.getReceiverNo(),
                            smsRequest.getMessage());

            HttpHeaders headers = new HttpHeaders();
            headers.add("OrganisationCode", "RemitTest");
            headers.add("Content-Type", "application/json");
            headers.add("Authorization", "Basic UmVtaXRUZXN0OlJlbWl0QFRlc3QxMjM=");
            BaseResponse response = webClient.build()
                    .post()
                    .uri("https://fastapi.swifttech.com.np:8080/api/Sms/ExecuteSendSms")
                    .headers(h -> h.addAll(headers))
                    .bodyValue(credentialRequest)
                    .retrieve()
                    .bodyToMono(BaseResponse.class)
                    .block();

            if (response != null && !SUCCESS_STATUS_CODE.equals(response.getResponseCode())) {
                throw new RuntimeException("SMS sent failed. Response: " + response);
            }

            log.info("RESPONSE {}", response);
            return response;
        } catch (Exception e) {
            log.error("Error sending SMS: {}", e.getMessage(), e);

            return null;
        }
    }

}
