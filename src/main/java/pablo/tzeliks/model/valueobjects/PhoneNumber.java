package pablo.tzeliks.model.valueobjects;

import org.apache.commons.lang3.math.NumberUtils;
import pablo.tzeliks.exception.InvalidPhoneNumber;

public class PhoneNumber {

    private String phoneNumber;

    public PhoneNumber(String phoneNumber) {

        if (phoneNumber.isBlank()) {
            throw new InvalidPhoneNumber("Phone Number cannot be empty");
        }

        if (phoneNumber.length() != 11) {
            throw new InvalidPhoneNumber("Phone Number cannot be more or less than 11 characters");
        }

        if (!NumberUtils.isCreatable(phoneNumber)) {
            throw new InvalidPhoneNumber("Only use numbers in Phone Number field");
        }

    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

}
