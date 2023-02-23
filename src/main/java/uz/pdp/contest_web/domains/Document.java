package uz.pdp.contest_web.domains;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Document implements BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String originalFileName;
    private String generatedFileName;
    private String filePath;
    private String mimeType;
    private Long fileSize;
    private String extension;

    @OneToOne(mappedBy = "photoDocumentId")
    private User user ;
    @OneToMany(mappedBy = "photoDocumentId")
    private Set<Question> question;

    @OneToOne(mappedBy = "documentId")
    private Certificate certificate;

    public Document(Long id) {
        this.id = id;
    }
}
