package com.aulaspring.course.services;

import com.aulaspring.course.entities.User;
import com.aulaspring.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component // registra a classe como um componente do spring
public class UserService {

    @Autowired // injeta dependencia automaticamente
    private UserRepository repository;

    public List<User> findAll(){
        return repository.findAll();
    }

    public User findById(Long id){
        Optional<User> obj = repository.findById(id);
        return obj.get(); // retorna o objeto com id x
    }

    public User insert(User obj){
        return  repository.save(obj);
    }

}
