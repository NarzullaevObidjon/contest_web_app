package uz.pdp.contest_web.domains;

import jakarta.persistence.*;
import jdk.jfr.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "tests")
public class Test implements BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @ManyToOne
    private User creator_id;
    @OneToMany(mappedBy = "test")
    private List<Question> questions;
    @OneToMany(mappedBy = "test")
    private Set<Certificate> certificates;
    @OneToMany(mappedBy = "test")
    private Set<ResultUser> resultUsers;


    public String parseDate() {
        return this.startTime.format(DateTimeFormatter.ofPattern("dd - MMM yyyy HH:mm"));
    }
    public String getPrettyInterval(){
         long i=  this.interval / 1000 / 60;
         return i+" minutes";
    }
}
