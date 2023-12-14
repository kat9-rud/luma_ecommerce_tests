package data;

import com.github.javafaker.Faker;

public class TestData {
    final Faker faker = new Faker();
    public final String firstName = faker.name().firstName();
    public final String lastName = faker.name().lastName();
    public final String email = faker.internet().emailAddress();
    public final String password = faker.internet()
            .password(8, 10, true, true, true);
    public final String streetAddress = faker.address().streetAddress();
    public final String city = faker.address().city();
    public final String state = faker.address().state();
    public final String zip = faker.address().zipCode();
    public final String country = faker.address().country();
    public final String phoneNumber = faker.phoneNumber().phoneNumber();
}
