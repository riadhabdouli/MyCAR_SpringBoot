package tn.esprit.spring.controllers;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import tn.esprit.spring.models.AdresseCites;
import tn.esprit.spring.models.Garage;
import tn.esprit.spring.models.Prestataire;
import tn.esprit.spring.models.Vehicule;
import tn.esprit.spring.models.Vehicule_model;
import tn.esprit.spring.repository.GarageRepository;
import tn.esprit.spring.services.GarageService;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value="/api")
public class GarageController {
	@Autowired
	GarageService garageservice;
	
	
	
	@Autowired
	GarageRepository garagerepository;
	@CrossOrigin(origins = "http://localhost:4200")

@PostMapping("/addgarage")
	
	public String add_garage(@RequestBody Garage garage) {
	 
	  
			return garageservice.add_Garage(garage);
			
		}
@CrossOrigin(origins = "http://localhost:4200")

@GetMapping("/getgarage")
public Garage getGarage(){
	 return garageservice.findGarage();
}

private static String UPLOADED_FOLDER = System.getProperty("user.dir")+"/src/main/resources";	
@CrossOrigin(origins = "http://localhost:4200")

@PostMapping("/addgaragee/{nbrMecaniciens}/{date_ouverture}/{anneesexperiences}/{adresse}/{idadressecite}/{description}")
	
	public String add_garage(@PathVariable(value = "nbrMecaniciens") int nbrMecaniciens,@PathVariable(value = "date_ouverture") Date dateouverture,
			@PathVariable(value = "anneesexperiences") int anneesexperiences,@PathVariable(value = "adresse") String ad,@PathVariable(value = "idadressecite") long idadressecite,@PathVariable(value = "description") String description,@RequestParam("file") MultipartFile file)
{
	   Garage garage = new Garage();
	   File dir = new File(UPLOADED_FOLDER);
	      if (!dir.exists())
				dir.mkdirs();
	      System.out.println("c bnsssssssssssssssssssaaaaaas ");
	      File fileToImport = null;
	      if (dir.isDirectory()) {
	    	  System.out.println("c bnssssssssssssssssssssssssssssssssss ");
	    	  try {
		        	
		        	System.out.println("c bn ");
		        	
		            fileToImport = new File(dir + File.separator + file.getOriginalFilename());
		            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(fileToImport));
		            stream.write(file.getBytes());
		            stream.close();
		        } catch (Exception e) {
		            System.out.println("nnnnnnnnn");
		        }
	      }
	  
	    AdresseCites address = garageservice.getCitebyid(idadressecite);
	  
	      garage.setAddresse(ad);
	     garage.setAdressecite(address);
	      garage.setAnnée_Experience(anneesexperiences);
         garage.setPhoto_garage(file.getOriginalFilename());
         garage.setDescription(description);      
         garage.setNbr_Mecaniciens(nbrMecaniciens);
	     
	       //garage.setPhoto_garage(file.getOriginalFilename());
	  
	   
	   return garageservice.add_Garage(garage);
		
	}
@CrossOrigin(origins = "http://localhost:4200")

@GetMapping(value = "/afficheimagegarage/image/logo/{image}")
public ResponseEntity<InputStreamResource> getImage(@PathVariable(value = "image") String image ) throws IOException {

    ClassPathResource imgFile = new ClassPathResource(image);

    return ResponseEntity
            .ok()
            .contentType(MediaType.IMAGE_JPEG)
            .body(new InputStreamResource(imgFile.getInputStream()));
}
 
@CrossOrigin(origins = "http://localhost:4200")

@PostMapping("/addgaragee_sansverif/{nbrMecaniciens}/{date_ouverture}/{anneesexperiences}/{description}")

public String addgaragee_sansverif(@PathVariable(value = "nbrMecaniciens") int nbrMecaniciens,@PathVariable(value = "date_ouverture") Date dateouverture,
		@PathVariable(value = "anneesexperiences") int anneesexperiences,@PathVariable(value = "description") String description,@RequestParam("images[]") MultipartFile[] files)
{
   Garage garage = new Garage();
   File dir = new File(UPLOADED_FOLDER);
      if (!dir.exists())
			dir.mkdirs();
      System.out.println("c bnsssssssssssssssssssaaaaaas ");
      File fileToImport = null;
      if (dir.isDirectory()) {
    	  System.out.println("c bnssssssssssssssssssssssssssssssssss ");
    	  try {
	        	
	        	System.out.println("c bn ");
	        	
	        	 for ( int i=0;i<files.length;i++)
	    		  {
	            	 fileToImport = new File(dir + File.separator + files[i].getOriginalFilename());
	 	            BufferedOutputStream streamm = new BufferedOutputStream(new FileOutputStream(fileToImport));
	 	            streamm.write(files[i].getBytes());
	 	            streamm.close();
	    		  }
	        } catch (Exception e) {
	            System.out.println("nnnnnnnnn");
	        }
      }
      String cincartePhoto ="";
      for ( int i=0;i<files.length;i++)
      {
    	  System.out.println(files[i].getOriginalFilename());
    	  if (i==0){
      	cincartePhoto=cincartePhoto+files[i].getOriginalFilename();
    	  } else cincartePhoto=cincartePhoto+","+files[i].getOriginalFilename();
      }
  
      
      garage.setAnnée_Experience(anneesexperiences);
     garage.setPhoto_garage(cincartePhoto);
     garage.setDescription(description);      
     garage.setNbr_Mecaniciens(nbrMecaniciens);
     
       //garage.setPhoto_garage(file.getOriginalFilename());
  
   
   return garageservice.add_Garage(garage);
	
}
}
