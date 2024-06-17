package com.aulaspring.course.resources;

import com.aulaspring.course.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController /// Indica que a classe é um controlador REST, capaz de lidar com requisições HTTP e retornar dados em formato JSON ou XML.
@RequestMapping(value = "/users") // apelido para o recurso, e mpeia as requisições HTTP para o caminho /users para os métodos dessa classe.
public class UserResource { // Declaração da classe UserResource, que será o controlador para os recursos do tipo User.

    @GetMapping // Indica que este método irá responder a requisições HTTP GET.
    public ResponseEntity<User> findAll() {// tipo especifico de retorno de respostas de requisiçoes web, define um método público que retorna uma ResponseEntity contendo um objeto User.
    User u = new User(1L, "Maria", "maria@gmail.com","119445544","abc1234");// Retorna uma resposta HTTP 200 (OK) contendo o objeto User no corpo da resposta.
    return ResponseEntity.ok().body(u);
    }
}
