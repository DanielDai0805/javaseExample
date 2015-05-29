package aop.e_xml;

/**
 * Created by dc on 2015/5/15.
 */

/**
 * TargetObject:访问的真实主题对象，该例中UserServiceImpl
 */
public class UserServiceImpl implements IUserService {

    /**
     * Joinpoint：访问目标对象中定义的所有方法，就是连接点
     * such as saveUser updateUser deleteUser findUser
     * @param username
     * @param password
     */
    public void saveUser(String username, String password) {
        System.out.println("保存用户："+username);
    }

    public void updateUser(String username, String password) {
        System.out.println("更新用户："+username);
    }

    public void deleteUser(String username) {
        System.out.println("删除用户："+username);
    }

    public String findUser() {
        return "张三丰";
    }
}
