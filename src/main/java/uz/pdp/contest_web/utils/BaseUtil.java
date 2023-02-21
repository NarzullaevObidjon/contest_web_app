package uz.pdp.contest_web.utils;

import java.util.Random;

public class BaseUtil {
    public static final String  generateCode(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            sb.append(new Random().nextInt(10));
        }
        return sb.toString();
    }
}
