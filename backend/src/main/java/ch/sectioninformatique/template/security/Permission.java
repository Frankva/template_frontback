package ch.sectioninformatique.template.security;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Data
@Table(name = "permissions")
@Entity
public class Permission {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Integer id;
    
    @Column(unique = true, nullable = false)
    @Enumerated(EnumType.STRING)
    private PermissionEnum name;
    
    @CreationTimestamp
    @Column(updatable = false, name = "created_at")
    private Date createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Date updatedAt;
}
