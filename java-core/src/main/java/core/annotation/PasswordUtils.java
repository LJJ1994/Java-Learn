package main.java.core.annotation;

import java.util.List;

public class PasswordUtils {
    @UseCase(id=47, description = "password must contain a numeric.")
    public boolean validatePassword(String password){
        return password.matches("\\w*\\d\\w*");
    }

    @UseCase(id=48)
    public String encryptPassword(String password){
        return new StringBuilder(password).reverse().toString();
    }

    @UseCase(id=49, description = "New passwords can’t equal previously used ones")
    public boolean checkForPassword(List<String> prevPasswords, String password){
        return !prevPasswords.contains(password);
    }
}
