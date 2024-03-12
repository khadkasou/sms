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
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class SMSImpl implements SMSService {

    private final SMSRepository smsRepository;
    private final SMSConnector smsConnector;

    private static final Integer SUCCESS_STATUS_CODE = 100;
    private static final Integer FAILURE_STATUS_CODE = 500;

    @Override
    public Response save(SMSRequest smsRequest) {
        try {
            SMS sms = SMSMapper.INSTANCE.toEntity(smsRequest);
            BaseResponse baseResponse = smsConnector.sendSMS(smsRequest);
            Response response = new Response();

            handleSMSResponse(sms, baseResponse, response);

            smsRepository.save(sms);
            return response;
        } catch (Exception e) {
            log.error("Error saving SMS: {}", e.getMessage(), e);
            return null;
        }
    }


    private void handleSMSResponse(SMS sms, BaseResponse baseResponse, Response response) {
        try {
            if (baseResponse != null && SUCCESS_STATUS_CODE.equals(baseResponse.getResponseCode())) {
                sms.setStatus(baseResponse.getResponseCode());
                sms.setMessage(sms.getMessage());
                sms.setResponseMessage(baseResponse.getResponseDescription());
                sms.setReceiverNo(sms.getReceiverNo());

                response.setMessage(baseResponse.getResponseDescription());
                response.setSuccess(true);
                response.setCode(baseResponse.getResponseCode());

            } else {
                sms.setStatus(FAILURE_STATUS_CODE);
                sms.setResponseMessage("Failed to send message");

                response.setMessage(baseResponse.getResponseDescription());
                response.setCode(baseResponse.getResponseCode());
            }
        } catch (Exception e) {
            log.error("Error handling SMS response: {}", e.getMessage(), e);
            }
    }


}






