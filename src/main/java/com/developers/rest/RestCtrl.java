package com.developers.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.developers.model.Product;
import com.developers.repo.ICategory;
import com.developers.repo.IProduct;

@RestController
public class RestCtrl {

	@Autowired
	private IProduct product;

	@Autowired
	private ICategory category;

	@PostMapping("/save")
	public String save(@RequestBody Product p) {
		p.getCategories().forEach(ct->ct.setCName(ct.getCName()));
		
		Product save = product.save(p);
		return "data saved :: id :: " + save.getPId();
	}

	@GetMapping("/save")
	public List<Product> getListOfData() {
		List<Product> listOfProduct = product.findAll();
		return listOfProduct;
	}

	@GetMapping("/save/{pId}")
	public Product getData(@PathVariable Integer pId) {
		Optional<Product> productItem = product.findById(pId);
		return productItem.get();
	}
}
