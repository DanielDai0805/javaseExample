package clz;

import org.junit.Test;

/**
 * Created by dc on 2015/5/30.
 */
public class ClassLoaderTest {
    /**
     * Bootstrap ClassLoader :  %JRE_HOME%/libĿ¼�µ�rt.jar resource.jar charsets.jar ��class��
     * Extension ClassLoader:   ��Ҫ�Ǽ���java��չ���࣬��Ҫ��%JRE_HOME/lib/extĿ¼�µ�jia��class%
     * App ClassLoader:         ���ؼ��ص�ǰjavaӦ���е�classpaht�е�������
     */
    @Test
    public void testClassLoader(){
        ClassLoader bootstrap =  String.class.getClassLoader();//bootstrap===null
        System.out.println(bootstrap);
        ClassLoader appCl = ClassLoaderTest.class.getClassLoader();
        ClassLoader extCl = appCl.getParent();
        ClassLoader bootStrapCl = extCl.getParent();
        System.out.println(appCl);
        System.out.println(extCl);
        System.out.println(bootStrapCl);
    }

    /**
     * Spring ClassUtils.getDefaultClassLoader
     */
    @Test
    public void testSpringDefalutClassLoader(){
        ClassLoader threadCl = Thread.currentThread().getContextClassLoader();
        System.out.println(threadCl);
    }

    @Test
    public void testSystemClassLoader(){
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);//sun.misc.Launcher$AppClassLoader
    }
}
