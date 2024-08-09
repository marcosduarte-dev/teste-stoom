package br.com.stoom.store.dto;

import javax.validation.constraints.NotBlank;

public class BrandDTO {
	
    @NotBlank(message = "is required")
    private String name;
    
	public BrandDTO() {
	}
	public BrandDTO(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
    
}
