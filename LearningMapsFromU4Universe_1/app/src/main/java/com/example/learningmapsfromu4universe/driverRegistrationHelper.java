package com.example.learningmapsfromu4universe;

public class driverRegistrationHelper {


    public String DriverName,
            Address,
            Email,
            Password,
            PhoneNumber,
            LicenseNumber;

    public driverRegistrationHelper() {

    }

    public driverRegistrationHelper(String driverName, String address, String email,
                                    String password, String phoneNumber,
                                    String licenseNumber) {
        DriverName = driverName;
        Address = address;
        Email = email;
        Password = password;
        PhoneNumber = phoneNumber;
        LicenseNumber = licenseNumber;
    }
}
