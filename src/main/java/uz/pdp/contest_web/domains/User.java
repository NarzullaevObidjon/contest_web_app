package uz.pdp.contest_web.domains;

import jakarta.persistence.*;
import jdk.jfr.Timestamp;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "users")
@Table(name = "users", uniqueConstraints = @UniqueConstraint(columnNames = {"username", "email"}))
@Setter
@Getter
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class User implements BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
    private String firstName;
    private String lastName;
    @Enumerated(EnumType.STRING)
    private Status status;
    @CreationTimestamp
    private LocalDateTime createdAt;
    private Long points;
    private String country;
    @Enumerated(EnumType.STRING)
    private Role role;
    @Timestamp
    private LocalDateTime blockedTill;
    @OneToOne
    private Document photoDocumentId;
    @OneToMany(mappedBy = "user")
    private Set<Certificate> certificates;
    @OneToMany(mappedBy = "user")
    private Set<ResultUser> resultUsers;


    public enum Role {
        USER, ADMIN, SUPER_ADMIN
    }

    public enum Status {
        DELETED,
        BLOCKED,
        NOT_ACTIVE,
        ACTIVE
    }
    @PrePersist
    private void init(){
        this.status = Status.NOT_ACTIVE;
        this.role = Role.USER;
        this.points=0l;
        this.certificates= new HashSet<>();
    }
}
