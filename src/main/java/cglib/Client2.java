package cglib;

/**
 * Created by dc on 2015/5/14.
 */
public class Client2 {
    public static void main(String[] args) {
        BookServiceBean serviceBean = BookServiceWithCglibFactory.getProxyInstance(new MyCglibProxy("boss"));
        serviceBean.create();

        BookServiceBean serviceBean2 = BookServiceWithCglibFactory.getProxyInstance(new MyCglibProxy("john"));
        serviceBean2.create();
    }
    public static void doMethod(BookServiceBean serviceBean){
        serviceBean.create();
        serviceBean.query();
        serviceBean.update();
        serviceBean.delete();
    }
}
