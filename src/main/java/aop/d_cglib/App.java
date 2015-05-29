package aop.d_cglib;

import aop.c_jdkProxy.IUserService;
import aop.c_jdkProxy.UserServiceImpl;

/**
 * Created by dc on 2015/5/16.
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
        CglibProxy proxy = new CglibProxy();
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
