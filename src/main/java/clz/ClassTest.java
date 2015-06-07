package clz;

import javafx.collections.ArrayChangeListener;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dc on 2015/6/6.
 */
public class ClassTest {

    /**
     *返回类定义的公共的内部类,以及从父类、父接口那里继承来的内部类
     * @throws Exception
     */
    @Test
    public void testGetClasses() throws Exception {
        for(Class clz :Son.class.getClasses()){
            System.out.println("class name:"+clz.getName());
        }
    }

    /**
     * 返回类中定义的公共、私有、保护的内部类
     * @throws Exception
     */
    @Test
    public void testGetDeclaredClasses() throws Exception {
        for(Class clz :Son.class.getDeclaredClasses()){
            System.out.println("class name:"+clz.getName());
        }
    }

    @Test
    public void testDeclaringClass() throws Exception {
        System.out.println("Son.ClassS_Pub.class.getDeclaringClass:" + Son.ClassS_Pub.class.getDeclaringClass());//class Son
        System.out.println("ArrayList.class.getDeclaringClass:" + ArrayList.class.getDeclaringClass());//null
        System.out.println("Son.class.getDeclaringClass:"+Son.class.getDeclaringClass());//null
    }

    /**
     * 与getDeclaringClass无二. 两者的区别在于内部匿名类
     * @throws Exception
     */
    @Test
    public void testGetEnclosingClass() throws Exception {
        System.out.println("Son.ClassS_Pub.class.getEnclosingClass:" + Son.ClassS_Pub.class.getEnclosingClass());
        System.out.println("ArrayList.class.getEnclosingClass:" + ArrayList.class.getEnclosingClass());
        System.out.println("Son.class.getEnclosingClass:" + Son.class.getEnclosingClass());
    
        AnonymousSon son = new AnonymousSon();
        final MyInterface myInterfaceInstance = son.getMyInterfaceInstance();
        System.out.println(myInterfaceInstance.getClass().getEnclosingClass());
        System.out.println(myInterfaceInstance.getClass().getDeclaringClass());
    }

    /**
     * 判定此 Class 对象所表示的类或接口与指定的 Class 参数所表示的类或接口是否相同，或是否是其超类或超接口
     * 特别地，通过身份转换或扩展引用转换，该方法能测试指定 Class 参数所表示的类型能否转换为此 Class 对象所表示的类型。
     */
    @Test
    public void  testIsAssignableForm(){
        if(List.class.isAssignableFrom(ArrayList.class)){
            System.out.println("list is assignable from arraylist");
        }
        if(ArrayList.class.isAssignableFrom(List.class)){
            System.out.println("list is assignable from arraylist");
        }

    }
}
