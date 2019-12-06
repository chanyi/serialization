package com.simba.controller;


import com.simba.model.SubTestSerialization;
import com.simba.model.TestSerialization;
import com.simba.service.impl.HessianSerializer;
import com.simba.service.impl.KryoSerializer;
import java.util.Arrays;
import org.junit.Test;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kryo")
/**
 * hessian序列化类
 */
public class HessianController {

  @RequestMapping("/test")
  public String test(){
    return "test";
  }

  @Test
  public void hessianSerializer(){
    byte[] bytes =new byte[200];
    System.out.println(Arrays.toString(bytes));
    HessianSerializer hessianSerializer = new HessianSerializer();
    TestSerialization testSerialization = initTestSerialization();
    bytes = hessianSerializer.serializer(testSerialization);
    System.out.println(testSerialization.toString());
    System.out.println(Arrays.toString(bytes));
    System.out.println("=====================================");
    TestSerialization testSerialization1 = hessianSerializer.deserializer(bytes);
    System.out.println(testSerialization1.toString());
    System.out.println(Arrays.toString(bytes));
  }

  private TestSerialization initTestSerialization(){
    String[] strings = {"s","s1"};
    TestSerialization testSerialization = new TestSerialization();
    testSerialization.setText("aaaaasdwe");
    testSerialization.setName("f");
    testSerialization.setId(999);
    testSerialization.setFlag(false);
    testSerialization.setList(Arrays.asList(strings));
    SubTestSerialization subTestSerialization = new SubTestSerialization();
    subTestSerialization.setName("test");
    testSerialization.setSubTestSerialization(subTestSerialization);
    return testSerialization;
  }

}
