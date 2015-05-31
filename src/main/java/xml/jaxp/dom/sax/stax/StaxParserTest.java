package xml.jaxp.dom.sax.stax;

import xml.jaxp.Book;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamConstants;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dc on 2015/5/31.
 */
public class StaxParserTest {
    private static List allBooks;
    public static void main(String[] args) throws Exception{
        String path = "E:\\gitRepo\\javaseExample\\src\\main\\java\\xml\\jaxp\\dom\\books.xml";
        read(new File(path));
        System.out.println(allBooks);
    }

    public static void read(File file) throws FileNotFoundException, XMLStreamException {

        Book book = null;

        final XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        Reader reader = new FileReader(file);
        XMLStreamReader xmlStreamReader= xmlInputFactory.createXMLStreamReader(reader);
        int event = xmlStreamReader.getEventType();//获取节点的类型

        while(true){
            switch (event){
                case XMLStreamConstants.START_DOCUMENT:
                    allBooks = new ArrayList();
                break;
                case XMLStreamConstants.START_ELEMENT:
                    String tagName = xmlStreamReader.getLocalName();
                    if("book".equals(tagName)){
                        book = new Book();
                        book.setId(xmlStreamReader.getAttributeValue(0));
                    }else if("title".equals(tagName)){
                        book.setTitle(xmlStreamReader.getElementText());
                    } else if("price".equals(tagName)){
                        book.setPrice(Integer.parseInt(xmlStreamReader.getElementText()));
                    }else if("year".equals(tagName)){
                        book.setYear(xmlStreamReader.getElementText());
                    }
                break;
                case  XMLStreamConstants.CHARACTERS:
                break;
                case XMLStreamConstants.END_ELEMENT:
                    if("book".equals(xmlStreamReader.getLocalName())){
                        allBooks.add(book);
                    }
                break;
                case XMLStreamConstants.END_DOCUMENT:
                    System.out.println("文档结束");
                break;
            }
            if(!xmlStreamReader.hasNext()){
                break;
            }
            event = xmlStreamReader.next();


        }
    }
}
