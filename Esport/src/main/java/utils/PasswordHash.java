package utils;
import at.favre.lib.crypto.bcrypt.BCrypt;

public class PasswordHash {

    public static String hashPassword(String password) {

        String hashedPassword = BCrypt.withDefaults().hashToString(12, password.toCharArray());
        return hashedPassword;
    }

    public static boolean checkPassword(String enteredPassword, String storedPassword) {

        BCrypt.Result result = BCrypt.verifyer().verify(enteredPassword.toCharArray(), storedPassword);
        return result.verified;

    }


}