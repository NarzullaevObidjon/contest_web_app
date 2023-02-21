package uz.pdp.contest_web.daos;

import jakarta.persistence.Query;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import uz.pdp.contest_web.domains.User;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserDAO extends BaseDAO<User, Long> {
    private static final ThreadLocal<UserDAO> daoThreadLocal = ThreadLocal.withInitial(UserDAO::new);

    public static UserDAO get() {
        return daoThreadLocal.get();
    }

    public String getPhotoPathByUsername(String username) {
        begin();
        Query query = em.createQuery("from users u where u.username =:u").setParameter("u", username);
        User user = (User) query.getSingleResult();
        commit();
        return DocumentDAO.get().getPathById(user.getPhotoDocumentId().getId());
    }

    public User getByUsername(String username) {
        begin();
        Query query = em.createQuery("from users u where u.username =:username").setParameter("username", username);
        User user = (User) query.getSingleResult();
        commit();
        return user;
    }

    public List<User> findAll() {
        begin();
        List<User> selectAFromUsersA = em.createQuery("SELECT a FROM users a", User.class).getResultList();
        commit();
        return selectAFromUsersA;
    }

}
