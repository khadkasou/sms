package com.swifttech.sms.repository;

import com.swifttech.sms.model.SMS;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SMSRepository extends JpaRepository<SMS,Long> {


}
