package uz.pdp.contest_web.domains;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Question implements BaseEntity{
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@ManyToOne
private Test test_id;
private String question;
@OneToOne
private Document photoDocumentId;
private String answers;
private Byte correctAnswerIndex;
}
