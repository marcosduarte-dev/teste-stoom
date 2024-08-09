package br.com.stoom.store.business;

import br.com.stoom.store.business.interfaces.IBrandBO;
import br.com.stoom.store.dto.BrandDTO;
import br.com.stoom.store.exception.NotFoundException;
import br.com.stoom.store.mapper.BrandMapper;
import br.com.stoom.store.model.Brand;
import br.com.stoom.store.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BrandBO implements IBrandBO {

    @Autowired
    private BrandRepository brandRepository;

    @Override
    public List<Brand> findAll(){
        return brandRepository.findAll();
    }
    
    @Override
    public Brand findById(Long id) {
        return getBrand(id);
    }

    @Override
    public Brand create(BrandDTO dto) {	
        return brandRepository.save(BrandMapper.fromDtoToEntity(dto, null));
    }

    @Override
    public Brand update(Long id, BrandDTO dto) {
    	getBrand(id);

        return brandRepository.save(BrandMapper.fromDtoToEntity(dto, id));
    }

    @Override
    public Brand delete(Long id) {
    	Brand brand = getBrand(id);
    	brand.setActive(!brand.isActive());

    	return brandRepository.save(brand);
    }
    
    private Brand getBrand(Long id) {
        Optional<Brand> optional = brandRepository.findById(id);
        if(optional.isEmpty()) {
            throw new NotFoundException("Brand not found");
        }
        return optional.get();
    }

}
