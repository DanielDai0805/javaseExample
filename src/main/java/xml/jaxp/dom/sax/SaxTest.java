package xml.jaxp.dom.sax;

import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 * Created by dc on 2015/5/31.
 */
public class SaxTest {
    public static void main(String[] args) throws Exception{
        //获得sax解析工厂实例
        SAXParserFactory factory =  SAXParserFactory.newInstance();
        //通过工厂获得解析器
        SAXParser parser = factory.newSAXParser();

        MyDefaultHanlder handler = new MyDefaultHanlder();
        parser.parse("E:\\gitRepo\\javaseExample\\src\\main\\java\\xml\\jaxp\\dom\\books.xml", handler);

        System.out.println(handler.getAllBook());
    }
}
