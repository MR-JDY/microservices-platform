
import junit.framework.TestCase;

import org.junit.Test;

import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.util.Arrays;


public class TestUtils extends TestCase
{

    @Test
    public void testArrayToCommaDelimitedString(){
        String[] arr = new String[]{"1", "2", "3"};
        String s = StringUtils.arrayToDelimitedString(arr,",");
        System.out.println(s);
        String[] strings = StringUtils.tokenizeToStringArray(s, ",");
        System.out.println(strings);
        Arrays.asList(strings).forEach(System.out::println);
    }

}
