package uz.pdp.contest_web.daos;

import jakarta.persistence.Query;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import uz.pdp.contest_web.domains.Question;
import uz.pdp.contest_web.domains.Test;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class QuestionDAO extends BaseDAO<Question, Integer>{
    private static final ThreadLocal<QuestionDAO> daoThreadLocal = ThreadLocal.withInitial(QuestionDAO::new);

    public static QuestionDAO get(){return daoThreadLocal.get();}

    public List<Question> getByTestId(Long id){
        begin();
        Query query = em.createQuery("from Question q where q.test.id=:id").setParameter("id", id);
        List<Question> resultList = query.getResultList();
        commit();
        return resultList;
    }


}
