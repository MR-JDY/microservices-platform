
import junit.framework.TestCase;

import org.apache.catalina.User;
import org.junit.Test;

import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.util.*;


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

    @Test(expected = NoSuchElementException.class)
    public void testOptional() {
        Optional<User> emptyOpt = Optional.empty();
        emptyOpt.get();
    }

    @Test(expected = NullPointerException.class)
    public void testNPE() {
        LinkedList<String> strings = new LinkedList<>();
//        Optional<User> opt = Optional.of(user);
        LinkedList<String> s = Optional.ofNullable(strings).orElseGet(()->{
            LinkedList<String> strings1 = new LinkedList<>();
            strings1.add("abc");
            return strings1;
        });
    }
    @Test
    public void testStringNull() {
        String name = "John";
        Optional<String> opt = Optional.ofNullable(name);
        String s = opt.get();
        boolean present = opt.isPresent();
        opt.ifPresent(h -> {
            assertEquals(name,s);
            System.out.println(h);});

        assertEquals("John", s);
    }
}
