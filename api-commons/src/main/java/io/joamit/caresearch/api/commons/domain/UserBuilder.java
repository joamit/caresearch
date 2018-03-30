package io.joamit.caresearch.api.commons.domain;

public final class UserBuilder {
    private String id;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String address;
    private Country country;
    private String emailId;
    private String phone;

    private UserBuilder() {
    }

    public static UserBuilder anUser() {
        return new UserBuilder();
    }

    public UserBuilder withId(String id) {
        this.id = id;
        return this;
    }

    public UserBuilder withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public UserBuilder withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public UserBuilder withUsername(String username) {
        this.username = username;
        return this;
    }

    public UserBuilder withPassword(String password) {
        this.password = password;
        return this;
    }

    public UserBuilder withAddress(String address) {
        this.address = address;
        return this;
    }

    public UserBuilder withCountry(Country country) {
        this.country = country;
        return this;
    }

    public UserBuilder withEmailId(String emailId) {
        this.emailId = emailId;
        return this;
    }

    public UserBuilder withPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public User build() {
        User user = new User();
        user.setId(id);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setUsername(username);
        user.setPassword(password);
        user.setAddress(address);
        user.setCountry(country);
        user.setEmailId(emailId);
        user.setPhone(phone);
        return user;
    }
}
