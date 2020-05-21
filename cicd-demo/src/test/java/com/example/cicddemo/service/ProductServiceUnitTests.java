package com.example.cicddemo.service;

import com.example.cicddemo.assembler.ProductModelAssembler;
import com.example.cicddemo.controller.ProductController;
import com.example.cicddemo.entity.Product;
import com.example.cicddemo.repository.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.hateoas.EntityModel;

import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


public class ProductServiceUnitTests {

    @InjectMocks
    private ProductService productService;

    @Mock
    private ProductRepository productRepository;
    @Mock
    private ProductModelAssembler productModelAssembler;

    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void givenProductServiceWhenQueriedWithAnIdThenGetExpectedProduct() {
        Product product = new Product((long) 5, "Classical", "Guitar", "Cordoba", 3);
        EntityModel<Product> entityModel = new EntityModel<>(product,
                linkTo(methodOn(ProductController.class).one(product.getProduct_id())).withSelfRel(),
                linkTo(methodOn(ProductController.class).all()).withRel("products"));
        Mockito.when(productRepository.findById((long) 5)).thenReturn(Optional.ofNullable(product));
        Mockito.when(productModelAssembler.toModel(product)).thenReturn(entityModel);

        EntityModel<Product> result = productService.one((long) 5);

        Assertions.assertEquals(product.getName(), result.getContent().getName());
        Assertions.assertEquals(product.getName(), "paul");
    }
}
