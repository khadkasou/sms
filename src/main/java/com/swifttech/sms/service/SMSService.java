package com.swifttech.sms.service;

import com.swifttech.sms.dto.request.SMSRequest;
import com.swifttech.sms.model.SMS;
import com.swifttech.sms.response.Response;

public interface SMSService {

    Response save(SMSRequest smsRequest);

}
