package xml.jaxp.dom;

import org.springframework.beans.factory.parsing.PassThroughSourceExtractor;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by dc on 2015/5/31.
 */
public class DOMHelper {

    public static final String PATH = "E:\\gitRepo\\javaseExample\\src\\main\\java\\xml\\jaxp\\dom\\books.xml";
    public static void main(String[] args) throws Exception{
        Document document = getDocument(PATH);
        addElement(document);
    }

    public static void addElement(Document document) throws IOException, SAXException, ParserConfigurationException, TransformerException {
        //获取根元素
        Element rootElement = document.getDocumentElement();

        Element newElement = document.createElement("book");
        newElement.setAttribute("id", "004");

        Element titleElement = document.createElement("title");
        titleElement.setTextContent("Danile");

        newElement.appendChild(titleElement);

        rootElement.appendChild(newElement);

        saveXml(PATH,document);

    }

    public static void saveXml(String path,Document document) throws TransformerException {
        //获取Transfomer工厂
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        //通过工厂获得持久化实例
        Transformer transformer = transformerFactory.newTransformer();
        Properties p = transformer.getOutputProperties();
        p.setProperty(OutputKeys.INDENT,"yes");

        //设置回transformer
        transformer.setOutputProperties(p);

        //进行持久化--transform
        //将document保存到定义好的source中
        Source xmlSource = new DOMSource(document);
        //将数据源保存到制定的文件中
        Result outputTarget = new StreamResult(path);
        transformer.transform(xmlSource,outputTarget);
        System.out.println("ok");

    }
    /**
     *
     * @param file
     * @return
     * @throws ParserConfigurationException
     * @throws IOException
     * @throws SAXException
     */
    public static Document getDocument(String file) throws ParserConfigurationException, IOException, SAXException {
        //获取工厂实例
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        //得到解析器
        final DocumentBuilder documentBuilder = factory.newDocumentBuilder();
        //解析成DOCUMENT
        Document document = documentBuilder.parse(new File(file));
        return document;
    }
}
