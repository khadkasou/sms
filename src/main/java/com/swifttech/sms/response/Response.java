package com.swifttech.sms.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response {

    private boolean success = true;
    private String message;
    private String code;
    private Integer statusCode;
    private Object data;

    public Response(String message, Object data) {
        this.message = message;

        this.data = data;
    }

    public Response(String message) {
        this.message = message;

    }

}
