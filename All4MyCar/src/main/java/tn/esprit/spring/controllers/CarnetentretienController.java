package tn.esprit.spring.controllers;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.models.Carburant_Carnet;
import tn.esprit.spring.models.Client;
import tn.esprit.spring.models.Depense_carnet;
import tn.esprit.spring.models.Entretien_Carnet;
import tn.esprit.spring.models.Historique_carnet;
import tn.esprit.spring.models.Odometer_carnet;
import tn.esprit.spring.models.Trajet_carnet;
import tn.esprit.spring.models.Vehicule;
import tn.esprit.spring.services.CarnetentretienService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value="/api")
public class CarnetentretienController {

	@Autowired
	CarnetentretienService carnetservice;
	@CrossOrigin(origins = "http://localhost:4200")

	@PostMapping("/ajouter_carburant")
	public String ajouter_carburant(@RequestBody Carburant_Carnet c) {
		
		return carnetservice.ajouter_carburant(c);
	}
	@CrossOrigin(origins = "http://localhost:4200")

	@PostMapping("/ajouter_depense")
	public String ajouter_depense(@RequestBody Depense_carnet d) {
		
		return carnetservice.ajouter_depense(d);
	}
	@CrossOrigin(origins = "http://localhost:4200")

	@PostMapping("/ajouter_entretien")
	public String ajouter_entretien(@RequestBody Entretien_Carnet e) {
		
		return carnetservice.ajouter_entretien(e);
	}
	

	
	@CrossOrigin(origins = "http://localhost:4200")

	@PostMapping("/ajouter_trajet")
	public String ajouter_trajet(@RequestBody Trajet_carnet t) throws ParseException {
		
		return carnetservice.ajouter_trajet(t);
	}
	@CrossOrigin(origins = "http://localhost:4200")

	
	@PostMapping("/ajouter_odometer")
	public String ajouter_odometer(@RequestBody Odometer_carnet o) {
		
		return carnetservice.ajouter_odometer(o);
	}
	@CrossOrigin(origins = "http://localhost:4200")

@DeleteMapping("/deletecarburant/{idcarburant}")
	
	public String removecarburant(@PathVariable(value = "idcarburant") long idcarburant) {
	 
	  
			return carnetservice.delete_carburant(idcarburant);
			
		}
	@CrossOrigin(origins = "http://localhost:4200")

@DeleteMapping("/deleteentretien/{identretien}")

public String removeentretien(@PathVariable(value = "identretien") long identretien) {
 
  
		return carnetservice.delete_entretien(identretien);
		
	}

	@CrossOrigin(origins = "http://localhost:4200")

@DeleteMapping("/deletetrajet/{idtrajet}")

public String removetrajet(@PathVariable(value = "idtrajet") long idtrajet) {
 
  
		return carnetservice.delete_trajet(idtrajet);
		
	}
	@CrossOrigin(origins = "http://localhost:4200")


@DeleteMapping("/deleteodometer/{idodometer}")

public String removeodometer(@PathVariable(value = "idodometer") long idodometer) {
 
  
		return carnetservice.delete_odometer(idodometer);
		
	}
@CrossOrigin(origins = "http://localhost:4200")

@DeleteMapping("/deletedepense/{iddepense}")

public String removedepense(@PathVariable(value = "iddepense") long iddepense) {
 
  
		return carnetservice.delete_depense(iddepense);
		
	}
	
	
	
	////////////////////////////////////////////////
@CrossOrigin(origins = "http://localhost:4200")

	        @GetMapping("/getCarburantParPeriode/{idvehicule}/{periode}")
	        public List <Carburant_Carnet> getCarburantParPeriode(@PathVariable(value = "idvehicule") long vehiculeId,@PathVariable(value = "periode") String periode){
		         return carnetservice.getCarburantParPeriode(vehiculeId,periode);
	}
	        @CrossOrigin(origins = "http://localhost:4200")

	        @GetMapping("/getEntretienParPeriode/{idvehicule}/{periode}")
			public List <Entretien_Carnet> getEntretienParPeriode(@PathVariable(value = "idvehicule") long vehiculeId,@PathVariable(value = "periode") String periode){
				 return carnetservice.getEntretienParPeriode(vehiculeId,periode);
			}
			
			@CrossOrigin(origins = "http://localhost:4200")

	        @GetMapping("/getDepenseParPeriode/{idvehicule}/{periode}")
			public List <Depense_carnet> getDepenseParPeriode(@PathVariable(value = "idvehicule") long vehiculeId,@PathVariable(value = "periode") String periode){
				 return carnetservice.getDepenseParPeriode(vehiculeId,periode);
			}
			@CrossOrigin(origins = "http://localhost:4200")

			@GetMapping("/getOdometerParPeriode/{idvehicule}/{periode}")
			public List <Odometer_carnet> getOdometerParPeriode(@PathVariable(value = "idvehicule") long vehiculeId,@PathVariable(value = "periode") String periode){
				 return carnetservice.getOdometerParPeriode(vehiculeId,periode);
			}
			@CrossOrigin(origins = "http://localhost:4200")

			@GetMapping("/getTrajetParPeriode/{idvehicule}/{periode}")
			public List <Trajet_carnet> getTrajetParPeriode(@PathVariable(value = "idvehicule") long vehiculeId,@PathVariable(value = "periode") String periode){
				 return carnetservice.getTrajetParPeriode(vehiculeId,periode);
			}

			
			
			
			/////////////
			@CrossOrigin(origins = "http://localhost:4200")

			@GetMapping("/getDepense_carburantMois/{idvehicule}/{periode}")
			 public float getDepense_carburantMois(@PathVariable(value = "idvehicule") long vehiculeId,@PathVariable(value = "periode") String periode){
				 return carnetservice.getDepense_carburantMois(vehiculeId,periode);
		}
			@CrossOrigin(origins = "http://localhost:4200")

			@GetMapping("/getRemplis_carburantMois/{idvehicule}/{periode}")
			 public float getRemplis_carburantMois(@PathVariable(value = "idvehicule") long vehiculeId,@PathVariable(value = "periode") String periode){
				 return carnetservice.getRemplis_carburantMois(vehiculeId,periode);
		}
			
			//////
			@CrossOrigin(origins = "http://localhost:4200")

			@GetMapping("/getNbr_entretienMois/{idvehicule}/{periode}")
			 public float getNbr_entretienMois(@PathVariable(value = "idvehicule") long vehiculeId,@PathVariable(value = "periode") String periode){
				 return carnetservice.getNbr_entretienMois(vehiculeId,periode);
		}
			@CrossOrigin(origins = "http://localhost:4200")

			@GetMapping("/getDepense_entretienMois/{idvehicule}/{periode}")
			 public float getDepense_entretienMois(@PathVariable(value = "idvehicule") long vehiculeId,@PathVariable(value = "periode") String periode){
				 return carnetservice.getDepense_entretienMois(vehiculeId,periode);
		}
			////////////////
			@CrossOrigin(origins = "http://localhost:4200")

			
			@GetMapping("/getKilometrage_jour/{idvehicule}/{periode}")
			 public float getKilometrage_jour(@PathVariable(value = "idvehicule") long vehiculeId,@PathVariable(value = "periode") String periode){
				 return carnetservice.getKilometrage_jour(vehiculeId,periode);
		}
			@CrossOrigin(origins = "http://localhost:4200")

			@GetMapping("/getKilometrage_semaine/{idvehicule}/{periode}")
			 public float getKilometrage_semaine(@PathVariable(value = "idvehicule") long vehiculeId,@PathVariable(value = "periode") String periode){
				 return carnetservice.getKilometrage_semaine(vehiculeId,periode);
		}
			@CrossOrigin(origins = "http://localhost:4200")

			@GetMapping("/getKilometrage_mois/{idvehicule}/{periode}")
			 public float getKilometrage_mois(@PathVariable(value = "idvehicule") long vehiculeId,@PathVariable(value = "periode") String periode){
				 return carnetservice.getKilometrage_mois(vehiculeId,periode);
		}
			
			@CrossOrigin(origins = "http://localhost:4200")

			@GetMapping("/getKilometrage_annee/{idvehicule}/{periode}")
			 public float getKilometrage_annee(@PathVariable(value = "idvehicule") long vehiculeId,@PathVariable(value = "periode") String periode){
				 return carnetservice.getKilometrage_annee(vehiculeId,periode);
		}

			
}
