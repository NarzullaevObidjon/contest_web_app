package uz.pdp.contest_web.daos;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import uz.pdp.contest_web.domains.Test;
import uz.pdp.contest_web.domains.User;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TestDAO extends BaseDAO<Test, Integer>{
    private static final ThreadLocal<TestDAO> daoThreadLocal = ThreadLocal.withInitial(TestDAO::new);

    public static TestDAO get(){return daoThreadLocal.get();}
}
