package com.swifttech.sms.mapper;

import com.swifttech.sms.dto.request.SMSRequest;
import com.swifttech.sms.dto.response.SMSResponse;
import com.swifttech.sms.model.SMS;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SMSMapper {

    SMSMapper INSTANCE = Mappers.getMapper(SMSMapper.class);


      SMS toEntity(SMSRequest smsRequest);

      SMSResponse toDto(SMS sms);

}
