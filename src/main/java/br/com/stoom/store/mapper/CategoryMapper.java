package br.com.stoom.store.mapper;

import br.com.stoom.store.dto.CategoryDTO;
import br.com.stoom.store.model.Category;

public class CategoryMapper {
	public static Category fromDtoToEntity(CategoryDTO dto, Long id) {
        return new Category(
        		id,
        		dto.getName());
    }
}
