package clz;

/**
 * Created by dc on 2015/6/6.
 */
public class AnonymousSon {
    public MyInterface getMyInterfaceInstance(){
       return  new MyInterface(){
           public void sayHello() {
               System.out.println("ArrayList.class.getEnclosingClass:" + this.getClass().getEnclosingClass());

               System.out.println("ArrayList.class.getDeclaringClass:" + this.getClass().getDeclaringClass());

               System.out.println("Hello, nice to meet you!");

           }
       };
    }
}
interface MyInterface{
    public void sayHello();
}
