package br.com.stoom.store.business;

import br.com.stoom.store.business.interfaces.ICategoryBO;
import br.com.stoom.store.dto.CategoryDTO;
import br.com.stoom.store.exception.NotFoundException;
import br.com.stoom.store.mapper.CategoryMapper;
import br.com.stoom.store.model.Category;
import br.com.stoom.store.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryBO implements ICategoryBO {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> findAll(){
        return categoryRepository.findAll();
    }
    
    @Override
    public Category findById(Long id) {
        return getCategory(id);
    }

    @Override
    public Category create(CategoryDTO dto) {	
        return categoryRepository.save(CategoryMapper.fromDtoToEntity(dto, null));
    }

    @Override
    public Category update(Long id, CategoryDTO dto) {
    	getCategory(id);

        return categoryRepository.save(CategoryMapper.fromDtoToEntity(dto, id));
    }

    @Override
    public Category delete(Long id) {
    	Category category = getCategory(id);
    	category.setActive(!category.isActive());

    	return categoryRepository.save(category);
    }
    
    private Category getCategory(Long id) {
        Optional<Category> optional = categoryRepository.findById(id);
        if(optional.isEmpty()) {
            throw new NotFoundException("Category not found");
        }
        return optional.get();
    }

}
