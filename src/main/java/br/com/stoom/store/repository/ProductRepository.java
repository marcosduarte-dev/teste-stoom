package br.com.stoom.store.repository;

import br.com.stoom.store.model.Product;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
	List<Product> findAllByActiveTrue();
	
	List<Product> findAllByBrandIdAndActiveTrue(Long brandId);

	List<Product> findAllByCategoryIdAndActiveTrue(Long categoryId);
}