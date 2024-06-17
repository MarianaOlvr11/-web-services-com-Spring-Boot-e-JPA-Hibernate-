package com.aulaspring.course.resources;

import com.aulaspring.course.entities.User;
import com.aulaspring.course.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController /// Indica que a classe é um controlador REST, capaz de lidar com requisições HTTP e retornar dados em formato JSON ou XML.
@RequestMapping(value = "/users") // apelido para o recurso, e mpeia as requisições HTTP para o caminho /users para os métodos dessa classe.
public class UserResource { // Declaração da classe UserResource, que será o controlador para os recursos do tipo User.

    @Autowired
    private UserService service;

    @GetMapping // Indica que este método irá responder a requisições HTTP GET.
    public ResponseEntity<List<User>> findAll() {// tipo especifico de retorno de respostas de requisiçoes web, define um método público que retorna uma ResponseEntity contendo uma lista que contem uma lista User
        List<User> list = service.findAll();

    return ResponseEntity.ok().body(list); // Retorna uma resposta HTTP 200 (OK) contendo o objeto User no corpo da resposta.
    }

    @GetMapping(value = "/{id}") // requisição get com parametro da url Id
    public ResponseEntity<User> findById(@PathVariable Long id){ // retorna um usuario, para receber o parametro precisa da anotação
        User obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
