package com.aulaspring.course.services;

import com.aulaspring.course.entities.Category;
import com.aulaspring.course.entities.Order;
import com.aulaspring.course.repositories.CategoryRepository;
import com.aulaspring.course.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component // registra a classe como um componente do spring
public class CategoryService {

    @Autowired // injeta dependencia automaticamente
    private CategoryRepository repository;

    public List<Category> findAll(){
        return repository.findAll();
    }

    public Category findById(Long id){
        Optional<Category> obj = repository.findById(id);
        return obj.get(); // retorna o objeto com id x
    }

}
