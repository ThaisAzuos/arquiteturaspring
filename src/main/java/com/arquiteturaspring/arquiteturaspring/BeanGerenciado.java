package com.arquiteturaspring.arquiteturaspring;

import com.arquiteturaspring.arquiteturaspring.todos.TodoEntity;
import com.arquiteturaspring.arquiteturaspring.todos.TodoValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Lazy(false)
@Component
@Scope(BeanDefinition.SCOPE_SINGLETON)
//@Scope(WebApplicationContext.SCOPE_APPLICATION)
//@Scope(WebApplicationContext.SCOPE_REQUEST)
//@Scope(WebApplicationContext.SCOPE_SESSION)
//@Scope("singleton")
//@Scope("request")
//@Scope("session")
//@Scope("application")
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
