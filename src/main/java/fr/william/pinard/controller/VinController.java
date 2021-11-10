package fr.william.pinard.controller;

import java.util.Collection;
import java.util.Iterator;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import fr.william.pinard.model.Vin;
import fr.william.pinard.repository.VinRepository;

@Controller
@CrossOrigin("*")
public class VinController {

	@Autowired
	private VinRepository vinRepository;
	
	@GetMapping("/")
	@ResponseBody
	public String home(){
		
		Vin v1=new Vin();
		v1.setCodeProduit(765439);
		v1.setDesignation("Les Hauts du Tertre 1999");
		v1.setRegion("Bordeaux (Margaux)");
		v1.setCouleur("rouge");
		v1.setPrix(11.50);
		v1.setRemise(0);
		v1.setQuantite(2);

		Vin v2=new Vin();
		v2.setCodeProduit(543289);
		v2.setDesignation("Château Marquis de Terme 1998");
		v2.setRegion("Bordeaux (Margaux)");
		v2.setCouleur("rouge");
		v2.setPrix(19.00);
		v2.setRemise(0);
		v2.setQuantite(3);

		Vin v3=new Vin();
		v3.setCodeProduit(782377);
		v3.setDesignation("Clos du Marquis 1999");
		v3.setRegion("Bordeaux (Saint-Julien)");
		v3.setCouleur("rouge");
		v3.setPrix(22.90);
		v3.setRemise(0);
		v3.setQuantite(15);

		Vin v4=new Vin();
		v4.setCodeProduit(974534);
		v4.setDesignation("Clos du Baron 1998");
		v4.setRegion("Bordeaux (Saint-Julien)");
		v4.setCouleur("blanc");
		v4.setPrix(45.20);
		v4.setRemise(0);
		v4.setQuantite(54);


		System.out.println("ajout du produit v1 : "+v1);
		ajoutVin(v1);

		System.out.println("ajout du produit v2 : "+v2);
		ajoutVin(v2);

		System.out.println("ajout du produit v3 : "+v3);
		ajoutVin(v3);
		v3.setQuantite(10);

		System.out.println("ajout du produit v4 : "+v4);
		ajoutVin(v4);

		updateQuantite(v4.getCodeProduit(),50);

		System.out.println("liste des vins enregistrés :");
		Collection<Vin> vins=findAll();
		Iterator<Vin> it=vins.iterator();
		while(it.hasNext())
		{
			System.out.println(it.next());
		}

		System.out.println("suppression du vin "+v3);
		deleteVin(782377);



		System.out.println("liste des vins enregistrés:");
		vins = findAll();
		it=vins.iterator();
		while(it.hasNext())
		{
			System.out.println(it.next());
		}
		
		return "<h1>Regardez dans votre console et dans votre base de données MySQL <strong>JPA</strong></h1>";
	}

	

	public Optional<Vin> findByCodeProduit(Integer codeProduit){
		return vinRepository.findById(codeProduit);
	}
	/**
	 * Retourne tous les produits dans une liste
	 */
	@SuppressWarnings("unchecked")
	public Collection<Vin> findAll(){

		return vinRepository.findAll();
	}
	/**
	 * Ajoute un vin
	 */
	public void ajoutVin(Vin vin){
		vinRepository.saveAndFlush(vin);
	}
	/**
	 * Met un jour un enregistrement pour un objet Vin
	 */
	public Vin updateVin(Vin vin){
		return vinRepository.saveAndFlush(vin);
	}

	/**
	 * Méthode qui détruit un objet de type Vin en fonction de son code
	 * et si ce dernier existe !
	 */
	public void deleteVin (Integer codeProduit){
		
		vinRepository.delete(vinRepository.getById(codeProduit));
	}

	/**
	 * Met à jour la quantité d'un objet de type Vin
	 */
	public void updateQuantite(Integer codeProduit, int quantite){
		(vinRepository.getById(codeProduit)).setQuantite(quantite);
	}
}
