package com.swifttech.sms.dto.response;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class SMSResponse {
    private String isClientLogin;
    private String receiverNo;
    private String message;
    private String username;
    private String password;
    private String organisationCode;

}
