/*
 * package com.candidjava.spring.controller;
 * 
 * import org.springframework.http.HttpStatus;
 * 
 * import org.springframework.http.ResponseEntity; import
 * org.springframework.web.bind.annotation.PostMapping; import
 * org.springframework.web.bind.annotation.RequestBody; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.annotation.RestController;
 * 
 * import com.candidjava.spring.bean.Product; import
 * com.candidjava.spring.repository.ProductRepo;
 * 
 * @RestController
 * 
 * @RequestMapping("/product") public class ProductController {
 * 
 * private ProductRepo productRepo;
 * 
 * @PostMapping("/save") public ResponseEntity<Product> create(@RequestBody
 * Product product) { Product save = productRepo.save(product); if (null !=
 * save) { return new ResponseEntity<Product>(product, HttpStatus.OK); } else {
 * return new ResponseEntity<Product>(product, HttpStatus.BAD_REQUEST); }
 * 
 * }
 * 
 * }
 */
