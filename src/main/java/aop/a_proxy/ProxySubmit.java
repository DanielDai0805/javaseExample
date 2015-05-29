package aop.a_proxy;

/**
 * Created by dc on 2015/5/14.
 */
public class ProxySubmit implements Submit {

    public String request() {
        TargetSubmit targetSubmit = new TargetSubmit();
        String str = targetSubmit.request();
        str = str.replaceAll("2000","1000");
        return str;
    }
}
