package aop.b_staticProxy;

/**
 * Created by dc on 2015/5/14.
 */
public class App {
    public static void main(String[] args) {
        IUserService userService = new UserServiceImpl();
        //����
        userService.saveUser("��ɽ", "123");
        //����
        userService.updateUser("��ɽ", "123");
        //��ѯ
        String str = userService.findUser();
        System.out.println("����ֵ��"+str);
        System.out.println("-----------------------------------------------");
        IUserService userServiceProxy = new UserServiceProxy();
        //����
        userServiceProxy.saveUser("��ɽ", "123");
        //����
        userServiceProxy.updateUser("��ɽ", "123");
        //��ѯ
        String strPrxoy = userServiceProxy.findUser();
        System.out.println("����ֵ��"+strPrxoy);
    }
}
