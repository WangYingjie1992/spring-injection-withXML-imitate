package my.spring.factory;

import my.spring.ioc.BeanDefinition;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by WangYingjie on 2017/2/3.
 */
public abstract class AbstractBeanFactory implements BeanFactory {
  private Map<String,BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();

  @Override
  public Object getBean(String name ){
    return beanDefinitionMap.get(name).getBean();
  }

  @Override
  public void registerBeanDefinition(String name,BeanDefinition beanDefinition )throws Exception{
    Object bean = doCreatBean(beanDefinition);
    beanDefinition.setBean(bean);
    beanDefinitionMap.put(name,beanDefinition);
  }

  protected abstract Object doCreatBean(BeanDefinition beanDefinition)throws Exception;

}
