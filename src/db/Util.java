package db;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Util {

    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public static final Pattern VALID_DATE_REGEX =
            Pattern.compile("^[0-9]{2}+/[0-9]{2}+/[0-9]{4}$", Pattern.CASE_INSENSITIVE);

    public static boolean validateEmail(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.find();
    }

    public static boolean validateName(String name) {
        return name.length() >= 3;
    }

    public static boolean validDate(String str) {
        Matcher matcher = VALID_DATE_REGEX.matcher(str);
        return matcher.find();
    }

}
