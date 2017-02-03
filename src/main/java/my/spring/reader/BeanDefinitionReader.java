package my.spring.reader;

/**
 * Created by WangYingjie on 2017/2/3.
 */
public interface BeanDefinitionReader {

  void loadBeanDefinition(String location)throws Exception;

}
