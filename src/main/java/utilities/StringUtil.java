package utilities;

import java.util.Arrays;

public class StringUtil {

    public static int parseToInt(String str){
        return Integer.parseInt(str);
    }

    public static String removeBlurb(String name){
        return Arrays.stream(name.split(":")).findFirst().get();
    }
}
