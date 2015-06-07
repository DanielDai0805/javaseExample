package clz;

import org.junit.Test;

import java.io.InputStream;
import java.net.URL;

/**
 * Created by dc on 2015/6/7.
 */
public class ResourceAsStreamTest {
    @Test
    public void testGetResource(){
        final URL resource = this.getClass().getResource("ClassTest.java");
        final URL resource2 = this.getClass().getClass().getResource("ClassTest.java");
    }
}
