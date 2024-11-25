package com.developers.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Data;

@Entity
@Data
public class Product {

	@Id
	@GeneratedValue
	private Integer pId;
	private String pName;
	private Double pPrice;

	// @ManyToMany(mappedBy = "products")
	@ManyToMany(targetEntity = Category.class, cascade = CascadeType.ALL)
	@JoinTable(name = "new_tbl", joinColumns = @JoinColumn( referencedColumnName = "pId"))
	private List<Category> categories;
}
