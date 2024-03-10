package com.swifttech.sms.controller;

import com.swifttech.sms.dto.request.SMSRequest;
import com.swifttech.sms.model.SMS;
import com.swifttech.sms.service.SMSService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api")
public class SMSController {

    private final SMSService service;



    @PostMapping("/sms/save")
    public String sendSMS(@ModelAttribute SMSRequest smsRequest){
        SMS sms = service.save(smsRequest);

        return "sms";

    }

}
