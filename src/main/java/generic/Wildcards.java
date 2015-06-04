package generic;

import java.util.List;

/**
 * Created by dc on 2015/6/4.
 *
 */
public class Wildcards {
    //you want to write a method that works on List<Integer>, List<Double>, and List<Number>; you can achieve this by using an upper bounded wildcard.
    public static void process(List<? extends Foo>list){}

    /**
     * The unbounded wildcard type is specified using the wildcard character (?)
     *  scenarios:
     *      If you are writing a method that can be implemented using functionality provided in the Object class.
     *      When the code is using methods in the generic class that don't depend on the type parameter. For example, List.size or List.clear. In fact, Class<?> is so often used because most of the methods in Class<T> do not depend on T.
     */
    public static void printList(List<?> list) {
        for (Object elem: list)
            System.out.print(elem + " ");
        System.out.println();
    }
}
class Foo{

}
