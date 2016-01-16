package hello;


import hello.models.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.ArrayList;



@RestController
public class DenumireController {


private List<Denumire>Denumire= new ArrayList<Denumire>();

DenumireController()

{

       Denumire l1=new Denumire (1,"Asus","R555JB-Xo010D","2015");
       Denumire l2=new Denumire (2,"Lenovo","IdeaPad G50-80","2012");
       Denumire l3=new Denumire (3,"Dell","Inspiron 3552","2013");
       Denumire l4=new Denumire (4,"Toshiba","Satellite C55-C-173","2011");

       Denumire.add(l1);
       Denumire.add(l2);
       Denumire.add(l3);
       Denumire.add(l4);


     }


      @RequestMapping(value="/Denumire", method = RequestMethod.GET)
      public List<Denumire> index() {
     return this.Denumire;
     }




     @RequestMapping(value="/Denumire/{Id}", method = RequestMethod.GET)
     public ResponseEntity show(@PathVariable("Id") int Id) {
     for(Denumire l : this.Denumire) {
     if(l.getId() == Id) {
      return new ResponseEntity<Denumire>(l, new HttpHeaders(), HttpStatus.OK);
      }
     }
      return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
     }

     @RequestMapping(value="/Denumire/{Nume}", method = RequestMethod.GET)
     public ResponseEntity show1(@PathVariable("Nume") String Nume) {
     for(Denumire l : this.Denumire) {
      if(l.getNume().equals(Nume)) {
        return new ResponseEntity<Denumire>(l, new HttpHeaders(), HttpStatus.OK);
      }
     }
     return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);

     }



      @RequestMapping(value="/Denumire/{Tiplaptop}", method = RequestMethod.GET)
      public ResponseEntity show2(@PathVariable("Tiplaptop") String Tiplaptop) {
      for(Denumire l: this.Denumire) {
      if(l.getTiplaptop().equals(Tiplaptop)) {
        return new ResponseEntity<Denumire>(l, new HttpHeaders(), HttpStatus.OK);
      }
     }
     return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
     }

      @RequestMapping(value="/Denumire/{An}", method = RequestMethod.GET)
     public ResponseEntity show3(@PathVariable("An") String An) {
      for(Denumire l: this.Denumire) {
        if(l.getAn().equals(An)) {
          return new ResponseEntity<Denumire>(l, new HttpHeaders(), HttpStatus.OK);
        }
      }
      return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);

	  
    }




      @RequestMapping(value="/Denumire/{Id}/{Nume}/{Tiplaptop}/{An}", method = RequestMethod.PUT)
      public ResponseEntity update(@PathVariable("Id") int Id,
                                   @PathVariable("Nume") String Nume,
                                   @PathVariable("TipDenumire") String Tiplaptop,
                                   @PathVariable("An") String An)
       {
        for(Denumire l: this.Denumire) {
          if(l.getId() == Id) {
          	l.setNume(Nume);
			l.setTiplaptop(Tiplaptop);
			l.setAn(An);


            return new ResponseEntity<Denumire>(l, new HttpHeaders(), HttpStatus.OK);
          }
        }


        return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);

       }





     @RequestMapping(value="/Denumire/", method = RequestMethod.POST)
  	 public ResponseEntity create(@RequestBody Denumire l5) {
	 Denumire.add(l5);

     return new ResponseEntity<Denumire>(l5, new HttpHeaders(), HttpStatus.OK);
     }




      @RequestMapping(value="/Denumire/{Id}", method = RequestMethod.DELETE)
      public ResponseEntity remove(@PathVariable("Id") int Id) {
          for(Denumire l: this.Denumire) {
          if(l.getId() == Id) {
          this.Denumire.remove(l);
           return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NO_CONTENT);
         }
          }
         return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
        }


           }
