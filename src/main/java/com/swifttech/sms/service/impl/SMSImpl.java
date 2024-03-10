package com.swifttech.sms.service.impl;

import com.swifttech.sms.dto.request.SMSRequest;
import com.swifttech.sms.mapper.SMSMapper;
import com.swifttech.sms.model.SMS;
import com.swifttech.sms.repository.SMSRepository;
import com.swifttech.sms.response.BaseResponse;
import com.swifttech.sms.response.Response;
import com.swifttech.sms.service.SMSService;
import com.swifttech.sms.utils.SMSConnector;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SMSImpl implements SMSService {

    private final SMSRepository smsRepository;
    private final SMSConnector smsConnector;

    @Override
    public Response save(SMSRequest smsRequest) {

        SMS sms = SMSMapper.INSTANCE.toEntity(smsRequest);

        BaseResponse baseresponse = smsConnector.sendSMS(smsRequest);
        Response response = new Response();
        if (baseresponse != null && baseresponse.getResponseCode() != 100) {

            sms.setStatus(String.valueOf(baseresponse.getResponseCode()));
            sms.setMessage(smsRequest.getMessage());
            sms.setResponseMessage(baseresponse.getResponseDescription());
            sms.setReceiverNo(smsRequest.getReceiverNo());

            response.setMessage(baseresponse.getResponseDescription());
            response.setCode(String.valueOf(baseresponse.getResponseCode()));
        }
        else {
            sms.setStatus("500");
            sms.setResponseMessage("Failed to send message");

            response.setMessage("Failed to send message");
            response.setCode("500");

        }
        smsRepository.save(sms);
        return response;

    }
}
