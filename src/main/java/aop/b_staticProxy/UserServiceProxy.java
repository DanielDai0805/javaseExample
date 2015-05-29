package aop.b_staticProxy;

/**
 * Created by dc on 2015/5/14.
 */
public class UserServiceProxy implements IUserService {

    private IUserService service = null;
    public void saveUser(String username, String password) {
        IUserService service =  new UserServiceImpl();
        checkSecurity();
        service.saveUser(username,password);
    }

    public void updateUser(String username, String password) {
        IUserService service =  new UserServiceImpl();
        checkSecurity();
        service.updateUser(username,password);
    }

    public void deleteUser(String username) {
        IUserService service =  new UserServiceImpl();
        checkSecurity();
        service.deleteUser(username);
    }

    public String findUser() {
        IUserService service =  new UserServiceImpl();
        checkSecurity();
        return service.findUser();
    }

    public void checkSecurity(){
        System.out.println("check the security...");
    }
}
