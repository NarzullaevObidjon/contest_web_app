package uz.pdp.contest_web.daos;

import jakarta.persistence.Query;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import uz.pdp.contest_web.domains.Question;
import uz.pdp.contest_web.domains.Test;
import uz.pdp.contest_web.domains.User;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TestDAO extends BaseDAO<Test, Integer>{
    private static final ThreadLocal<TestDAO> daoThreadLocal = ThreadLocal.withInitial(TestDAO::new);


    public List<Question> getQuestionByTestId(Long id){
        begin();
        Query query = em.createQuery("from Question where test.id =:id").setParameter("id", id);
        List<Question> list = query.getResultList();
        commit();
        return list;
    }
    public static TestDAO get(){return daoThreadLocal.get();}


}
