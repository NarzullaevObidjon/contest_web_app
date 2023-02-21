package uz.pdp.contest_web.daos;

import jakarta.persistence.Query;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import uz.pdp.contest_web.domains.ResultUser;
import uz.pdp.contest_web.domains.User;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ResultUserDAO extends BaseDAO<ResultUser, Integer>{
    private static final ThreadLocal<ResultUserDAO> daoThreadLocal = ThreadLocal.withInitial(ResultUserDAO::new);

    public static ResultUserDAO get(){return daoThreadLocal.get();}
}
