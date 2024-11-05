package guru.springframework.json;

import java.util.regex.Pattern;

public class Contact {
    private String name;
    private String surname;
    private String phoneNumber;

    public Contact(String name, String surname, String phoneNumber) {
        this.name = name;
        this.surname = surname;
        setPhoneNumber(phoneNumber);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhoneNumber() {
        return phoneNumber.isEmpty() ? "[no number]" : phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (isValidPhoneNumber(phoneNumber)) {
            this.phoneNumber = phoneNumber;
        } else {
            this.phoneNumber = "";
            System.out.println("Wrong number format!");
        }
    }

    public boolean hasNumber() {
        return !phoneNumber.isEmpty();
    }

    private boolean isValidPhoneNumber(String phoneNumber) {
        String regex = "^[+]?(\\(?\\w+\\)?)([\\s-]\\(?\\w{2,}\\)?)*$";
        return Pattern.matches(regex, phoneNumber);
    }

    @Override
    public String toString() {
        return name + " " + surname + ", " + getPhoneNumber();
    }
}
