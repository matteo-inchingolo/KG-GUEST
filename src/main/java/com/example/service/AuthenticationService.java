package com.example.service;

import com.example.auth.AuthenticationRequest;
import com.example.auth.AuthenticationResponse;
import com.example.auth.RegisterRequest;
import com.example.model.Auth;
import com.example.model.Token;
import com.example.model.Role;
import com.example.repository.AuthRepository;
import com.example.repository.TokenRepository;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
/*import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;*/
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    
    private final AuthRepository authRepository;
    private final TokenRepository tokenRepository;
    
    public AuthenticationResponse login(AuthenticationRequest auth){
        List<Auth> authOpt = authRepository.findAll().stream().filter(prdct -> (prdct.getMail() == null ? auth.getEmail() == null : prdct.getMail().equals(auth.getEmail()))).toList();
        if(!authOpt.isEmpty()){
            Token tk = new Token();
            tk.setId(authOpt.get(0).getId());
            tk.setToken(UUID.randomUUID().toString());
            
            tokenRepository.save(tk);
            
            AuthenticationResponse response = new AuthenticationResponse();
            response.setName(authOpt.get(0).getName());
            response.setToken(tk.getToken());
            return response;
        }
        
        throw new RuntimeException("Utente non autorizzato");
    }
    
    public boolean logout(String token){
        List<Token> tokenOpt = tokenRepository.findAll().stream().filter(prdct -> (prdct.getToken().equals(token))).toList();
        
        if(!tokenOpt.isEmpty()){
            
            tokenRepository.deleteById(tokenOpt.get(0).getId());
            return true;
        }
        
        throw  new RuntimeException("Utente non autenticato");
    }
    
    public boolean isAuthorized(String token){
        List<Token> tokenOpt = tokenRepository.findAll().stream().filter(prdct -> (prdct.getToken().equals(token(token)))).toList();
        return !tokenOpt.isEmpty();
    }
    
    public String token(String header){
        String token = "";
        
        String[] splitted = header.split(" ");
        if(splitted.length > 1){
            token = splitted[1];
        }
        
        return token;
    }
    
    public boolean hasToken(Auth auth){
        List<Token> tokenOpt = tokenRepository.findAll().stream().filter(prdct -> (prdct.getId().equals(auth.getId()))).toList();
        return !tokenOpt.isEmpty();
    }

    /*private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) {

        User user = User.builder()
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();

        userRepository.save(user);

        String jwtToken = jwtService.generateToken(user);

        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();

    }

    public AuthenticationResponse authenticate(RegisterRequest request) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow();

        return null;

    }*/
}
