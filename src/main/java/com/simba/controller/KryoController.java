package com.simba.controller;


import com.esotericsoftware.kryo.Kryo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kryo")
public class KryoController {

  @RequestMapping("/test")
  public String test(){
    return "test";
  }

  @RequestMapping("/kayo")
  public String kayo(){
    Kryo kryo = new Kryo();
    kryo.
    return "test";
  }

}
