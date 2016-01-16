package hello.models;

import java.util.List;
import java.util.ArrayList;

public class Telefon {

 private int Id;
 private String Nume;

  public Telefon() {}

  public Telefon(int id, String nume)
  {
      this.Id=id;
      this.Nume=nume;

  }

    public int getId()
  {
  return this.Id;

  }


  public String getNume(){
  return  this.Nume;

  }

  public void setId(int id)
  {
	  this.Id=id;
  }

  public void setNume(String nume){
  this.Nume=nume;
  }
}
