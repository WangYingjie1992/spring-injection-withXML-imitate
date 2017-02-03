package my.spring.factory;

import my.spring.ioc.BeanDefinition;
import my.spring.ioc.PropertyValue;

import java.lang.reflect.Field;

/**
 * Created by WangYingjie on 2017/2/3.
 */
public class AutowireCapableBeanFactory extends AbstractBeanFactory{


  @Override
  protected Object doCreatBean(BeanDefinition beanDefinition) throws Exception {
    Object bean = creatBeanInstance(beanDefinition);
    applyPropertyValues(bean,beanDefinition);
    return bean;
  }

  /**
   * 构建bean
   * @param beanDefinition
   * @return
   * @throws Exception
   */
  protected Object creatBeanInstance(BeanDefinition beanDefinition)throws Exception{
    return beanDefinition.getBeanClass().newInstance();
  }

  /**
   * 注入bean属性
   * @param bean
   * @param beanDefinition
   * @throws Exception
   */
  protected void applyPropertyValues (Object bean,BeanDefinition beanDefinition)throws Exception{
    for (PropertyValue propertyValue:beanDefinition.getPropertyValues().getPropertyValueList()
         ) {
      Field declaredField = bean.getClass().getDeclaredField(propertyValue.getName());
      declaredField.setAccessible(true);
      declaredField.set(bean,propertyValue.getValue());
    }
  }
}
