package my.spring.factory;

import my.spring.ioc.BeanDefinition;

/**
 * Created by WangYingjie on 2017/2/3.
 */
public interface BeanFactory {
  Object getBean(String name);

  void registerBeanDefinition(String name, BeanDefinition definition)throws Exception ;
}
