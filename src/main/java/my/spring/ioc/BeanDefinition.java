package my.spring.ioc;

/**
 * bean的定义以及相关数据，保存在BeanFactory中
 * Created by WangYingjie on 2017/2/3.
 */
public class BeanDefinition {
  private Object bean;

  private Class beanClass;

  private String beanClassName;

  private PropertyValues propertyValues =new PropertyValues();

  public BeanDefinition() {
  }

  public Object getBean() {
    return bean;
  }

  public void setBean(Object bean) {
    this.bean = bean;
  }

  public Class getBeanClass() {
    return beanClass;
  }

  public void setBeanClass(Class beanClass) {
    this.beanClass = beanClass;
  }

  public String getBranClassName() {
    return beanClassName;
  }

  public void setBranClassName(String beanClassName) {
    this.beanClassName = beanClassName;
    try {
      this.beanClass = Class.forName(beanClassName);
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }

  }

  public PropertyValues getPropertyValues() {
    return propertyValues;
  }

  public void setPropertyValues(PropertyValues propertyValues) {
    this.propertyValues = propertyValues;
  }

  public void setBeanClassName(String beanClassName) {
    this.beanClassName = beanClassName;
  }
}
