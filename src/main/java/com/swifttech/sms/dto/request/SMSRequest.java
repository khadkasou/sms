package com.swifttech.sms.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SMSRequest {

    private String isClientLogin;
    private String receiverNo;
    private String message;
    private String username;
    private String password;
    private String organisationCode;
}
