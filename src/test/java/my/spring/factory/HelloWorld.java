package my.spring.factory;

/**
 * Created by WangYingjie on 2017/2/3.
 */
public class HelloWorld {
  private String text;

  public void say(){
    System.out.println(text);
  }

  public void setText(String text) {
    this.text = text;
  }
}
