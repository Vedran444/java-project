package file.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Optional;

public class FileRead {

    public static boolean login(String username, String password) {


        File AdminFile=new File("file.utils/admin.txt");
        try (BufferedReader br = new BufferedReader(new FileReader(AdminFile))) {

            Optional<String> storedUsername;

            while ((storedUsername = Optional.ofNullable(br.readLine())).isPresent()) {
                String HashedPassword = Optional.ofNullable(br.readLine()).orElse("").trim();

                if (username.equals(storedUsername.orElse("")) && PasswordHash.checkPassword(password, HashedPassword)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }



    public static boolean login2(String username, String password) {


        File UserFile=new File("file.utils/user.txt");
        try (BufferedReader buffer = new BufferedReader(new FileReader(UserFile))) {

            Optional<String> storedUsername;

            while ((storedUsername = Optional.ofNullable(buffer.readLine())).isPresent()) {
                String HashedPassword = Optional.ofNullable(buffer.readLine()).orElse("").trim();

                if (username.equals(storedUsername.orElse("")) && PasswordHash.checkPassword(password, HashedPassword)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }
}
