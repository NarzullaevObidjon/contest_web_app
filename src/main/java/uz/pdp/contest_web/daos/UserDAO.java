package uz.pdp.contest_web.daos;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import uz.pdp.contest_web.domains.User;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserDAO extends BaseDAO<User, Integer>{
    private static final ThreadLocal<UserDAO> daoThreadLocal = ThreadLocal.withInitial(UserDAO::new);

    public static UserDAO get(){return daoThreadLocal.get();}
}
