package cglib;

import net.sf.cglib.proxy.Enhancer;

/**
 * Created by dc on 2015/5/14.
 */
public class BookServiceWithCglibFactory {
    public static BookServiceBean getProxyInstance(MyCglibProxy myProxy){
        Enhancer en = new Enhancer();
        //���д���
        en.setSuperclass(BookServiceBean.class);
        en.setCallback(myProxy);
        //���ɴ���ʵ��
        return (BookServiceBean)en.create();
    }
}
