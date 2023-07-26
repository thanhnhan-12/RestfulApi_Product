/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Product;
import com.example.service.ProductService;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api")
public class ProductController {
    
    @Autowired
    ProductService prodService;
    
    // CREATE
    @RequestMapping(value="/products", method=RequestMethod.POST)
    public Product addProduct(@RequestBody Product prod) {
        return prodService.addProduct(prod);
    }
    
    // GET
    @RequestMapping(value="/products", method=RequestMethod.GET)
    public List<Product> getProductAll() {
        return prodService.getProductAll();
    }

    // GET BY ID
    @RequestMapping(value="/products/{prodId}", method=RequestMethod.GET)
    public Product getProductById(@PathVariable(value = "prodId") Long id, @RequestBody Product prodDetails) {
        return prodService.getProductById(id, prodDetails);
    }
    
    // UPDATE
    @RequestMapping(value="/products/{prodId}", method=RequestMethod.PUT)
    public Product updateProduct(@PathVariable(value = "prodId") Long id, @RequestBody Product prodDetails) {
        return prodService.updateProduct(id, prodDetails);
    }

    // DELETE
    @RequestMapping(value="/products/{prodId}", method=RequestMethod.DELETE)
    public void deleteProducts(@PathVariable(value = "prodId") Long id) {
        prodService.deleteProduct(id);
    }
    
    // SEARCH
    @RequestMapping(value="/products/search", method=RequestMethod.GET)
    public List<Product> searchProduct(@RequestParam(value = "keyword") String keyword) {
        return prodService.searchProduct(keyword);
    }
    
}
