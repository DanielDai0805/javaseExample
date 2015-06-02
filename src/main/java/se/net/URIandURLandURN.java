package se.net;

/**
 * link:http://blog.csdn.net/workformywork/article/details/17260033
 * Created by ddai on 6/2/2015.
 * URI:uniform resource identifier
 * URL:uniform resource locator
 * URN:uniform resource Name????????
 */

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URI;

/**
 * URI:
 * Components of all URIs: [<scheme>:]<scheme-specific-part>[#<fragment>]
 * scheme-specific-part:??????????
 * ?????file http ftp mailto telnet
 *      ????? Hierarchical URI components: [//<authority>]<path>[?<query>]
 *          Server-based authority: [<userInfo>@]<host>[:<port>]
 *          ex:http://www.baidu.com
 *      ?????
 *          ex:mailto:packagecomponent@gmail.com. and the scheme-specific-part is packagecomponent@gmail.com
 *
 */
public class URIandURLandURN {

    @Test
    public void testURI() throws IOException {
        String path = "http://blog.csdn.net/workformywork/article/details/17260033";
        URI netURI = URI.create(path);
        System.out.println("scheme:"+netURI.getScheme());
        System.out.println("authority:"+netURI.getAuthority());
        System.out.println("host:"+netURI.getHost());
        System.out.println("port:"+netURI.getPort());




        URI uri = URI.create("http://www.baidu.com");
        BufferedReader br = new BufferedReader(new InputStreamReader(uri.toURL().openStream()));
        String line = null;
        while((line = br.readLine())!=null){
            System.out.println(line);
        }
    }
}
