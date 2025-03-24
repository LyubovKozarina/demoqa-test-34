package tests.demoqa;

import com.github.javafaker.Faker;
import java.util.Random;

public class TestData {
    private static final Faker faker = new Faker();
    private static final Random random = new Random();

    public final String firstName = faker.name().firstName();
    public final String lastName = faker.name().lastName();
    public final String email = faker.internet().emailAddress();
    public final String phoneNumber = faker.numerify("##########");
    public final String address = faker.address().fullAddress();
    public static final String picture = "test.jpg";
    public final String gender = faker.options().option("Male", "Female", "Other");
    public final String subject = faker.options().option("Maths", "Physics", "English", "History", "Computer Science");
    public final String hobby = faker.options().option("Sports", "Reading", "Music");
    public final String state = faker.options().option("NCR", "Haryana", "Uttar Pradesh", "Rajasthan");
    public final String city = switch (state) {
        case "NCR" -> faker.options().option("Delhi", "Gurgaon", "Noida");
        case "Haryana" -> faker.options().option("Karnal", "Panipat");
        case "Uttar Pradesh" -> faker.options().option("Agra", "Lucknow", "Merrut");
        case "Rajasthan" -> faker.options().option("Jaipur", "Jaiselmer");
        default -> "Unknown";
    };
    public final String birthDay = String.valueOf(faker.number().numberBetween(1, 29));
    public final String birthMonth = faker.options().option(
            "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"
    );
    public final String birthYear = String.valueOf(faker.number().numberBetween(1970, 2010));
    }
