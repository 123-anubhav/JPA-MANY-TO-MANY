package com.developers.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import lombok.Data;

@Entity
@Data
public class Category {
	
	@Id
	@GeneratedValue
	private Integer cId;
	private String cName;
	
	//@ManyToMany
	//@JoinColumn(name="fk_key")
	//private List<Product> products;

}
