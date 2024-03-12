package com.swifttech.sms.response;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BaseResponse {

   private Integer responseCode;
   private String responseDescription;
}
