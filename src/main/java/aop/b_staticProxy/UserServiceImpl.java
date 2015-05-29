package aop.b_staticProxy;

/**
 * ��ʵ����
 * Created by dc on 2015/5/14.
 */
public class UserServiceImpl implements IUserService {

    public void saveUser(String username, String password) {
        System.out.println("�����û���"+username);
    }

    public void updateUser(String username, String password) {
        System.out.println("�����û���"+username);
    }

    public void deleteUser(String username) {
        System.out.println("ɾ���û���"+username);
    }

    public String findUser() {
        return "������";
    }
}
