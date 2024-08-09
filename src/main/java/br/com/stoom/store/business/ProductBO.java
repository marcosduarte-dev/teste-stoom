package br.com.stoom.store.business;

import br.com.stoom.store.business.interfaces.IProductBO;
import br.com.stoom.store.dto.ProductDTO;
import br.com.stoom.store.exception.NotFoundException;
import br.com.stoom.store.mapper.ProductMapper;
import br.com.stoom.store.model.Brand;
import br.com.stoom.store.model.Category;
import br.com.stoom.store.model.Product;
import br.com.stoom.store.repository.BrandRepository;
import br.com.stoom.store.repository.CategoryRepository;
import br.com.stoom.store.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductBO implements IProductBO {

    @Autowired
    private ProductRepository productRepository;
    
    @Autowired
    private CategoryRepository categoryRepository;
    
    @Autowired
    private BrandRepository brandRepository;

    @Override
    public List<Product> findAll(){
        return productRepository.findAllByActiveTrue();
    }
    
    @Override
    public Product findById(Long id) {
        return getProducts(id);
    }

    @Override
    public Product create(ProductDTO dto) {
        return productRepository.save(ProductMapper.fromDtoToEntity(
        		dto,
        		getCategory(dto.getCategoryId()),
        		getBrand(dto.getBrandId()),
        		null
        		));
    }

    @Override
    public Product update(Long id, ProductDTO dto) {
    	getProducts(id);

        return productRepository.save(ProductMapper.fromDtoToEntity(dto, 
        		getCategory(dto.getCategoryId()),
        		getBrand(dto.getBrandId()),
        		id
        		));
    }

    @Override
    public Product delete(Long id) {
    	Product product = getProducts(id);
    	product.setActive(!product.isActive());

    	return productRepository.save(product);
    }
    
    @Override
    public List<Product> findAllByBrandIdAndActiveTrue(Long brandId) {
    	getBrand(brandId);
    	
    	return productRepository.findAllByBrandIdAndActiveTrue(brandId);
    }
    
    @Override
    public List<Product> findAllByCategoryIdAndActiveTrue(Long categoryId) {
    	getCategory(categoryId);
    	
    	return productRepository.findAllByCategoryIdAndActiveTrue(categoryId);
    }
    
    private Product getProducts(Long id) {
        Optional<Product> optional = productRepository.findById(id);
        if(optional.isEmpty()) {
            throw new NotFoundException("Product not found");
        }
        return optional.get();
    }
    
    private Category getCategory(Long id) {
        Optional<Category> optional = categoryRepository.findById(id);
        if(optional.isEmpty()) {
            throw new NotFoundException("Category not found");
        }
        return optional.get();
    }
    
    private Brand getBrand(Long id) {
        Optional<Brand> optional = brandRepository.findById(id);
        if(optional.isEmpty()) {
            throw new NotFoundException("Brand not found");
        }
        return optional.get();
    }

}
