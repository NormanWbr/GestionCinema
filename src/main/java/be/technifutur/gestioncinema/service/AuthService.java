package be.technifutur.gestioncinema.service;

import be.technifutur.gestioncinema.model.dto.AuthDTO;
import be.technifutur.gestioncinema.model.form.LoginForm;

public interface AuthService {

    AuthDTO login(LoginForm form);

}
