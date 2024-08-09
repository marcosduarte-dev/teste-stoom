package br.com.stoom.store.controller;

import br.com.stoom.store.business.BrandBO;
import br.com.stoom.store.dto.BrandDTO;
import br.com.stoom.store.exception.NotFoundException;
import br.com.stoom.store.model.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.validation.Valid;

@Controller
@RequestMapping("/api/brands")
public class BrandController {

    @Autowired
    private BrandBO brandService;

    @GetMapping(value = "/")
    public ResponseEntity<List<Brand>> findAll() {
        List<Brand> p = brandService.findAll();
        if(!p.isEmpty())
            return new ResponseEntity<>(p, HttpStatus.OK);
        else
        	throw new NotFoundException("Categories Not Found");
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Brand> findById(@PathVariable("id") final Long brandId){      
        return ResponseEntity.status(HttpStatus.OK).body(this.brandService.findById(brandId));
    }
    
    @PostMapping
    public ResponseEntity<Brand> create(@RequestBody @Valid final BrandDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.brandService.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Brand> update(@PathVariable("id") final Long brandId,
                                       @RequestBody @Valid final BrandDTO dto) {
        return ResponseEntity.status(HttpStatus.OK).body(this.brandService.update(brandId, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") final Long brandId){
        this.brandService.delete(brandId);

        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
