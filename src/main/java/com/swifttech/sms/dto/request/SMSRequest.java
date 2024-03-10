package com.swifttech.sms.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SMSRequest {
    private String receiverNo;
    private String message;
}
