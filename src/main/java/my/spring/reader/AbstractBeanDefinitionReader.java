package my.spring.reader;

import my.spring.io.ResourceLoader;
import my.spring.ioc.BeanDefinition;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by WangYingjie on 2017/2/3.
 */
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader{

  private Map<String,BeanDefinition> registry;
  private ResourceLoader resourceLoader;
  protected AbstractBeanDefinitionReader(ResourceLoader resourceLoader){
    this.registry = new HashMap<String,BeanDefinition>();
    this.resourceLoader = resourceLoader;
  }
  public Map<String,BeanDefinition>getRegistry(){
    return registry;
  }

  public ResourceLoader getResourceLoader() {
    return resourceLoader;
  }
}
