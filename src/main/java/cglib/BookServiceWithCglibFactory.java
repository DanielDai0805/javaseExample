package cglib;

import net.sf.cglib.proxy.Enhancer;

/**
 * Created by dc on 2015/5/14.
 */
public class BookServiceWithCglibFactory {
    public static BookServiceBean getProxyInstance(MyCglibProxy myProxy){
        Enhancer en = new Enhancer();
        //进行代理
        en.setSuperclass(BookServiceBean.class);
        en.setCallback(myProxy);
        //生成代理实例
        return (BookServiceBean)en.create();
    }
}
