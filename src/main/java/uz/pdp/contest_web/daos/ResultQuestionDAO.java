package uz.pdp.contest_web.daos;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import uz.pdp.contest_web.domains.ResultQuestion;
import uz.pdp.contest_web.domains.ResultUser;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ResultQuestionDAO extends BaseDAO<ResultQuestion, Integer>{
    private static final ThreadLocal<ResultQuestionDAO> daoThreadLocal = ThreadLocal.withInitial(ResultQuestionDAO::new);

    public static ResultQuestionDAO get(){return daoThreadLocal.get();}
}
