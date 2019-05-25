package com.elibrarysecurity.projectsecurity.mock;

import com.elibrarysecurity.projectsecurity.model.User;
import com.elibrarysecurity.projectsecurity.model.UserType;
import com.elibrarysecurity.projectsecurity.repository.RoleRepository;
import com.elibrarysecurity.projectsecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;

@Service
@Transactional
public class CreateData {
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    public void createMockData() {
        User user = new User();
        user.setEmail("1@1.com");
        user.setUsername("1");
        user.setFirstname("firstName");
        user.setLastname("lastName");
        user.setPassword(passwordEncoder.encode("1"));
        UserType r = new UserType();
        r.setUserTypeName("ROLE_ADMIN");
//        r.getUsers().add(user);
        UserType r1 = new UserType();
//        r1.getUsers().add(user);
        r1.setUserTypeName("ROLE_USER");
        user.setRoles(Arrays.asList(r,r1));
        this.userRepository.save(user);
    }

    public User createUser(User user) {

        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        Role r = new Role();
//        r.setName("ADMIN");
////        r.getUsers().add(user);
//        Role r1 = new Role();
////        r1.getUsers().add(user);
//        r1.setName("USER");
//        user.setRoles(Arrays.asList(r,r1));
        user.setRoles(this.roleRepository.findAll());
       return this.userRepository.save(user);

    }
}
