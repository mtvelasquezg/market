package com.platzi.market.web.contoller;

import com.platzi.market.domain.Product;
import com.platzi.market.domain.service.ProductService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/all")
    @ApiOperation("Get all supermarket products")
    @ApiResponse(code = 200, message = "OK")
    public List<Product> getAll() {
        return productService.getAll();
    }

    @GetMapping("/{id}")
    @ApiOperation("Search a product with an ID")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Product not found")
    })
    public Optional<Product> getProduct (@ApiParam(value = "The id of the product", required = true, example = "7") @PathVariable("id") int productId){
        return productService.getProduct(productId);
    }

    @GetMapping("/category/{id}")
    public Optional<List<Product>> getByCategory(@PathVariable("id") int categoryId){
        return productService.getByCategory(categoryId);
    }

    @PostMapping("/save")
    public Product save(@RequestBody Product product){
        return productService.save(product);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete (@PathVariable("id") int productId){
        return productService.delete(productId);
    }
}
