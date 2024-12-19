package ch.sectioninformatique.template.security;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PermissionRepository extends CrudRepository<Permission, Integer> {
    Optional<Role> findByName(PermissionEnum name);
}
