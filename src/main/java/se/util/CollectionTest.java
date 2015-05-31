package se.util;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by dc on 2015/5/31.
 */
public class CollectionTest {
    @Test
    public void testSetToArray(){
        Map<String,String>map = new HashMap<String, String>();
        map.put("Danile1","1");
        map.put("Danile2", "2");
        Set<String>keySets =  map.keySet();
        String[] result =  new String[map.size()];
        keySets.toArray(result);
        System.out.println(Arrays.toString(result));
    }
}
