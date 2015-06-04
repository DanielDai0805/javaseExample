package generic;

/**
 * Created by dc on 2015/6/4.
 * generic class is defined with the following format: class name<T1,T2,T3....>{/*...*}
 */

/**
 * T1,T2,T3 called Type parameters or type variables
 * Type Parameter Naming Conventions:
 *       E - Element (used extensively by the Java Collections Framework)
         K - Key
         N - Number
         T - Type
         V - Value
         S,U,V etc. - 2nd, 3rd, 4th types

 Box<Integer>integerBox: the Integer which replaces T with some concreate value is called: type argument

 Type Parameter and Type Argument Terminology: Many developers use the terms "type parameter" and "type argument" interchangeably, but these terms are not the same. When coding, one provides type arguments in order to create a parameterized type. Therefore, the T in Foo<T> is a type parameter and the String in Foo<String> f is a type argument. This lesson observes this definition when using these terms.

 Box<Integer>integerBox = new Box<Integer>(); type parameterized type.

 Raw type
    Box<Integer> intBox = new Box<>();parameterized type
    Box rawBox = new Box(); Raw type
    Therefore, Box is the raw type of the generic type Box<T>. However, a non-generic class or interface type is not a raw type.

 */
public class GenericBox<T> {
    private T t;

    public T get() {
        return t;
    }

    public void set(T t) {
        this.t = t;
    }
}
