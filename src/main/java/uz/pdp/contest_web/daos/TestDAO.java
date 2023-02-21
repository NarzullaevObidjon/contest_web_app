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
        Query query = em.createQuery("from tests where current_timestamp between startTime and endTime");
        return (Test) query.getSingleResult();
    }
}
