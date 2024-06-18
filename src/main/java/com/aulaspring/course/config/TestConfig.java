package com.aulaspring.course.config;

// Importações das classes e interfaces necessárias
import com.aulaspring.course.entities.*;
import com.aulaspring.course.entities.enums.OrderStatus;
import com.aulaspring.course.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;


@Configuration// Configuração de classe anotada com @Configuration para ser identificada pelo Spring como uma fonte de definições de beans
@Profile("test")// Especifica que esta configuração será ativada apenas no perfil "test"

public class TestConfig implements CommandLineRunner { // Implementa CommandLineRunner para executar o método run ao iniciar a aplicação

    // Injeção de dependências para os repositórios
    @Autowired
    private UserRepository userRepository; // Repositório de usuários

    @Autowired
    private OrderRepository orderRepository; // Repositório de pedidos

    @Autowired
    private CategoryRepository categoryRepository; // Repositório de categorias

    @Autowired
    private ProductRepository productRepository; // Repositório de produtos

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Override
    public void run(String... args) throws Exception {
        // Método executado ao iniciar a aplicação para popular o banco de dados com dados de teste

        // Criação de objetos User (usuários)
        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
        // Salva a lista de usuários no banco de dados
        userRepository.saveAll(Arrays.asList(u1, u2));

        // Criação de objetos Order (pedidos)
        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), u1, OrderStatus.PAID);
        Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), u2, OrderStatus.WAITING_PAYMENT);
        Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), u1, OrderStatus.WAITING_PAYMENT);
        // Salva a lista de pedidos no banco de dados
        orderRepository.saveAll(Arrays.asList(o1, o2, o3));

        // Criação de objetos Category (categorias)
        Category cat1 = new Category(null, "Electronics");
        Category cat2 = new Category(null, "Books");
        Category cat3 = new Category(null, "Computers");
        // Salva a lista de categorias no banco de dados
        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));

        // Criação de objetos Product (produtos)
        Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
        Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
        Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
        Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
        Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");
        // Salva a lista de produtos no banco de dados
        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

        p1.getCategories().add(cat2); //associa o produto a categoria
        p2.getCategories().add(cat1);
        p2.getCategories().add(cat3);
        p3.getCategories().add(cat3);
        p4.getCategories().add(cat3);
        p5.getCategories().add(cat2);

        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5)); // salva novamente os produtos com as associações

        OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
        OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
        OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice());
        OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice());

        orderItemRepository.saveAll(Arrays.asList(oi1,oi2,oi3,oi4));


    }
}
