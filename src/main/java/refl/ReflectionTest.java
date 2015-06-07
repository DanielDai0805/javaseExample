package refl;

import org.junit.Test;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * Created by dc on 2015/6/7.
 */
public class ReflectionTest {
    private Class concreteClass = ConcreteClass.class;;
    /**
     * static class
     * getClass();
     * class.ForName(qualifiedName);
     * PS:for primitive types and arrays ,we can use static variable class
     *    Wrapper classes provide another static variable TYPE to get the class
     */
    @Test
    public void testGetClassObject() throws ClassNotFoundException {
        Class clz1 = ConcreteClass.class;
        Class clz2 = new ConcreteClass(1).getClass();
        Class clz3 = Class.forName("refl.ConcreteClass");
    }

    /**
     * getCanonicalName和getName的区别
     *      对于普通类而言，这两者之间没有区别
     *      对于特殊类，如数组byte[] 前者返回[B 后者返回byte[]
     *      getCanonicalName返回的值更加具有可读性
     * @throws Exception
     */
    @Test
    public void testCanonicalName() throws Exception {
        Class concreteClass = ConcreteClass.class;
        byte[] b = new byte[255];
        System.out.println(concreteClass.getCanonicalName());
        System.out.println(b.getClass().getCanonicalName());//byte[]
        System.out.println(b.getClass().getName());//[B
    }

    /**
     * if this Class represents either the Object class, an interface,a primitive type,or void ,then null is return
     * if the object represents an array class then the Class object representing the Object class is returned
     * @throws Exception
     */
    @Test
    public void testGetSuperclass() throws Exception {
        System.out.println(concreteClass.getSuperclass());
        System.out.println(Object.class.getSuperclass());
        System.out.println(String[][].class.getSuperclass());
    }

    @Test
    public void testPackageName() throws Exception {


    }

    @Test
    public void testGetPublicMemberClass() throws Exception {
        final Class[] classes = concreteClass.getClasses();//all public member including inherit from parent
        System.out.println(Arrays.toString(classes));
        final Method[] declaredMethods = concreteClass.getDeclaredMethods();
    }
}
