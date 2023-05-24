package be.technifutur.gestioncinema.model.form;

import be.technifutur.gestioncinema.model.entity.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RegistrationForm {

    @NotBlank
    private String username;
    @NotBlank
    @Size(min = 4)
    private String password;

    public User toEntity() {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.getRoles().add("USER");
        return user;

    }

}