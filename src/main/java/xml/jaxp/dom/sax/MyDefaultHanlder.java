package xml.jaxp.dom.sax;

import com.sun.javafx.collections.ObservableSequentialListWrapper;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import xml.jaxp.Book;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dc on 2015/5/31.
 */
public class MyDefaultHanlder extends DefaultHandler {
    private List allBook;
    private Book book;
    private String tagName;

    public List getAllBook(){
        return this.allBook;
    }

    @Override
    public void startDocument() throws SAXException {
        allBook = new ArrayList();
    }

    /**
     * 如果xml使用schema约束
     * uri：schema的名称 targetNameSpace  --> xmlns:xs="xxxxx"  -->root
     * localName：便签的名称 root
     * qName: xs:root
     * 如果没有使用
     * 	 * uri:null
     *   * localName:null
     *   * qName:root
     */
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if("book".equals(qName)){
            book = new Book();
            String id = attributes.getValue("id");
            book.setId(id);
        }
        //缓存当前的标签
        tagName = qName;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String content = new String(ch,start,length);
        //从缓存中获取标签的名称
        if("title".equals(tagName)){
            book.setTitle(content);
        }else if("price".equals(tagName)){
            book.setPrice(Integer.parseInt(content));
        }else if("year".equals(tagName)){
            book.setYear(content);
        }
        tagName = null;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        //判断book标签的结束，然后把book添加到list中
        if("book".equals(qName)){
            allBook.add(book);
            book = null;
        }
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("文档结束");
    }
}
