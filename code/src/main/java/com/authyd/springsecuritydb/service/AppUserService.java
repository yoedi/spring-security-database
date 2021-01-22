package com.authyd.springsecuritydb.service;

import com.authyd.springsecuritydb.model.User;
import com.authyd.springsecuritydb.model.builder.UserBuilder;
import com.authyd.springsecuritydb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AppUserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) throw new UsernameNotFoundException(username);

        return new UserBuilder()
                .setUsername(user.getUsername())
                .setPassword(user.getPassword())
                .setEnabled(user.isEnabled())
                .setAccountNonExpired(true)
                .setAccountNonLocked(true)
                .setCredentialsNonExpired(true)
                .build();
    }

    public User save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setUsername(user.getUsername());

        return userRepository.save(user);
    }

}
