package br.com.stoom.store.business.interfaces;

import br.com.stoom.store.dto.ProductDTO;
import br.com.stoom.store.model.Product;

import java.util.List;

public interface IProductBO {

    List<Product> findAll();
    
    Product findById(Long id);
    
    Product create(ProductDTO dto);
    
    Product update(Long id, ProductDTO dto);
    
    Product delete(Long id);
    
    List<Product> findAllByBrandIdAndActiveTrue(Long brandId);

    List<Product> findAllByCategoryIdAndActiveTrue(Long categoryId);
}
