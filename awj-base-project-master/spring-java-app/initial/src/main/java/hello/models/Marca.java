package hello.models;

public class Marca extends Automobil


{
    String Tipautomobil,An;


      public Marca(int id,String n,String tipautomobil,String an)


     {

      super(id,n);
      this.Tipautomobil=tipautomobil;
      this.An=an;

       }


       public String getTipAutomobil()
     {

      return this.Tipautomobil;
      }

      public String getAn()
     {
      return this.An;
	  
     }

      public void setTipautomobil(String tipautomobil)
     {
      this.Tipautomobil=tipautomobil;
     }

     public void setAn(String An)
     {
      this.An=an;
     }

     }
