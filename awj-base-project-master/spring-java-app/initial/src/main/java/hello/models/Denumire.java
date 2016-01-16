package hello.models;

public class Denumire extends Laptop


{
    String Tiplaptop,An;


      public Denumire(int id,String n,String tiplaptop,String an)


     {

      super(id,n);
      this.Tiplaptop=tiplaptop;
      this.An=an;

       }


       public String getTiplaptop()
     {

      return this.Tiplaptop;
      }

      public String getAn()
     {
      return this.An;
	  
     }

      public void setTiplaptop(String tiplaptop)
     {
      this.Tiplaptop=tiplaptop;
     }

     public void setAn(String An)
     {
      this.An=An;
     }

     }