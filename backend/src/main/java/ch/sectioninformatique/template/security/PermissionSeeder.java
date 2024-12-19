package ch.sectioninformatique.template.security;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Optional;

@Component
public class PermissionSeeder implements ApplicationListener<ContextRefreshedEvent> {
    private PermissionRepository permissionRepository;
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        
    }


    private void loadPermissions() {
        PermissionEnum[] permissionNames = new PermissionEnum[]{PermissionEnum.STUDENT_READ, PermissionEnum.COURSE_READ,
            PermissionEnum.COURSE_WRITE, PermissionEnum.STUDENT_WRITE, PermissionEnum.USER_READ,
            PermissionEnum.USER_WRITE};
        
        // TODO
        Arrays.stream(permissionNames).forEach((permissionName) -> {
            Optional<Role> optionalRole = permissionRepository.findByName(permissionName);
            optionalRole.ifPresentOrElse(System.out::println, () -> {
                Permission permissionToCreate = new Permission();
                permissionToCreate.setName(permissionName);
                permissionRepository.save(permissionToCreate);
            });
        });
    }
}
