package com.simbirsoft.belousov.config;

import com.simbirsoft.belousov.entity.UserEntity;
import com.simbirsoft.belousov.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;


public class UserDetailsServiceImpl implements UserDetailsService {
    private UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByUserName(userName);
        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(userEntity.getName());
        Set<GrantedAuthority> grantedAuthorities= new HashSet<GrantedAuthority>();
        grantedAuthorities.add(grantedAuthority);
        return new User(userEntity.getName(),userEntity.getPassword(),grantedAuthorities);
    }
}
