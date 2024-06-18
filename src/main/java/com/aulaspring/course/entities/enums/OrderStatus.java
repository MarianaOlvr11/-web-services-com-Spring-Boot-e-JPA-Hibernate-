package com.aulaspring.course.entities.enums;


public enum OrderStatus {// Definição do enum OrderStatus

    // Constantes do enum, cada uma associada a um código inteiro
    WAITING_PAYMENT(1),
    PAID(2),
    SHIPPED(3),
    DELIVERED(4),
    CANCELED(5);


    private int code;// Atributo para armazenar o código do status


    private OrderStatus(int code){// Construtor privado que associa um código a cada constante do enum
        this.code = code;
    }

    public int getCode() { // Método getter para obter o código do status
        return code;
    }


    public static OrderStatus valueOf(int code){// Método estático para converter um código inteiro em um valor do enum OrderStatus

        for (OrderStatus value : OrderStatus.values()){// Percorre todos os valores do enum

            if(value.getCode() == code){// Se o código do valor atual for igual ao código fornecido, retorna o valor correspondente
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid OrderStatus code");// Se nenhum valor corresponder ao código fornecido, lança uma exceção
    }
}
