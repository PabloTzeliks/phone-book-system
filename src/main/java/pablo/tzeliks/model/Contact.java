package pablo.tzeliks.model;

import pablo.tzeliks.model.valueobjects.Email;
import pablo.tzeliks.model.valueobjects.PhoneNumber;

public class Contact {

    private long id;
    private String name;
    private PhoneNumber phoneNumber;
    private Email email;
    private String observation;

    // DB Insertion
    public Contact(Email email, String observation, PhoneNumber phoneNumber, String name) {
        this.email = email;
        this.observation = observation;
        this.phoneNumber = phoneNumber;
        this.name = name;
    }

    // DB Extraction
    public Contact(long id, Email email, String observation, PhoneNumber phoneNumber, String name) {
        this.id = id;
        this.email = email;
        this.observation = observation;
        this.phoneNumber = phoneNumber;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(PhoneNumber phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }
}
