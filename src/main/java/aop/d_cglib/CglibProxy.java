package aop.d_cglib;

import aop.c_jdkProxy.IUserService;
import net.sf.cglib.core.Signature;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by dc on 2015/5/16.
 */
public class CglibProxy implements MethodInterceptor{
    private Object service;
    public Object createProxyInstance(IUserService service){
        this.service = service;
        //使用cglib创建对象
        Enhancer enhancer = new Enhancer();
        //设置父类(UserServiceImpl),注意是一个类，不是接口
        enhancer.setSuperclass(this.service.getClass());
        //设置回调函数为该类本身
        enhancer.setCallback(this);
        //创建代理对象
        return enhancer.create();
    }

    /**
     *
     * @param proxy    目标对象的代理类实例
     * @param method    在代理类实例上调用的接口方法的Method实例
     * @param args   传入到代理实例上的方法参数值的对象数组
     * @param methodProxy 表示代理类主题对象，可以通过该对象获取代理类的签名
     * @return  方法的返回值
     * @throws Throwable
     */
    public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        if(method.getName().startsWith("save") || method.getName().startsWith("update")){
            checkSecurity();
        }

        System.out.println("代理类的实例："+proxy.getClass());
        System.out.println("访问目标对象方法的名称："+method.getName());
        if(args!=null && args.length>0){
            for(Object arg:args){
                System.out.println("传递给目标对象的参数："+arg);
            }
        }

        //
        //调用代理对象的签名方法
        Signature signature = methodProxy.getSignature();
        System.out.println("代理签名中包括：方法名称："+signature.getName()+
                "     参数类型:"+signature.getArgumentTypes()+
                "     方法的返回类型："+signature.getReturnType());
       //调用目标对象的方法，返回值即目标对象的返回值
        Object returnObject = method.invoke(this.service, args);
        System.out.println("目标对象方法的返回值："+returnObject);
        return returnObject;
    }

    /**Advice(通知):切入点要做的事情，即切入点要操作哪些业务逻辑，本例：checkSecurity()*/
    public void checkSecurity(){
        System.out.println("进行安全性能校验");
    }
}
