package com.aulaspring.course.repositories;

import com.aulaspring.course.entities.Order;
import com.aulaspring.course.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> { // herda do JPARepository


}
