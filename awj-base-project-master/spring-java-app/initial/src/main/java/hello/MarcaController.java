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
public class MarcaController {


private List<Marca>Marca= new ArrayList<Marca>();

MarcaController()

{

       Marca a1=new Marca (1,"Audi","R7","2009");
       Marca a2=new Marca (2,"Bmw","i8","2010");
       Marca a3=new Marca (3,"Fiat","500","2011");
	   Marca a4=new Marca (4,"Ford Focus","GT","2014");
       Marca a5=new Marca (5,"Dacia","Logan","2005");

       Marca.add(a1);
       Marca.add(a2);
       Marca.add(a3);
       Marca.add(a4)
       Marca.add(a5)

     }


      @RequestMapping(value="/Marca", method = RequestMethod.GET)
      public List<Marca> index() {
     return this.Marca;
     }




     @RequestMapping(value="/Marca/{Id}", method = RequestMethod.GET)
     public ResponseEntity show(@PathVariable("Id") int Id) {
     for(Marca a : this.Marca) {
     if(a.getId() == Id) {
      return new ResponseEntity<Marca>(a, new HttpHeaders(), HttpStatus.OK);
      }
     }
      return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
     }

     @RequestMapping(value="/Marca/{Nume}", method = RequestMethod.GET)
     public ResponseEntity show1(@PathVariable("Nume") String Nume) {
     for(Marca a : this.Marca) {
      if(a.getNume().equals(Nume)) {
        return new ResponseEntity<Marca>(a, new HttpHeaders(), HttpStatus.OK);
      }
     }
     return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);

     }



      @RequestMapping(value="/Marca/{Tipautomobil}", method = RequestMethod.GET)
      public ResponseEntity show2(@PathVariable("Tipautomobil") String Tipautomobil) {
      for(Marca a : this.Marca) {
      if(a.getTipautomobil().equals(Tipautomobil)) {
        return new ResponseEntity<Marca>(a, new HttpHeaders(), HttpStatus.OK);
      }
     }
     return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
     }

      @RequestMapping(value="/Marca/{An}", method = RequestMethod.GET)
     public ResponseEntity show3(@PathVariable("An") String An) {
      for(Marca a : this.Marca) {
        if(a.getAn().equals(An)) {
          return new ResponseEntity<Marca>(a, new HttpHeaders(), HttpStatus.OK);
        }
      }
      return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);

    }




      @RequestMapping(value="/Marca/{Id}/{Nume}/{Tipautomobil}/{An}", method = RequestMethod.PUT)
      public ResponseEntity update(@PathVariable("Id") int Id,
                                   @PathVariable("Nume") String Nume,
                                   @PathVariable("TipMarca") String Tipautomobil,
                                   @PathVariable("An") String An)
       {
        for(Marca a : this.Marca) {
          if(a.getId() == Id) {
          	a.setNume(Nume);
			a.setTipautomobil(Tipautomobil);
			a.setAn(An);


            return new ResponseEntity<Marca>(a, new HttpHeaders(), HttpStatus.OK);
          }
        }


        return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);

       }





     @RequestMapping(value="/Marca/", method = RequestMethod.POST)
  	 public ResponseEntity create() {
	 Marca a6=new Marca(6,"v40","2006","Volvo");
	 Marca.add(a6);

     return new ResponseEntity<Marca>(a6, new HttpHeaders(), HttpStatus.OK);
     }




      @RequestMapping(value="/Marca/{Id}", method = RequestMethod.DELETE)
      public ResponseEntity remove(@PathVariable("Id") int Id) {
          for(Marca a: this.Marca) {
          if(a.getId() == Id) {
          this.Marca.remove(a);
           return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NO_CONTENT);
         }
          }
         return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
        }


           }


}

