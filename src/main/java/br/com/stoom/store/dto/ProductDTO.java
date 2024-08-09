package br.com.stoom.store.dto;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductDTO {
	
	@NotBlank(message = "is required")
    private String sku;
    @NotBlank(message = "is required")
    private String name;
    @NotNull(message = "is required")
    private BigDecimal price;
    @JsonProperty("category_id")
    @NotNull(message = "is required")
    private Long categoryId;
    @JsonProperty("brand_id")
    @NotNull(message = "is required")
    private Long brandId;
    
    
    
	public ProductDTO() {
	}
	public ProductDTO(String sku, String name,
			 BigDecimal price, Long categoryId,
			 Long brandId) {
		this.sku = sku;
		this.name = name;
		this.price = price;
		this.categoryId = categoryId;
		this.brandId = brandId;
	}
	
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public Long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	public Long getBrandId() {
		return brandId;
	}
	public void setBrandId(Long brandId) {
		this.brandId = brandId;
	}
    
    
    
}
