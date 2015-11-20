package hello.models;

public class Marca extends Automobil


{
    String Automobil,An;


  public Marca(int id,String n,String tipautomobil,String an)


  {

      super(id,n);
      this.TipAutomobil=tipautomobil;
      this.An=an;

  }


  public String getTipAutomobil()
  {

      return this.TipAutomobil;
  }

  public String getAn()
  {
      return this.An;
  }

  public void setTipAutomobile(String tipautomobile)
  {
      this.TipAutomobile=tipautomobile;
  }

  public void setAn(String An)
  {
      this.An=an;
  }

  }
