package utils;

public class EncodeConvert {
    //TODO 流是不是逼格高一点
    public static int[] arrayString2Integer(String[] s){
        int[] ints = new int[s.length];
        for (int i=0;i<s.length;i++){
            ints[i]=Integer.parseInt(s[i]);
        }
        return ints;
    }
}
