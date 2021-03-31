package org.upgrad.upstac.testrequests;

import io.swagger.models.auth.In;
import lombok.Getter;
import lombok.Setter;
import org.upgrad.upstac.users.models.Gender;

@Getter
@Setter
public class TestRequestInput {

    String name;
    Gender gender;
    String address;
    Integer age;
    String email;
    private String phoneNumber;
    private Integer pinCode;
}
