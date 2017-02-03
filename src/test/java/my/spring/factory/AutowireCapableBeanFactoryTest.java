package my.spring.factory;

import my.spring.io.ResourceLoader;
import my.spring.ioc.BeanDefinition;
import my.spring.xml.XmlBeanDefinitionReader;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by WangYingjie on 2017/2/3.
 */
public class AutowireCapableBeanFactoryTest {
  @Test
  public void test()throws Exception{
    //读取配置
    XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
    xmlBeanDefinitionReader.loadBeanDefinition("spring-imitate.xml");

    //初始化BeanFactory并注册bean
    BeanFactory beanFactory =new AutowireCapableBeanFactory();
    for (Map.Entry<String, BeanDefinition> beanDefinitionEntry : xmlBeanDefinitionReader.getRegistry().entrySet()) {
      beanFactory.registerBeanDefinition(beanDefinitionEntry.getKey(), beanDefinitionEntry.getValue());
    }

    //获取bean
    HelloWorld helloWorld = (HelloWorld) beanFactory.getBean("helloWorld");
  }

}
