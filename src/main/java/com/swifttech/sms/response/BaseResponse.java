package com.swifttech.sms.response;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BaseResponse {

   private int responseCode;
   private String responseDescription;
}
