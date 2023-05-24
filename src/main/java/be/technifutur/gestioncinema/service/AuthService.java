package be.technifutur.gestioncinema.service;

import be.technifutur.gestioncinema.model.dto.JWTHolderDTO;
import be.technifutur.gestioncinema.model.form.LoginForm;
import be.technifutur.gestioncinema.model.form.RegistrationForm;

public interface AuthService {

    void register( RegistrationForm form );

    JWTHolderDTO login(LoginForm form );

}