package my.spring.ioc;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by WangYingjie on 2017/2/3.
 */
public class PropertyValues {
  private final List<PropertyValue> propertyValueList = new ArrayList<>();

  public List<PropertyValue> getPropertyValueList() {
    return propertyValueList;
  }

  public void addPropertyValue (PropertyValue propertyValue ){
    this.propertyValueList.add(propertyValue);
  }

  public  PropertyValues() {
  }
}
