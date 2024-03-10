package com.swifttech.sms.service;

import com.swifttech.sms.dto.request.SMSRequest;
import com.swifttech.sms.model.SMS;

public interface SMSService {

    void save(SMSRequest smsRequest);

}
