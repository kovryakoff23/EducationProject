package com.Magazine.service;

import com.Magazine.entity.Role;
import com.Magazine.entity.User;
import com.Magazine.entity.UserAuthentification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.Magazine.repository.RoleRepository;
import com.Magazine.repository.UserRepositoryAuthentification;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceAuthentification implements UserDetailsService {
    @PersistenceContext
    private EntityManager em;
    @Autowired
    UserRepositoryAuthentification userRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserAuthentification user = userRepository.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return user;
    }

    public UserAuthentification loadUser(String username) throws UsernameNotFoundException {
        UserAuthentification user = userRepository.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return user;
    }

    public UserAuthentification findUserById(Long userId) {
        Optional<UserAuthentification> userFromDb = userRepository.findById(userId);
        return userFromDb.orElse(new UserAuthentification());
    }

    public List<UserAuthentification> allUsers() {
        return userRepository.findAll();
    }

    public boolean saveUser(@Valid UserAuthentification user) {
        UserAuthentification userFromDB = userRepository.findByUsername(user.getUsername());

        if (userFromDB != null) {
            return false;
        }

        user.setRoles(Collections.singleton(new Role(1L, "ROLE_USER")));
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return true;
    }

    public boolean deleteUser(Long userId) {
        if (userRepository.findById(userId).isPresent()) {
            userRepository.deleteById(userId);
            return true;
        }
        return false;
    }

    public List<UserAuthentification> usergtList(Long idMin) {
        return em.createQuery("SELECT u FROM User u WHERE u.id > :paramId", UserAuthentification.class)
                .setParameter("paramId", idMin).getResultList();
    }
}
