package br.com.stoom.store.mapper;

import br.com.stoom.store.dto.ProductDTO;
import br.com.stoom.store.model.Brand;
import br.com.stoom.store.model.Category;
import br.com.stoom.store.model.Product;

public class ProductMapper {
	public static Product fromDtoToEntity(ProductDTO dto, Category category, Brand brand, Long id) {
        return new Product(
        		id,
        		dto.getSku(),
        		dto.getName(),
        		dto.getPrice(),
        		category,
        		brand
        		);
    }
}
