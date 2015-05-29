package cglib;

/**
 * Created by dc on 2015/5/14.
 */
public class BookServiceFactory {
    private static BookServiceBean bookServiceBean = new BookServiceBean();
    private BookServiceFactory(){}
    public static BookServiceBean getInstance(){
        return bookServiceBean;
    }
}
