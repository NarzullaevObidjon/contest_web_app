package uz.pdp.contest_web.domains;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
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
    @OneToOne(mappedBy = "photoDocumentId")
    private Question question;

    @OneToOne(mappedBy = "documentId")
    private Certificate certificate;

}
