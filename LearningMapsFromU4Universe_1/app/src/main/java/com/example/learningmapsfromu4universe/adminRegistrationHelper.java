package com.example.learningmapsfromu4universe;

public class adminRegistrationHelper {

    public String AdminName,
            Address,
            Email,
            Password,
            PhoneNumber;


    public adminRegistrationHelper() {

    }


    public adminRegistrationHelper(String adminName, String address,
                                   String email, String password,
                                   String phoneNumber) {
        AdminName = adminName;
        Address = address;
        Email = email;
        Password = password;
        PhoneNumber = phoneNumber;
    }
}
