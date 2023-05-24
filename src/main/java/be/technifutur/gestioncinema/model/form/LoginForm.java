package be.technifutur.gestioncinema.model.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class LoginForm {

    @NotBlank
    private String username;
    @NotBlank
    private String password;

}