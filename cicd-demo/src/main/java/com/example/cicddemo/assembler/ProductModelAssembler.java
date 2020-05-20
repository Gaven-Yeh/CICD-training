package com.example.cicddemo.assembler;

import com.example.cicddemo.controller.ProductController;
import com.example.cicddemo.entity.Product;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class ProductModelAssembler implements RepresentationModelAssembler<Product, EntityModel<Product>> {

    @Override
    public EntityModel<Product> toModel(Product product) {
        return new EntityModel<>(product,
                linkTo(methodOn(ProductController.class).one(product.getProduct_id())).withSelfRel(),
                linkTo(methodOn(ProductController.class).all()).withRel("products"));
    }
}
