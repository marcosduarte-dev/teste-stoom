package br.com.stoom.store.business.interfaces;

import br.com.stoom.store.dto.CategoryDTO;
import br.com.stoom.store.model.Category;

import java.util.List;

public interface ICategoryBO {

    List<Category> findAll();
    
    Category findById(Long id);
    
    Category create(CategoryDTO dto);
    
    Category update(Long id, CategoryDTO dto);
    
    Category delete(Long id);

}
