package com.aulaspring.course.repositories;

import com.aulaspring.course.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> { // herda do JPARepository


}
