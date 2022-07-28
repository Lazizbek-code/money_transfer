package lazizbek.uz.money_transfer.payload;

import javax.validation.constraints.NotNull;

public class SignInDto {
    @NotNull(message = "username bo'sh bo'lmasligi kerak")
    private String username;

    @NotNull(message = "password bo'sh bo'lmasligi kerak")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
