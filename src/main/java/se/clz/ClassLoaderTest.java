package se.clz;

import org.junit.Test;

/**
 * Created by dc on 2015/5/30.
 */
public class ClassLoaderTest {
    /**
     * Bootstrap ClassLoader :  %JRE_HOME%/lib目录下的rt.jar resource.jar charsets.jar 和class等
     * Extension ClassLoader:   主要是加载java扩展的类，主要是%JRE_HOME/lib/ext目录下的jia和class%
     * App ClassLoader:         负载加载当前java应用中的classpaht中的所有类
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
