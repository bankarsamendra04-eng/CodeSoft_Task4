package quiz.util;

public class Validator {
    public static boolean isEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }
    public static boolean isNumeric(String str) {
        if (isEmpty(str)) return false;
        return str.matches("\\d+");
    }
}