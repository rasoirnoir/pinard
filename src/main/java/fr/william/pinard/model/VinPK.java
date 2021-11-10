package fr.william.pinard.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Embeddable
@Data
public class VinPK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer codeProduit;
	
	@Column(length = 50)
    private String designation;
    
	public VinPK(Integer codeProduit, String designation) {
		super();
		this.codeProduit = codeProduit;
		this.designation = designation;
	}
    
	public VinPK() {}
    
}
