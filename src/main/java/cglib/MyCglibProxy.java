package cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.apache.log4j.Logger;


import java.lang.reflect.Method;

/**
 * Created by dc on 2015/5/14.
 */
public class MyCglibProxy implements MethodInterceptor{
    private Logger logger = Logger.getLogger(MyCglibProxy.class);
    public Enhancer enhancer =  new Enhancer();
    private String name;
    public MyCglibProxy(String name){
        this.name = name;
    }
    public Object getDaoBean(Class cls){
        enhancer.setSuperclass(cls);
        enhancer.setCallback(this);
        return enhancer.create();
    }
    public Object intercept(Object object, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("invoke method:" + method.getName());
        if(!"boss".equals(name)){
            System.out.println("you do not have the privilege");
            return null;
        }
        Object result = methodProxy.invokeSuper(object,args);
        return result;
    }
}
