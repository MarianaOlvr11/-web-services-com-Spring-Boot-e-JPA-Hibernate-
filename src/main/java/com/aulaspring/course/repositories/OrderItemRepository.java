package com.aulaspring.course.repositories;

import com.aulaspring.course.entities.OrderItem;
import com.aulaspring.course.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem,Long> { // herda do JPARepository


}
