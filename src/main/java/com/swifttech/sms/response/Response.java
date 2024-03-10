package com.swifttech.sms.response;

import lombok.*;

@Data
@Builder
public class Response<T> {

    private boolean success;
    private String message;
    private String code;

}
