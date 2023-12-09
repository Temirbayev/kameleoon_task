package com.temirbayev.kameleoon.config;

import com.temirbayev.kameleoon.model.Roles;
import com.temirbayev.kameleoon.model.Users;
import com.temirbayev.kameleoon.service.UsersService;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class KameleoonUsersDetails implements AuthenticationProvider {
    private UsersService usersService;

    private PasswordEncoder passwordEncoder;

    public KameleoonUsersDetails(UsersService usersService, PasswordEncoder passwordEncoder) {
        this.usersService = usersService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();
        List<Users> users = usersService.getGyName(username);
        ////////////////////////////////////////////////////////////////////проверка паролей
        String hashedPasswordFromDatabase = users.get(0).getPassword();
        System.out.println("/////////////////////////////////////////////////////////////////////");
        System.out.println(hashedPasswordFromDatabase);
        System.out.println(password);
        System.out.println(users.get(0).getRoles());
        ///////////////////////////////////////////////////////////////////
        if (users.size() > 0) {
            if (passwordEncoder.matches(password, users.get(0).getPassword())) {
                return new UsernamePasswordAuthenticationToken(username,password, getGrantedAuthorities(users.get(0).getRoles()));
            } else {
                throw new BadCredentialsException("Invalid password!");
            }
        }else {
            throw new BadCredentialsException("No user registered with this details!");
        }
    }
    private List<GrantedAuthority> getGrantedAuthorities(List<Roles> roles) {
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        for (Roles roles1 : roles) {
            grantedAuthorities.add(new SimpleGrantedAuthority(roles1.getRole()));
        }
        return grantedAuthorities;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }


//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        String userName,password = null;
//        List<GrantedAuthority> authorities = null;
//        List<Users> users = userRepository.findByName(username);
//        if (users.size() == 0){
//            throw new UsernameNotFoundException("User not found" + username);
//        }else {
//            userName = users.get(0).getName();
//            password = users.get(0).getPassword();
//            authorities = new ArrayList<>();
//            authorities.add(new SimpleGrantedAuthority(users.get(0).getRoles().toString()));
//        }
//        return new User(userName,password,authorities);
//    }

}
