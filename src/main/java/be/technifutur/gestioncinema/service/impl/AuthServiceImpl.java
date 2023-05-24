package be.technifutur.gestioncinema.service.impl;

import be.technifutur.gestioncinema.exception.FormValidationException;
import be.technifutur.gestioncinema.jwt.JwtProvider;
import be.technifutur.gestioncinema.model.dto.JWTHolderDTO;
import be.technifutur.gestioncinema.model.entity.User;
import be.technifutur.gestioncinema.model.form.LoginForm;
import be.technifutur.gestioncinema.model.form.RegistrationForm;
import be.technifutur.gestioncinema.repository.UserRepository;
import be.technifutur.gestioncinema.service.AuthService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder encoder;
    private final AuthenticationManager authManager;
    private final JwtProvider jwtProvider;

    public AuthServiceImpl(
            UserRepository userRepository,
            PasswordEncoder encoder,
            AuthenticationManager authManager,
            JwtProvider jwtProvider) {
        this.userRepository = userRepository;
        this.encoder = encoder;
        this.authManager = authManager;
        this.jwtProvider = jwtProvider;
    }

    @Override
    public void register(RegistrationForm form) {

        if( userRepository.existsByUsername(form.getUsername()) )
            throw new FormValidationException("Nom d'utilisateur indisponible");

        User user = form.toEntity();

        user.setPassword( encoder.encode(user.getPassword()) );

        userRepository.save( user );

    }

    @Override
    public JWTHolderDTO login(LoginForm form) {

        Authentication auth = new UsernamePasswordAuthenticationToken(
                form.getUsername(),
                form.getPassword()
        );

        auth = authManager.authenticate( auth );

        String token = jwtProvider.createToken( auth );

        System.out.println("***********************************************");
        System.out.println(token);
        System.out.println("***********************************************");

        return new JWTHolderDTO( token );

    }
}
