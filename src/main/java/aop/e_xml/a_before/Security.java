package aop.e_xml.a_before;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;

/**
 * Created by dc on 2015/5/16.
 */


/**
 *切面
 */
public class Security {
    /**
     * 任何通知方法可以将第一个参数定义为org.aspectj.lang.JoinPoint类型
     *   （环绕通知需要定义第一个参数为ProceedingJoinPoint类型， 它是 JoinPoint 的一个子类）。
     *    JoinPoint 接口提供了一系列有用的方法，
     *    比如 getArgs()（返回方法参数）、 getThis()（返回代理对象）、getTarget()（返回目标）、
     *         getSignature()（返回正在被通知的方法相关信息）和 toString() （打印出正在被通知的方法的有用信息）。
     */
    /**
     * 通知
     * @param joinpoint
     */
    public void checkSecurity(JoinPoint joinpoint){
        System.out.println("start check sercurity!");
        System.out.println("proxy Object:"+joinpoint.getThis().getClass());
        System.out.println("target Object:" + joinpoint.getTarget().getClass());
        final Signature signature = joinpoint.getSignature();
        System.out.println("method name："+signature.getName());
        //获取参数：
        final Object[] args = joinpoint.getArgs();
        if(args!=null && args.length>0){
            for(Object arg:args){
                System.out.println("method args："+arg);
            }
        }

        //如果不想执行目标的方法，可以在前置通知中抛出异常
         if(false){
             throw new RuntimeException("this is exception");
         }
    }
}
