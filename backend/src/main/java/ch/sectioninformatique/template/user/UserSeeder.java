package ch.sectioninformatique.template.user;

import ch.sectioninformatique.template.security.Role;
import ch.sectioninformatique.template.security.RoleEnum;
import ch.sectioninformatique.template.security.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserSeeder implements CommandLineRunner {
        
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private RoleRepository roleRepository;

    public UserSeeder(UserRepository userRepository, PasswordEncoder passwordEncoder, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadUserData();
    }

    private void loadUserData() {
        if (userRepository.count() == 0) {

            Optional<Role> optionalRole = roleRepository.findByName(RoleEnum.USER);
            
            User user1 = new UserBuilder()
                    .setFirstName("John")
                    .setLastName("DOE")
                    .setEmail("john.doe@test.com")
                    .setPassword(passwordEncoder.encode("qwertz"))
                    .setRole(optionalRole.get())
                    .build();

            User user2 = new UserBuilder()
                    .setFirstName("Jane")
                    .setLastName("SMITH")
                    .setEmail("jane.smith@test.com")
                    .setPassword(passwordEncoder.encode("qwertz"))
                    .setRole(optionalRole.get())
                    .build();

            User user3 = new UserBuilder()
                    .setFirstName("Alice")
                    .setLastName("JOHNSON")
                    .setEmail("alice.johnson@test.com")
                    .setPassword(passwordEncoder.encode("qwertz"))
                    .setRole(optionalRole.get())
                    .build();

            userRepository.save(user1);
            userRepository.save(user2);
            userRepository.save(user3);
        }
    }
}