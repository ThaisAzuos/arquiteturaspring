package com.arquiteturaspring.arquiteturaspring;

import com.arquiteturaspring.arquiteturaspring.todos.TodoEntity;
import com.arquiteturaspring.arquiteturaspring.todos.TodoValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BeanGerenciado {

    //três formas de injetar dependência:

    //1.@Autowired --> Injeção via propriedade
    @Autowired
    private TodoValidator validator;

    public void utilizar(){
        var todo = new TodoEntity();
        validator.validar(todo);
    }

    //2.Método Setter:

    @Autowired
    public void  setValidator(TodoValidator validator){
        this.validator = validator;
    }

    //3. Via método construtor:
    //posso ou não utilizar o @Autowired
    @Autowired
    public BeanGerenciado(TodoValidator validator) {
        this.validator = validator;
    }
}
