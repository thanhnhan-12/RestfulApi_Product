/*
 * Click nbfs://nbhost/SystemFileSystem/Tprodlates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Tprodlates/Classes/Class.java to edit this tprodlate
 */
package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Product;
import com.example.repository.ProductRepository;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository prodRepository;

    // ADD
    public Product addProduct(Product prod) {
        return prodRepository.save(prod);
    }

    // GET
    public List<Product> getProductAll() {
        return prodRepository.findAll();
    }

    // GET BY ID
    public Product getProductById(Long prodId, Product productDetails) {
        return prodRepository.findById(prodId).get();
    }

    // UPDATE
    public Product updateProduct(Long prodId, Product productDetails) {
        Product prod = prodRepository.findById(prodId).get();
        prod.setName(productDetails.getName());
        prod.setQuantity(productDetails.getQuantity());
        prod.setUnitprice(productDetails.getUnitprice());
        prod.setManufacturer(productDetails.getManufacturer());
        prod.setDescription(productDetails.getDescription());
        
        return prodRepository.save(prod);
    }
    
    // DELETE
    public void deleteProduct(Long prodId) {
        prodRepository.deleteById(prodId);
    }
    
    // SEARCH
    public List<Product> searchProduct(String keyword) {
        // Gọi phương thức tìm kiếm sản phẩm từ repository
        return prodRepository.findByNameContainingIgnoreCase(keyword);
    }

}
