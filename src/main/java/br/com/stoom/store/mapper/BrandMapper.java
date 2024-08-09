package br.com.stoom.store.mapper;

import br.com.stoom.store.dto.BrandDTO;
import br.com.stoom.store.model.Brand;

public class BrandMapper {
	public static Brand fromDtoToEntity(BrandDTO dto, Long id) {
        return new Brand(
        		id,
        		dto.getName());
    }
}
