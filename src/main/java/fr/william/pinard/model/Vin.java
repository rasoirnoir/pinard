package fr.william.pinard.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Transient;

import lombok.Data;

@Entity
@Data
public class Vin {

	public enum choix {ROUGE, BLANC, ROSE};
	
//	@Id
//	private Integer codeProduit;
//	
//	@Id
//	private String designation;
	
	@EmbeddedId
	public VinPK vinPK;
	
	
	private String region;
	
	@Enumerated(value = EnumType.STRING)
	@Column(length = 5)
	private choix couleur;
	
	private double prix;
	
	private double remise;
	
	private int quantite;

	public VinPK getVinPK() {
		return vinPK;
	}

	public void setVinPK(VinPK vinPK) {
		this.vinPK = vinPK;
	}

	@Transient
	public Integer getCodeProduit() {
		return vinPK.getCodeProduit();
	}

	public void setCodeProduit(Integer codeProduit) {
		this.vinPK.setCodeProduit(codeProduit);
	}

	@Transient
	public String getDesignation() {
		return vinPK.getDesignation();
	}

	public void setDesignation(String designation) {
		this.vinPK.setDesignation(designation);
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public choix getCouleur() {
		return couleur;
	}

	public void setCouleur(choix couleur) {
		this.couleur = couleur;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public double getRemise() {
		return remise;
	}

	public void setRemise(double remise) {
		this.remise = remise;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	
	
}
