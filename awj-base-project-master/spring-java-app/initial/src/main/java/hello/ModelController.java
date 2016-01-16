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
public class ModelController {


private List<Model>Model= new ArrayList<Model>();

ModelController()

{

       Model t1=new Model (1,"Samsung","S5","2014");
       Model t2=new Model (2,"Nokia","Lumia","2011");
       Model t3=new Model (3,"Htc","Desire","2015");
       Model t4=new Model (4,"Alcatel","M100","2005");

       Model.add(t1);
       Model.add(t2);
       Model.add(t3);
       Model.add(t4);


     }


      @RequestMapping(value="/Model", method = RequestMethod.GET)
      public List<Model> index() {
     return this.Model;
     }




     @RequestMapping(value="/Model/{Id}", method = RequestMethod.GET)
     public ResponseEntity show(@PathVariable("Id") int Id) {
     for(Model t : this.Model) {
     if(t.getId() == Id) {
      return new ResponseEntity<Model>(t, new HttpHeaders(), HttpStatus.OK);
      }
     }
      return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
     }

     @RequestMapping(value="/Model/{Nume}", method = RequestMethod.GET)
     public ResponseEntity show1(@PathVariable("Nume") String Nume) {
     for(Model t : this.Model) {
      if(t.getNume().equals(Nume)) {
        return new ResponseEntity<Model>(t, new HttpHeaders(), HttpStatus.OK);
      }
     }
     return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);

     }



      @RequestMapping(value="/Model/{Tiptelefon}", method = RequestMethod.GET)
      public ResponseEntity show2(@PathVariable("Tiptelefon") String Tiptelefon) {
      for(Model t: this.Model) {
      if(t.getTiptelefon().equals(Tiptelefon)) {
        return new ResponseEntity<Model>(t, new HttpHeaders(), HttpStatus.OK);
      }
     }
     return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
     }

      @RequestMapping(value="/Model/{An}", method = RequestMethod.GET)
     public ResponseEntity show3(@PathVariable("An") String An) {
      for(Model t: this.Model) {
        if(t.getAn().equals(An)) {
          return new ResponseEntity<Model>(t, new HttpHeaders(), HttpStatus.OK);
        }
      }
      return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);

	  
    }




      @RequestMapping(value="/Model/{Id}/{Nume}/{Tiptelefon}/{An}", method = RequestMethod.PUT)
      public ResponseEntity update(@PathVariable("Id") int Id,
                                   @PathVariable("Nume") String Nume,
                                   @PathVariable("TipModel") String Tiptelefon,
                                   @PathVariable("An") String An)
       {
        for(Model t : this.Model) {
          if(t.getId() == Id) {
          	t.setNume(Nume);
			t.setTiptelefon(Tiptelefon);
			t.setAn(An);


            return new ResponseEntity<Model>(t, new HttpHeaders(), HttpStatus.OK);
          }
        }


        return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);

       }





     @RequestMapping(value="/Model/", method = RequestMethod.POST)
  	 public ResponseEntity create(@RequestBody Model t5) {
	 Model.add(t5);

     return new ResponseEntity<Model>(t5, new HttpHeaders(), HttpStatus.OK);
     }




      @RequestMapping(value="/Model/{Id}", method = RequestMethod.DELETE)
      public ResponseEntity remove(@PathVariable("Id") int Id) {
          for(Model t: this.Model) {
          if(t.getId() == Id) {
          this.Model.remove(t);
           return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NO_CONTENT);
         }
          }
         return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
        }


           }
