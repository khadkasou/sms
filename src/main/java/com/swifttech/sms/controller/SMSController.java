package com.swifttech.sms.controller;

import com.swifttech.sms.dto.request.SMSRequest;
import com.swifttech.sms.model.SMS;
import com.swifttech.sms.response.BaseResponse;
import com.swifttech.sms.service.SMSService;
import lombok.RequiredArgsConstructor;
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
    public BaseResponse save(@RequestBody SMSRequest smsRequest){

        SMS sms = service.save(smsRequest);
        return BaseResponse.builder().responseCode(100).responseDescription("messange sent succesfully")
                .build();
    }
}
