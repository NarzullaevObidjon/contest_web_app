
package uz.pdp.contest_web.daos;

import jakarta.persistence.Query;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import uz.pdp.contest_web.domains.Document;
import uz.pdp.contest_web.domains.User;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DocumentDAO extends BaseDAO<Document, Integer>{
    private static final ThreadLocal<DocumentDAO> daoThreadLocal = ThreadLocal.withInitial(DocumentDAO::new);
    public static DocumentDAO get(){return daoThreadLocal.get();}

    public String getPathById(Long id) {
        Query query = em.createQuery("from Document where id =:id").setParameter("id", id);
        Document document = (Document) query.getSingleResult();
        return document.getFilePath();
    }
}
