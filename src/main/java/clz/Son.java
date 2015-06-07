package clz;

/**
 * Created by dc on 2015/6/6.
 */
public class Son extends Father {
    public class ClassS_Pub{
        int x;
    }
    class ClassS_Pro{
        int x;
    }
    private class ClassS_Pri{
        int x;
    }

    public interface InterfS_Pub{
        public String getName();
    }

    interface InterfS_Pro{
        public String getName();
    }

    private interface InterfS_Pri{
        public String getName();
    }

}
