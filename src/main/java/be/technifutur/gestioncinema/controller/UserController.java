package be.technifutur.gestioncinema.controller;

import be.technifutur.gestioncinema.model.dto.JWTHolderDTO;
import be.technifutur.gestioncinema.service.AuthService;
import be.technifutur.gestioncinema.model.form.LoginForm;
import be.technifutur.gestioncinema.model.form.RegistrationForm;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    private final AuthService authService;

    public UserController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public JWTHolderDTO login(@RequestBody @Valid LoginForm loginForm) {
        return authService.login(loginForm);
    }

    @PostMapping("/register")
    public void register(@RequestBody @Valid RegistrationForm registrationForm) {
        authService.register(registrationForm);
    }

}
