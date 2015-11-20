package hello;


import hello.models.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.ArrayList;



@RestController
public class AutomobilController {


private List<Automobil>automobil= new ArrayList<Automobil>();

AutomobilController()

{

       Automobil a1=new Automobil (1,"Audi","R7","2009");
       Automobil a2=new Automobil (2,"Bmw","i8","2010");
       Automobil a3=new Automobil (3,"Fiat","500","2011");


    automobil.add(a1);
    automobil.add(a2);
    automobil.add(a3);



  }


  @RequestMapping(value="/Automobil", method = RequestMethod.GET)
   public List<Automobil> index() {
  return this.automobil;
}


 @RequestMapping(value="/Automobil/{Id}", method = RequestMethod.GET)
 public ResponseEntity show(@PathVariable("Id") int Id) {
  for(Automobil a : this.automobil) {
    if(a.getId() == Id) {
      return new ResponseEntity<Automobil>(a, new HttpHeaders(), HttpStatus.OK);
      }
  }
      return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }

  @RequestMapping(value="/Automobil/{Nume}", method = RequestMethod.GET)
  public ResponseEntity show1(@PathVariable("Nume") String Nume) {
    for(Automobil a : this.automobil) {
      if(a.getNume().equals(Nume)) {
        return new ResponseEntity<Automobil>(a, new HttpHeaders(), HttpStatus.OK);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);

  }



  @RequestMapping(value="/Automobil/{TipAutomobil}", method = RequestMethod.GET)
  public ResponseEntity show2(@PathVariable("TipAutomobil") String TipAutomobil) {
    for(Automobil a : this.automobil) {
      if(a.getTipAutomobil().equals(TipAutomobil)) {
        return new ResponseEntity<Automobil>(a, new HttpHeaders(), HttpStatus.OK);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }

   @RequestMapping(value="/Automobil/{An}", method = RequestMethod.GET)
    public ResponseEntity show3(@PathVariable("An") String An) {
      for(Automobil a : this.automobil) {
        if(a.getAn().equals(An)) {
          return new ResponseEntity<Automobil>(a, new HttpHeaders(), HttpStatus.OK);
        }
      }
      return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);

    }
    @RequestMapping(value="/Automobil/{Id}{Nume}{TipAutomobil}{An}", method = RequestMethod.PUT)
      public ResponseEntity update(@PathVariable("Id")int Id,
        @PathVariable("Nume") String Nume,
        @PathVariable("TipAutomobil") String TipAutomobil,
        @PathVariable("An") String An)
       {
        for(Automobil a : this.automobil) {
          if(a.getId() == Id) {
          	a.setName(Nume);
			a.setTipAutomobil(TipAutomobil);
			a.setAn(An);


            return new ResponseEntity<Automobil>(a, new HttpHeaders(), HttpStatus.OK);
          }
        }


        return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);

       }



  @RequestMapping(value="/Automobil/", method = RequestMethod.POST)
  	public ResponseEntity create() {
	 Automobil a4=new Automobil(4,"v40",2006,"Volvo");
	 automobil.add(a4);

       return new ResponseEntity<Automobil>(a4, new HttpHeaders(), HttpStatus.OK);
     }


    @RequestMapping(value="/Automobil/{Id}", method = RequestMethod.DELETE)
   public ResponseEntity remove(@PathVariable("Id") int Id) {
     for(Marca a: this.marca) {
       if(a.getId() == Id) {
         this.marca.remove(a);
         return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NO_CONTENT);
       }
     }
     return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
   }


      }

}


