package proxy.demo1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by dc on 2015/5/13.
 */
public class BusinessProcessorHandler implements InvocationHandler {
    private Object target = null;

    public BusinessProcessorHandler(Object target){
        this.target = target;
    }
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        doBefore();
        Object result = method.invoke(target, args);
        doAfter();
        return result;
    }

    protected void doBefore(){
        System.out.println("You can do something here before process your business");
    }

    protected void doAfter(){
        System.out.println("You can do something here after process your business");
    }
}
