package ch.sectioninformatique.template.admin;

import ch.sectioninformatique.template.auth.RegisterUserDto;
import ch.sectioninformatique.template.user.User;
import ch.sectioninformatique.template.user.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/admins")
@RestController
public class AdminController {
    private final UserService userService;

    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    @PreAuthorize("hasRole('SUPER_ADMIN')")
    public ResponseEntity<User> createAdministrator(@RequestBody RegisterUserDto registerUserDto) {
        User createdAdmin = userService.createAdministrator(registerUserDto);
        return ResponseEntity.ok(createdAdmin);
    }
}
