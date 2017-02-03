package my.spring.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * 用于sping内部定位资源的接口
 * Created by WangYingjie on 2017/2/3.
 */
public interface Resource {
  InputStream getInputStream()throws IOException;
}
