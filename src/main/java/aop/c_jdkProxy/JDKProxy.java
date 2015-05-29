package aop.c_jdkProxy;

/**
 * Created by dc on 2015/5/15.
 */

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Aspect（切面）：通知要被定义的类，该类就是切面，本例JDKProxy
 */
public class JDKProxy implements InvocationHandler{

    private Object userService;

    /**
     *
     * @param userService 真是的主题对象
     * @return 代理主题对象
     */
    public Object createProxyInstance(Object userService){
        this.userService = userService;
        /**
         * 第三个对象，回调对象。当代理对象的方法被调用时，会调用该参数指定对象的invoke方法
         */
        return Proxy.newProxyInstance(JDKProxy.class.getClassLoader(),this.userService.getClass().getInterfaces(),this);
    }

    /**
     *
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        if(method.getName().startsWith("save")||method.getName().startsWith("update")){
            checkSecurity();
        }
        System.out.println("代理类实例:"+proxy.getClass());
        System.out.println("访问接口方法的名称:"+method.getName());
        if(args!=null &&args.length>0){
            for(Object arg:args){
                System.out.println("传递给目标对象的参数："+arg);
            }
        }
        /**
         * 调用目标对象的方法
         * returnObject：目标对象执行的返回值
         */
        Object returnObject = method.invoke(this.userService,args);
        System.out.println("目标对象方法的返回值："+returnObject);
        return returnObject;
    }

    /**
     * Advice:切入点要做的事情，切入点要操作哪些业务逻辑，checkSecurity
     */
    public void checkSecurity(){
        System.out.println("进行安全性能校验");
    }
}
