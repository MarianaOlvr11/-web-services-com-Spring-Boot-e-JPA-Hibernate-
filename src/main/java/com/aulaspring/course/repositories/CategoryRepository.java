package com.aulaspring.course.repositories;

import com.aulaspring.course.entities.Category;
import com.aulaspring.course.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> { // herda do JPARepository


}
