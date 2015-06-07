package refl;

import org.junit.Test;

import java.io.File;
import java.lang.reflect.Field;
import java.util.List;

/**
 * Created by dc on 2015/6/6.
 */
public class MethodTest {
    private List<String>genericList;
    private List list;
    @Test
    public void testGenericType() throws NoSuchFieldException {
        Field genericListField = MethodTest.class.getDeclaredField("genericList");
        Field list = MethodTest.class.getDeclaredField("list");
        System.out.println(genericListField.getGenericType());
        System.out.println(list.getGenericType());
    }
}
