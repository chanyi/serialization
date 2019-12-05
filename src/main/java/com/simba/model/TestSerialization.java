package com.simba.model;

import java.util.List;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@Getter
@Setter
@ToString
public class TestSerialization {
  private String text;
  private String name;
  private int id ;
  private boolean flag;
  private List<String> list;
  private SubTestSerialization subTestSerialization;
}
