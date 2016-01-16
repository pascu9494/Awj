package hello.models;

public class Model extends Telefon


{
    String Tiptelefon,An;


      public Model(int id,String n,String tiptelefon,String an)


     {

      super(id,n);
      this.Tiptelefon=tiptelefon;
      this.An=an;

       }


       public String getTiptelefon()
     {

      return this.Tiptelefon;
      }

      public String getAn()
     {
      return this.An;
	  
     }

      public void setTiptelefon(String tiptelefon)
     {
      this.Tiptelefon=tiptelefon;
     }

     public void setAn(String An)
     {
      this.An=An;
     }

     }