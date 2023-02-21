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
public class ResultQuestion implements BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Byte given;
    private Boolean correct;
    @ManyToOne
    private Question question;
    @ManyToOne
    private User user;
}


