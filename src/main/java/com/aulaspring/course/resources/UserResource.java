package com.aulaspring.course.resources;

import com.aulaspring.course.entities.User;
import com.aulaspring.course.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController /// Indica que a classe é um controlador REST, capaz de lidar com requisições HTTP e retornar dados em formato JSON ou XML.
@RequestMapping(value = "/users") // apelido para o recurso, e mpeia as requisições HTTP para o caminho /users para os métodos dessa classe.
public class UserResource { // Declaração da classe UserResource, que será o controlador para os recursos do tipo User.

    @Autowired
    private UserService service;

    // recupera dados
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

    // Inserir novo recurso usando o método HTTP POST
    @PostMapping
    public ResponseEntity<User> insert(@RequestBody User obj) { // Chama o serviço para inserir o objeto User e atualiza a referência do objeto
        obj = service.insert(obj); // pega o metodo do userService

        // Cria uma URI para o novo recurso criado
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest() // Obtém a URI atual da requisição
                .path("/{id}") // Adiciona um caminho à URI, com um espaço reservado {id}
                .buildAndExpand(obj.getId()) // Substitui o espaço reservado {id} com o ID do objeto inserido
                .toUri(); // Converte para um objeto URI

        return ResponseEntity.created(uri).body(obj); // Retorna uma resposta HTTP 200 OK com o corpo contendo o objeto User inserido
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){ // void pq nao retorna nada
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User obj){
        obj = service.update(id,obj);
        return ResponseEntity.ok().body(obj);
    }


}
