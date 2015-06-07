package clz;

import org.junit.Test;

import java.lang.reflect.Modifier;

/**
 * Created by dc on 2015/6/6.
 */
public class ModiferTest {
    private String modifer;
    @Test
    public void testModifer() throws NoSuchFieldException {
       int result = ModiferTest.class.getModifiers();
        System.out.println(Modifier.isPublic(result));
        System.out.println(Modifier.isPrivate(ModiferTest.class.getDeclaredField("modifer").getModifiers()));

    }
}
