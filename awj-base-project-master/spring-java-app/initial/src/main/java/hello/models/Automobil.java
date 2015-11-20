package hello.models;

import java.util.List;
import java.util.ArrayList;

public class Automobil {

 private int Id;
 private String Nume;

  public Automobil() {}

  public Automobil(int id, String nume)
  {
      this.Id=id;
      this.Nume=nume;

  }

    public int getId()
  {
  return this.Id;

  }


  public String getNume(){
  return  this.Name;

  }

  public void setId(int id)
  {
	  this.Id=id;
  }

  public void setNume(String nume){
  this.Nume=nume;
  }
}
