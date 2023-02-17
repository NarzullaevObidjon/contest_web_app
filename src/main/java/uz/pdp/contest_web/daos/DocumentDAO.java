
package uz.pdp.contest_web.daos;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import uz.pdp.contest_web.domains.Document;
import uz.pdp.contest_web.domains.User;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DocumentDAO extends BaseDAO<Document, Integer>{
    private static final ThreadLocal<DocumentDAO> daoThreadLocal = ThreadLocal.withInitial(DocumentDAO::new);
    public static DocumentDAO get(){return daoThreadLocal.get();}
}
