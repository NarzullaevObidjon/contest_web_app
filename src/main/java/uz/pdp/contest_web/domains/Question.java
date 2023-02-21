package uz.pdp.contest_web.domains;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.pdp.contest_web.daos.DocumentDAO;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Question implements BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Test test;
    private String question;
    @ManyToOne
    private Document photoDocumentId;
    private String answers;
    private Byte correctAnswerIndex;
    @OneToMany(mappedBy = "question")
    private Set<ResultQuestion> resultQuestions;

    public String getPathById(){
        DocumentDAO documentDAO = DocumentDAO.get();
        return  documentDAO.getPathById(photoDocumentId.getId());
    }

    public List<String> getAnswersArray(String answers){
        Type list = new TypeToken<ArrayList<String>>(){}.getType();
        return new Gson().fromJson(answers, list);
    }
}
