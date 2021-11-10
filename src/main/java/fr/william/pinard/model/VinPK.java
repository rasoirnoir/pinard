package fr.william.pinard.model;

import java.io.Serializable;

public class VinPK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer codeProduit;
    private String designation;
    
	public VinPK(Integer codeProduit, String designation) {
		super();
		this.codeProduit = codeProduit;
		this.designation = designation;
	}
    
	public VinPK() {}
    
}
