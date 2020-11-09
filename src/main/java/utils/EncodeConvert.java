package utils;

import java.util.Arrays;
import java.util.stream.Stream;

public class EncodeConvert {
    //TODO stream流是不是逼格高一点
    public static int[] arrayString2Integer(String[] s){
        int[] ints = new int[s.length];
        for (int i=0;i<s.length;i++){
            ints[i]=Integer.parseInt(s[i]);
        }
        return ints;
    }
    public static Integer[] arrayString2Integer02(String[] s){
        Stream<Integer> integerStream = Arrays.stream(s).map(Integer::parseInt);
        Integer[] ints = integerStream.toArray(Integer[]::new);
        return ints;
    }

}
