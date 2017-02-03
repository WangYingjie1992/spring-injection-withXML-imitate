package my.spring.io;

import org.omg.CORBA.PUBLIC_MEMBER;

import java.net.URL;

/**
 * Created by WangYingjie on 2017/2/3.
 */
public class ResourceLoader {
  public Resource getResource(String location){
    URL resource = this.getClass().getClassLoader().getResource(location);
    return new UrlResource(resource);
  }
}
