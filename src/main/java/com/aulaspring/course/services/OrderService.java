package com.aulaspring.course.services;

import com.aulaspring.course.entities.Order;
import com.aulaspring.course.entities.User;
import com.aulaspring.course.repositories.OrderRepository;
import com.aulaspring.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component // registra a classe como um componente do spring
public class OrderService {

    @Autowired // injeta dependencia automaticamente
    private OrderRepository repository;

    public List<Order> findAll(){
        return repository.findAll();
    }

    public Order findById(Long id){
        Optional<Order> obj = repository.findById(id);
        return obj.get(); // retorna o objeto com id x
    }

}
