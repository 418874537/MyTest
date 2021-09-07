package com;

/**
 * @Description:
 * @Author: mayingjie@sensorsdata.com
 * @Date: 2021/9/2
 */
public class Singleton {
  private Singleton(){}

  private  static final class InstanceClass{
    private  static final Singleton INSTANCE = new Singleton();
  }
  public static Singleton getInstance(){
    return InstanceClass.INSTANCE;
  }
}
