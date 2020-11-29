import jdk.jfr.StackTrace;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import utils.EncodeConvert;
import utils.PrintUtils;

public class EncodeUtilTest {
    @Test
    public void test01(){
        String[] s={"1","2"};
        Integer[] integers =  EncodeConvert.arrayString2Integer02(s);
        PrintUtils.printArray(integers);
    }
}
