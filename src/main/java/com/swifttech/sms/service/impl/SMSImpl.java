package com.swifttech.sms.service.impl;

import com.swifttech.sms.dto.request.SMSRequest;
import com.swifttech.sms.mapper.SMSMapper;
import com.swifttech.sms.model.SMS;
import com.swifttech.sms.repository.SMSRepository;
import com.swifttech.sms.service.SMSService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SMSImpl implements SMSService {

    private final SMSRepository smsRepository;

    @Override
    public SMS save(SMSRequest smsRequest) {
        SMS sms = SMSMapper.INSTANCE.toEntity(smsRequest);
        return this.smsRepository.save(sms);
    }
}
