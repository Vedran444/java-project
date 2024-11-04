package utils;

import java.io.*;

public class FileRead {

    public static boolean login(String username, String password) {

        String filePath = "src/main/java/utils/admin.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            String storedUsername;
            String storedPassword;

            while ((storedUsername = br.readLine()) != null &&
                    (storedPassword = br.readLine()) != null) {

                if (storedUsername.equals(username) && PasswordHash.checkPassword(password, storedPassword.trim())) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }

        public static boolean login2(String username, String password){


            String filePath = "src/main/java/utils/user.txt";

            try (BufferedReader buffer = new BufferedReader(new FileReader(new File(filePath)))) {
                String storedUsername;
                String storedPassword;

                while ((storedUsername = buffer.readLine()) != null &&
                        (storedPassword = buffer.readLine()) != null) {

                    if (storedUsername.equals(username) && PasswordHash.checkPassword(password, storedPassword.trim())) {
                        return true;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            return false;
        }




    public static void registerUser(String username, String password) {
        File userFile = new File("src/main/java/utils/user.txt");
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(userFile, true))) {
            String hashedPassword = PasswordHash.hashPassword(password);
            bw.write(username);
            bw.newLine();
            bw.write(hashedPassword);
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void registerAdmin(String username) {


        File userFile = new File("src/main/java/utils/admin.txt");

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(userFile, true))) {
            String hashedPassword = PasswordHash.hashPassword("root");
            bw.write(username);
            bw.newLine();
            bw.write(hashedPassword);
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
