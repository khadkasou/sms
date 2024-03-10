package com.swifttech.sms.controller;

import com.swifttech.sms.dto.request.SMSRequest;
import com.swifttech.sms.response.Response;
import com.swifttech.sms.service.SMSService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sms")
@RequiredArgsConstructor
public class SMSController {

    private final SMSService service;

    @PostMapping("/save")
    public ResponseEntity<Response> save(@RequestBody SMSRequest smsRequest) {
        service.save(smsRequest);
        return ResponseEntity.ok(new Response("SMS SEND SUCCESSFULLY"));
    }
}
