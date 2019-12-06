package com.simba.service;

public interface Serializer {

  /**
   * 序列化
   * @param object
   */
  byte[] serializer(Object object);

  /**
   *
   * @param object
   * @param offset
   * @param count
   */
  byte[] serializer(Object object,int offset,int count);

  /**
   * 反序列化
   * @param bytes
   * @param <T>
   * @return
   */
  <T> T deserializer(byte[] bytes);

  /**
   * 反序列化
   * @param bytes
   * @param offset
   * @param count
   * @param <T>
   * @return
   */
  <T> T deserializer(byte[] bytes,int offset,int count);
}
