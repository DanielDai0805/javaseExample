package clz;

import org.junit.Test;

/**
 * link :http://www.blogjava.net/DLevin/archive/2011/06/23/352917.html
 * Created by dc on 2015/5/31.
 */
public class BridgeMethodTest {

    /**
     * bridge method may be created by compiler when extending  a parameterized type whose methods have parameterized  argument
     */
    @Test
    public void testBidgeMethod(){

    }
}

/**
 * 他们生成的.class文件如下：

 A.class

 abstract class org.levin.insidejvm.miscs.bridgemethod.A {

 public abstract java.lang.Object method1(java.lang.Object arg0);

 public abstract java.lang.Object method2();

 }

 B.class

 class org.levin.insidejvm.miscs.bridgemethod.B extends org.levin.insidejvm.miscs.bridgemethod.A {

 public java.lang.String method1(java.lang.String arg);

 0 aload_1 [arg]

 1 areturn

 public java.lang.String method2();

 0 ldc <String "abc"> [20]

 2 areturn

 public bridge synthetic java.lang.Object method2();

 0 aload_0 [this]

 1 invokevirtual org.levin.insidejvm.miscs.bridgemethod.B.method2() : java.lang.String [23]

 4 areturn

 public bridge synthetic java.lang.Object method1(java.lang.Object arg0);

 0 aload_0 [this]

 1 aload_1 [arg0]

 2 checkcast java.lang.String [26]

 5 invokevirtual org.levin.insidejvm.miscs.bridgemethod.B.method1(java.lang.String) : java.lang.String [28]

 8 areturn

 }

 C.class

 class org.levin.insidejvm.miscs.bridgemethod.C extends org.levin.insidejvm.miscs.bridgemethod.A {

 public java.lang.Object method1(java.lang.Object arg);

 0 aload_1 [arg]

 1 areturn

 public java.lang.Object method2();

 0 aconst_null

 1 areturn

 }

 可以看到B中生成了两个bridge方法，而C中则没有。事实上，由于Java中泛型有擦除的机制，因而在编译A类的时候，它里面定义的方法都是以Object类型来表示了，因而如果没有bridge方法，B类根本没有覆盖A类中的abstract方法。
 正因为有bridge方法的存在，才使得B类可以编译通过。而C类由于在编译时所有的泛型也都是通过Object类来表达的，因而它实现的也是A类中的abstract方法，因而不用再生成bridge方法了
 * @param <T>
 */
abstract class A<T>{
    public abstract T method1(T arg);
    public abstract T method2();
}
class B extends A<String> {
    public String method1(String arg) {
        return arg;
    }
    public String method2() {
        return "abc";
    }
}
class C<T> extends A<T> {
    public T method1(T arg) {
        return arg;
    }

    public T method2() {
        return null;
    }
}
