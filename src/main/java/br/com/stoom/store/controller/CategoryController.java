package br.com.stoom.store.controller;

import br.com.stoom.store.business.CategoryBO;
import br.com.stoom.store.dto.CategoryDTO;
import br.com.stoom.store.exception.NotFoundException;
import br.com.stoom.store.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.validation.Valid;

@Controller
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryBO categoryService;

    @GetMapping(value = "/")
    public ResponseEntity<List<Category>> findAll() {
        List<Category> p = categoryService.findAll();
        if(!p.isEmpty())
            return new ResponseEntity<>(p, HttpStatus.OK);
        else
        	throw new NotFoundException("Categories Not Found");
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Category> findById(@PathVariable("id") final Long categoryId){      
        return ResponseEntity.status(HttpStatus.OK).body(this.categoryService.findById(categoryId));
    }
    
    @PostMapping
    public ResponseEntity<Category> create(@RequestBody @Valid final CategoryDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.categoryService.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> update(@PathVariable("id") final Long categoryId,
                                       @RequestBody @Valid final CategoryDTO dto) {
        return ResponseEntity.status(HttpStatus.OK).body(this.categoryService.update(categoryId, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") final Long categoryId){
        this.categoryService.delete(categoryId);

        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
