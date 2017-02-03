package my.spring.xml;

import my.spring.io.ResourceLoader;
import my.spring.ioc.BeanDefinition;
import my.spring.ioc.PropertyValue;
import my.spring.reader.AbstractBeanDefinitionReader;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;

/**
 * 从xml中读入bean和bean相关属性的信息
 * Created by WangYingjie on 2017/2/3.
 */
public class XmlBeanDefinitionReader extends AbstractBeanDefinitionReader{
  public XmlBeanDefinitionReader(ResourceLoader resourceLoader){
    super(resourceLoader);
  }
  @Override
  public void loadBeanDefinition(String location) throws Exception {
    InputStream inputStream = getResourceLoader().getResource(location).getInputStream();
    doLoadBeanDefinitons(inputStream);
  }

  protected void doLoadBeanDefinitons(InputStream inputStream) throws Exception {
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    DocumentBuilder docBuilder = factory.newDocumentBuilder();
    Document doc = docBuilder.parse(inputStream);
    // 解析bean
    registerBeanDefinitions(doc);
    inputStream.close();
  }

  public void registerBeanDefinitions(Document doc) {
    Element root = doc.getDocumentElement();

    parseBeanDefinitions(root);
  }

  protected void parseBeanDefinitions(Element root) {
    NodeList nl = root.getChildNodes();
    for (int i = 0; i < nl.getLength(); i++) {
      Node node = nl.item(i);
      if (node instanceof Element) {
        Element ele = (Element) node;
        processBeanDefinition(ele);
      }
    }
  }

  protected void processBeanDefinition(Element ele) {
    String name = ele.getAttribute("name");
    String className = ele.getAttribute("class");
    BeanDefinition beanDefinition = new BeanDefinition();
    processProperty(ele,beanDefinition);
    beanDefinition.setBeanClassName(className);
    getRegistry().put(name, beanDefinition);
  }

  private void processProperty(Element ele,BeanDefinition beanDefinition) {
    NodeList propertyNode = ele.getElementsByTagName("property");
    for (int i = 0; i < propertyNode.getLength(); i++) {
      Node node = propertyNode.item(i);
      if (node instanceof Element) {
        Element propertyEle = (Element) node;
        String name = propertyEle.getAttribute("name");
        String value = propertyEle.getAttribute("value");
        beanDefinition.getPropertyValues().addPropertyValue(new PropertyValue(name,value));
      }
    }
  }
}