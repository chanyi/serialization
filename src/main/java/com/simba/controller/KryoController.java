package com.simba.controller;


import com.simba.model.SubTestSerialization;
import com.simba.model.TestSerialization;
import com.simba.service.impl.KryoSerializer;
import java.util.Arrays;
import org.junit.Test;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kryo")
/**
 * kryo序列化类，是有
 */
public class KryoController {

  @RequestMapping("/test")
  public String test(){
    return "test";
  }

  @Test
  public void kayoSerializer(){
    byte[] bytes =new byte[200];
    String[] strings = {"s","s1"};
    System.out.println(Arrays.toString(bytes));
    KryoSerializer kryoSerializer = new KryoSerializer();
    kryoSerializer.setaClass(TestSerialization.class);
    TestSerialization testSerialization = new TestSerialization();
    testSerialization.setText("aaaaasdwe");
    testSerialization.setName("f");
    testSerialization.setId(999);
    testSerialization.setFlag(false);
    testSerialization.setList(Arrays.asList(strings));
    SubTestSerialization subTestSerialization = new SubTestSerialization();
    subTestSerialization.setName("test");
    testSerialization.setSubTestSerialization(subTestSerialization);

    kryoSerializer.serializer(testSerialization,bytes);
    System.out.println(testSerialization.toString());
    System.out.println(Arrays.toString(bytes));
    System.out.println("=====================================");
    TestSerialization testSerialization1 = kryoSerializer.deserializer(bytes);
    System.out.println(testSerialization1.toString());
    System.out.println(Arrays.toString(bytes));
  }

}
