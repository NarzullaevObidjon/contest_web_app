package uz.pdp.contest_web.daos;

import jakarta.persistence.Query;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import uz.pdp.contest_web.domains.Question;
import uz.pdp.contest_web.domains.Test;
import uz.pdp.contest_web.domains.User;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TestDAO extends BaseDAO<Test, Long>{
    private static final ThreadLocal<TestDAO> daoThreadLocal = ThreadLocal.withInitial(TestDAO::new);

    public static TestDAO get(){return daoThreadLocal.get();}

    public Test getLiveTest() {
        begin();
        Query query = em.createQuery("from tests where current_timestamp between startTime and endTime");
        commit();
        return (Test) query.getSingleResult();
    }

    public long getLastTestNumber() {
        begin();
        Query query = em.createQuery("select t.number from tests t order by t.number desc limit 1", Long.class);
        Long singleResult = (Long) query.getSingleResult();
        commit();
        return singleResult;
    }

    public Test getByNumber(String number) {
        begin();
        Query query = em.createQuery("from tests where number=:number").setParameter("number",number);
        commit();
        return (Test) query.getSingleResult();
    }
    public List<Test> findAll(){
        return em.createQuery("SELECT a FROM tests a order by startTime desc, title, interval, questionCount", Test.class).getResultList();
    }
}
