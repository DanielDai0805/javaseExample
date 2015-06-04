package generic;

/**
 * Created by dc on 2015/6/4.
 * the type parameter's scope is limited to the method where it is declared.
 * The syntax for a generic method includes a type parameter, inside angle brackets, and appears before the method's return type. For static generic methods, the type parameter section must appear before the method's return type.
 *
 */
public class GenericMethod {
    public static <K,V>boolean compare(Pair<K,V>p1,Pair<K,V>p2){
        return p1.getKey().equals(p2.getKey())&&p1.getValue().equals(p2.getValue());
    }
}

