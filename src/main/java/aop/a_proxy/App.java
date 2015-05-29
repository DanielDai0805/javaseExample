package aop.a_proxy;

import java.lang.annotation.Target;

/**
 * Created by dc on 2015/5/14.
 */
public class App {
    public static void main(String[] args) {
        //directly access
        TargetSubmit targetSubmit = new TargetSubmit();
        String str = targetSubmit.request();
        System.out.println("directly access:"+str);

        //proxy access
        Submit submit = new ProxySubmit();
        String str2 =  submit.request();
        System.out.println("proxy access:"+str2);
    }
}
