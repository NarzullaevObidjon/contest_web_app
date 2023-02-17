package uz.pdp.contest_web.domains;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResultUser implements BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private User userId;
    @ManyToOne
    private Test test_id;
    private Long interval;
    private Long points;
}


