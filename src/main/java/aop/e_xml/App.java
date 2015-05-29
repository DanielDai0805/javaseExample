package aop.e_xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by dc on 2015/5/16.
 */
public class App {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("aop/e_xml/a_before/beans.xml");
        IUserService userService = (IUserService) ac.getBean("userService");//产生JDK代理
        //UserServiceImpl userService = (UserServiceImpl) ac.getBean("userService");//产生Cglib代理
      //  userService.saveUser("foo", "123");
      userService.updateUser("bar", "123");
    }
}
