import jakarta.mail.MessagingException;
import org.junit.jupiter.api.Test;
import uz.pdp.contest_web.daos.TestDAO;
import uz.pdp.contest_web.domains.Question;
import uz.pdp.contest_web.utils.EmailSender;

import java.util.List;


public class TestAnswers {
    @Test
    void send() throws MessagingException {
        EmailSender.sendEmail("sodikovuktamjon30@gmail.com","blaaa","30000");
    }

    @Test
    void aa() throws MessagingException {

    }
}
