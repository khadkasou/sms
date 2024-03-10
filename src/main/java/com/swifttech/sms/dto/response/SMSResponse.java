package com.swifttech.sms.dto.response;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class SMSResponse {
    private String receiverNo;
    private String message;


}
