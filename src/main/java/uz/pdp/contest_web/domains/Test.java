package uz.pdp.contest_web.domains;

import jakarta.persistence.*;
import jdk.jfr.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name="tests")
public class Test {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private Long number;
    @Column(nullable = false)
    private Byte questionCount;
    private Byte answersCount;
    @Timestamp
    private LocalDateTime startTime;
    @Timestamp
    private LocalDateTime endTime;
    private Long interval;
    @Basic(optional = false)
    private Long creator_id;
    @OneToMany(mappedBy ="test_id")
    private Set<Question> questions;
    @OneToMany(mappedBy = "test_id")
    private Set<Certificate> certificates;
    @OneToMany(mappedBy = "test_id")
    private Set<ResultUser> resultUsers;
}
