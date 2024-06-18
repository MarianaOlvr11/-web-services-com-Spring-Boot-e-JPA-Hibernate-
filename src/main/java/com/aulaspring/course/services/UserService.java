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

    public void delete(Long id){
        repository.deleteById(id);
    }

    public User update(Long id, User obj){
        User entity = repository.getReferenceById(id); // instancia o usuario sem ir no banco de dados, só monitora pelo JPA
        updateData(entity,obj);

        return repository.save(entity);
    }

    private void updateData(User entity, User obj) { // só vai poder mudar nome, email e telefone
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());
    }


}
