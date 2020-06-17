package com.example.bmd.config;

import com.example.bmdb.domain.User;
import com.example.bmdb.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@org.springframework.stereotype.Service
public class BmdbUserDetailsService implements UserDetailsService {

    @Autowired
    public Service bmdbService;

    @Autowired
    public BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    //@Transactional
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        // TODO not found exception handling

        try {
            User user = bmdbService.findUserbyEmail(email);
            user.setPassWord(bCryptPasswordEncoder.encode("admin"));
            BmdbUserDetails userDetails = new BmdbUserDetails();
            userDetails.setPassword(user.getPassWord());
            userDetails.setUsername(user.getEmail());

            return  userDetails;

        } catch (UsernameNotFoundException e){
            System.out.println(e.getMessage());
            return null;
        }

    }
}
