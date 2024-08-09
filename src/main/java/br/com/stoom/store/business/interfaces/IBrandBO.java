package br.com.stoom.store.business.interfaces;

import br.com.stoom.store.dto.BrandDTO;
import br.com.stoom.store.model.Brand;

import java.util.List;

public interface IBrandBO {

    List<Brand> findAll();
    
    Brand findById(Long id);
    
    Brand create(BrandDTO dto);
    
    Brand update(Long id, BrandDTO dto);
    
    Brand delete(Long id);

}
