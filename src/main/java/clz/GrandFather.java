package clz;

/**
 * Created by dc on 2015/6/6.
 */
public class GrandFather {
    public class ClassG_Pub{
        int x;
    }
    class ClassG_Pro{
        int x;
    }
    private class ClassG_Pri{
        int x;
    }
    public interface InterfaceG_pub{
        public String getName();
    }
    interface InterfaceG_Pro{
        public String getName();
    }
    private interface  InterfaceG_Pri{
        public String getName();
    }
}
