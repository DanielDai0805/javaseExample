package aop.c_jdkProxy;

/**
 * Created by dc on 2015/5/15.
 */
public interface IUserService {
    public void saveUser(String username,String password);
    public void updateUser(String username,String password);
    public void deleteUser(String username);
    public String findUser();
}
