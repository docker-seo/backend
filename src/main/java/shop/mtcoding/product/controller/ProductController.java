package shop.mtcoding.product.controller;

import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Producer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import shop.mtcoding.product.model.Product;
import shop.mtcoding.product.model.ProductRepository;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class ProductController {

    private final ProductRepository productRepository;

    @GetMapping("/products")
    @Operation(summary = "모든 상품 조회", description = "등록된 모든 상품을 조회합니다.")
    public ResponseEntity<?> products() {
        List<Product> products = productRepository.findAll();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
}
