package tn.esprit.spring.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(	name = "Garage")
public class Garage  implements Serializable{
	/**
	 * 
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private int Nbr_Mecaniciens;


    private int année_Experience;
	private String photo_garage;
	private int etat ;
    @OneToOne
   private AdresseCites adressecite;
    private String addresse ;
    @OneToOne
    private Prestataire prestataire;
    private String description;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getNbr_Mecaniciens() {
		return Nbr_Mecaniciens;
	}
	public void setNbr_Mecaniciens(int nbr_Mecaniciens) {
		Nbr_Mecaniciens = nbr_Mecaniciens;
	}
	

	
	public int getAnnée_Experience() {
		return année_Experience;
	}
	public void setAnnée_Experience(int année_Experience) {
		this.année_Experience = année_Experience;
	}
	public String getPhoto_garage() {
		return photo_garage;
	}
	public void setPhoto_garage(String photo_garage) {
		this.photo_garage = photo_garage;
	}
	public AdresseCites getAdressecite() {
		return adressecite;
	}
	public void setAdressecite(AdresseCites adressecite) {
		this.adressecite = adressecite;
	}
	public String getAddresse() {
		return addresse;
	}
	public void setAddresse(String addresse) {
		this.addresse = addresse;
	}
	public Prestataire getPrestataire() {
		return prestataire;
	}
	public void setPrestataire(Prestataire prestataire) {
		this.prestataire = prestataire;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getEtat() {
		return etat;
	}
	public void setEtat(int etat) {
		this.etat = etat;
	}
	

}
