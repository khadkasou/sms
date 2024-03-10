package com.swifttech.sms.model;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "sms")
public class SMS {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String isClientLogin;
    private String receiverNo;
    private String message;
    private String username;
    private String password;
    private String organisationCode;

}
