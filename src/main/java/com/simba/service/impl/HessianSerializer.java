package com.simba.service.impl;

import com.caucho.hessian.io.HessianOutput;
import com.simba.service.Serializer;
import java.io.ByteArrayOutputStream;
import org.springframework.stereotype.Component;

/**
 * 使用hession实现序列化，反序列化
 */
@Component
public class HessianSerializer implements Serializer {

  @Override
  public void serializer(Object object, byte[] bytes) {
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    HessianOutput hessianOutput = new HessianOutput(byteArrayOutputStream);
    try{
      hessianOutput.writeObject(object);
    }catch (Exception e){
      throw new RuntimeException(e);
    }
  }

  @Override
  public void serializer(Object object, byte[] bytes, int offset, int count) {

  }

  @Override
  public <T> T deserializer(byte[] bytes) {
    return null;
  }

  @Override
  public <T> T deserializer(byte[] bytes, int offset, int count) {
    return null;
  }
}
