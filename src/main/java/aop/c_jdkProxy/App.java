package aop.c_jdkProxy;

/**
 * Created by dc on 2015/5/15.
 */
public class App {
    public static void main(String[] args) {
        //访问真实对象
        IUserService userService = new UserServiceImpl();
        //新增
        userService.saveUser("翠山", "123");
        //更新
        userService.updateUser("翠山", "123");
        //查询
        String str = userService.findUser();
        System.out.println("返回值："+str);
        System.out.println("-----------------------------------------------");
        //通过代理访问真实对象
        JDKProxy proxy = new JDKProxy();
        /**ProxyObject(代理对象)：在访问目标对象之前或者之后，先要访问的对象，本例：JDKProxy*/
        IUserService userServiceProxy = (IUserService)proxy.createProxyInstance(userService);
        //新增
        userServiceProxy.saveUser("翠山", "123");
        //更新
        userServiceProxy.updateUser("翠山", "123");
        //查询
        String strProxy = userServiceProxy.findUser();
        System.out.println("返回值："+strProxy);

    }
}
