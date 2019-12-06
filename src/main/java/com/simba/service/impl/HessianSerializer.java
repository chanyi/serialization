package com.simba.service.impl;

import com.caucho.hessian.io.HessianInput;
import com.caucho.hessian.io.HessianOutput;
import com.simba.service.Serializer;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import org.springframework.stereotype.Component;

/**
 * 使用hession实现序列化，反序列化
 */
@Component
public class HessianSerializer implements Serializer {

  @Override
  /**
   * hession序列化
   */
  public byte[] serializer(Object object) {
    byte[] bytes = new byte[200];
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    HessianOutput hessianOutput = new HessianOutput(byteArrayOutputStream);
    try{
      hessianOutput.writeObject(object);
      bytes = byteArrayOutputStream.toByteArray();
    }catch (Exception e){
      throw new RuntimeException(e);
    }finally {
      try {
        byteArrayOutputStream.close();
        hessianOutput.close();
      }catch (Exception e){
        throw new RuntimeException(e);
      }
    }
    return bytes;
  }

  @Override
  public byte[] serializer(Object object, int offset, int count) {
    return null;
  }

  @Override
  public <T> T deserializer(byte[] bytes) {
    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
    HessianInput hessianInput = new HessianInput(byteArrayInputStream);
    try{
      return (T) hessianInput.readObject();
    }catch (IOException e){
      throw new RuntimeException(e);
    }finally {
      try {
        byteArrayInputStream.close();
        hessianInput.close();
      }catch (Exception e){
        throw new RuntimeException(e);
      }

    }

  }

  @Override
  public <T> T deserializer(byte[] bytes, int offset, int count) {
    return null;
  }
}
