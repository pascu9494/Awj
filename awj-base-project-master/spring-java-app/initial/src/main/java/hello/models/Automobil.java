package hello.models;

import java.util.List;
import java.util.ArrayList;

public class Automobil {

 private int Id;
 private String Name;

  public Automobil() {}

  public Automobil(int id, String name)
  {
      this.Id=id;
      this.Name=name;

  }

  public int getId()
  {
  return this.Id;

  }


  public String getName(){
  return  this.Name;

  }

  public void setId(int id)
  {
	  this.Id=id;
  }

  public void setName(String name){
  this.Name=name;
  }
}
