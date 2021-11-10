package fr.william.vin.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Vin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codeProduit;
	private String designation;
	private String region;
	private String couleur;
	private double prix;
	private double remise;
	private int quantite;
	public Integer getCodeProduit() {
		return codeProduit;
	}
	public void setCodeProduit(Integer codeProduit) {
		this.codeProduit = codeProduit;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getCouleur() {
		return couleur;
	}
	public void setCouleur(String couleur) {
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
	@Override
	public int hashCode() {
		return Objects.hash(codeProduit, couleur, designation, prix, quantite, region, remise);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vin other = (Vin) obj;
		return Objects.equals(codeProduit, other.codeProduit) && Objects.equals(couleur, other.couleur)
				&& Objects.equals(designation, other.designation)
				&& Double.doubleToLongBits(prix) == Double.doubleToLongBits(other.prix) && quantite == other.quantite
				&& Objects.equals(region, other.region)
				&& Double.doubleToLongBits(remise) == Double.doubleToLongBits(other.remise);
	}
	@Override
	public String toString() {
		return "Vin [codeProduit=" + codeProduit + ", designation=" + designation + ", region=" + region + ", couleur="
				+ couleur + ", prix=" + prix + ", remise=" + remise + ", quantite=" + quantite + "]";
	}
	
	
}
