package com.simba.model;

import java.io.Serializable;
import java.util.List;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@Getter
@Setter
@ToString
public class SubTestSerialization  implements Serializable {
  private String text;
  private String name;
  private int id ;
  private boolean flag;
  private List<String> list;
}
