package br.com.stoom.store.controller;

import br.com.stoom.store.business.ProductBO;
import br.com.stoom.store.dto.ProductDTO;
import br.com.stoom.store.exception.NotFoundException;
import br.com.stoom.store.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.validation.Valid;

@Controller
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductBO productService;

    @GetMapping(value = "/")
    public ResponseEntity<List<Product>> findAll() {
        List<Product> p = productService.findAll();
        if(!p.isEmpty())
            return new ResponseEntity<>(p, HttpStatus.OK);
        else
        	throw new NotFoundException("Products Not Found");
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable("id") final Long productId){      
        return ResponseEntity.status(HttpStatus.OK).body(this.productService.findById(productId));
    }
    
    @GetMapping("/category/{id}")
    public ResponseEntity<List<Product>> findByCategoryId(@PathVariable("id") final Long categoryId){      
        return ResponseEntity.status(HttpStatus.OK).body(this.productService.findAllByCategoryIdAndActiveTrue(categoryId));
    }
    
    @GetMapping("/brand/{id}")
    public ResponseEntity<List<Product>> findByBrandId(@PathVariable("id") final Long brandId){      
        return ResponseEntity.status(HttpStatus.OK).body(this.productService.findAllByBrandIdAndActiveTrue(brandId));
    }
    
    @PostMapping
    public ResponseEntity<Product> create(@RequestBody @Valid final ProductDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.productService.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@PathVariable("id") final Long productId,
                                       @RequestBody @Valid final ProductDTO dto) {
        return ResponseEntity.status(HttpStatus.OK).body(this.productService.update(productId, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") final Long productId){
        this.productService.delete(productId);

        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
