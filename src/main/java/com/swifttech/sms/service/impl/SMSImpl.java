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
    public void save(SMSRequest smsRequest) {
        SMS sms = SMSMapper.INSTANCE.toEntity(smsRequest);
        BaseResponse response = smsConnector.sendSMS(smsRequest);
        sms.setStatus(String.valueOf(response.getResponseCode()));
        sms.setMessage(smsRequest.getMessage());
        sms.setResponseMessage(response.getResponseDescription());
        sms.setReceiverNo(smsRequest.getReceiverNo());
        smsRepository.save(sms);
    }
}
