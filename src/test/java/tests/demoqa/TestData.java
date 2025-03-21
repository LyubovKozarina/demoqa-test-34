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
    public final String gender = getRandomValue(new String[]{"Male", "Female", "Other"});
    public final String subject = getRandomValue(new String[]{"Maths", "Physics", "English", "History", "Computer Science"});
    public final String hobby = getRandomValue(new String[]{"Sports", "Reading", "Music"});
    public final String state = getRandomValue(new String[]{"NCR", "Haryana", "Uttar Pradesh", "Rajasthan"});
    public final String city = generateRandomCity(state);
    public final String birthDay = String.valueOf(random.nextInt(28) + 1);
    public final String birthMonth = getRandomMonth();
    public final String birthYear = String.valueOf(faker.number().numberBetween(1970, 2010));


    private static String getRandomValue(String[] array) {
        return array[random.nextInt(array.length)];
    }

    private static String getRandomMonth() {
        String[] months = {
                "January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"
        };
        return months[random.nextInt(months.length)];
    }

    private static String generateRandomCity(String state) {
        return switch (state) {
            case "NCR" -> getRandomValue(new String[]{"Delhi", "Gurgaon", "Noida"});
            case "Haryana" -> getRandomValue(new String[]{"Karnal", "Panipat"});
            case "Uttar Pradesh" -> getRandomValue(new String[]{"Agra", "Lucknow", "Merrut"});
            case "Rajasthan" -> getRandomValue(new String[]{"Jaipur", "Jaiselmer"});
            default -> "Unknown";
        };
    }
}
