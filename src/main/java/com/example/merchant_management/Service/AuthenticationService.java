package com.example.merchant_management.Service;
import java.util.HashSet;
import java.util.Set;


import com.example.merchant_management.Repository.RoleRepository;
import com.example.merchant_management.Repository.AdminRepository;
import com.example.merchant_management.model.Admin;
import com.example.merchant_management.model.LoginResponseDTO;
import com.example.merchant_management.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
@Transactional
public class AuthenticationService {


    @Autowired
    private AdminRepository adminRepository;


    @Autowired
    private RoleRepository roleRepository;


    @Autowired
    private PasswordEncoder passwordEncoder;


    @Autowired
    private AuthenticationManager authenticationManager;


    @Autowired
    private TokenService tokenService;


    public Admin registerUser(String username, String password){


        String encodedPassword = passwordEncoder.encode(password);
        Role userRole = roleRepository.findByAuthority("USER").get();


        Set<Role> authorities = new HashSet<>();


        authorities.add(userRole);


        return adminRepository.save(new Admin(0, username, encodedPassword, authorities));
    }


    public LoginResponseDTO loginUser(String username, String password){


        try{
            Authentication auth = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username, password)
            );


            String token = tokenService.generateJwt(auth);


            return new LoginResponseDTO(adminRepository.findByUsername(username).get(), token);


        } catch(AuthenticationException e){
            return new LoginResponseDTO(null, "");
        }
    }


}