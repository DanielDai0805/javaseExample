package clz;

/**
 * Created by dc on 2015/6/6.
 */
public class Father extends GrandFather {
    public class ClassF_Pub{
        int x;
    }
    class ClassF_Pro{
        int x;
    }
    private class ClassF_Pri{
        int x;
    }
    public  interface InterfF_Pub{
        public String getName();
    }
    interface InterfF_Pro{
        public String getName();
    }
    private interface InterfF_Pri{
        public String getName();
    }
}
