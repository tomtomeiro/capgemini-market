package com.capgemini.market.web.controller;

import com.capgemini.market.domain.Product;
import com.capgemini.market.domain.service.ProductService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController//Controlador de API REST
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductService productService;
    @GetMapping("/all")
    @ApiOperation("Get all supermarket product")
    @ApiResponse(code=200, message = "OK")
    public ResponseEntity<List<Product>> getAll(){

        return new ResponseEntity<>( productService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiOperation("Search a product with and ID")
    @ApiResponses({
            @ApiResponse(code = 200, message = "ok"),
            @ApiResponse(code=404, message = "Product not found")
    })
    public Optional<Product> getProduct(@ApiParam(value="The id of the product",
            required = true, example = "7") @PathVariable("id") Integer productId){
        return productService.getProduct(productId);
    }
    @GetMapping("/category/{categoryId}")
    public Optional<List<Product>> getByCategory(@PathVariable("categoryId") Integer categoryId){
        return productService.getByCategory(categoryId);
    }
    @PostMapping("/save")
    public  Product save(@RequestBody Product product){
        return productService.save((product));
    }
    @DeleteMapping("/delete/{id}")
    public  boolean delete(@PathVariable("id") Integer productId){
        return productService.delete((productId));
    }

}
