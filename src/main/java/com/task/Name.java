package com.task;


public class Name {

  private String[] name;
  private int i;

  public Name(final int i) {

    this.i = i;

    this.name = new String[5];
    this.name[0] = "tanaka";
    this.name[1] = "suzuki";
    this.name[2] = "sato";
    this.name[3] = "inoue";
    this.name[4] = "sasaki";
  }


  @Override
  public String toString() {
    return this.name[this.i];
  }

}
