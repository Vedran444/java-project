package file.utils;


import org.mindrot.jbcrypt.BCrypt;

public class PasswordHash {

    public static String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public static boolean checkPassword(String candidatePassword, String hashedPassword) {
        return BCrypt.checkpw(candidatePassword, hashedPassword);
    }
}
