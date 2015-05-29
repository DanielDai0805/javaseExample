package cglib;

/**
 * Created by dc on 2015/5/14.
 * one day ,the boss said that those method only boss can use
 */
public class Client {
    public static void main(String[] args) {
      BookServiceBean serviceBean = BookServiceFactory.getInstance();
        doMethod(serviceBean);
    }

    public static void doMethod(BookServiceBean serviceBean){
        serviceBean.create();
        serviceBean.query();
        serviceBean.update();
        serviceBean.delete();
    }
}
