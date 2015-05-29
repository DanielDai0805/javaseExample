package aop.b_staticProxy;

/**
 * Created by dc on 2015/5/14.
 */
public interface IUserService {
    public void saveUser(String username,String password);
    public void updateUser(String username,String password);
    public void deleteUser(String username);
    public String findUser();
}
