package uz.pdp.contest_web.daos;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import uz.pdp.contest_web.domains.Question;
import uz.pdp.contest_web.domains.Test;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class QuestionDAO extends BaseDAO<Question, Integer>{
    private static final ThreadLocal<QuestionDAO> daoThreadLocal = ThreadLocal.withInitial(QuestionDAO::new);

    public static QuestionDAO get(){return daoThreadLocal.get();}
}
