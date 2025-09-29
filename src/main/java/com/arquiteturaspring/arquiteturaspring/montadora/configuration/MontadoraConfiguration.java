package com.arquiteturaspring.arquiteturaspring.montadora.configuration;

import com.arquiteturaspring.arquiteturaspring.montadora.Motor;
import com.arquiteturaspring.arquiteturaspring.montadora.TipoMotor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

@Configuration
public class MontadoraConfiguration {


    @Primary
    @Bean(name = "motorAspirado")
    @Scope("singleton")
    public Motor motorAspirado(@Value("${app.montadora.motor-padrao}") Integer cavalos){
        var motor = new Motor();
        motor.setCavalos(cavalos);
        motor.setCilindros(4);
        motor.setModelo("XPTO");
        motor.setLitragem(2.0);
        motor.setTipo(TipoMotor.ASPIRADO);
        return motor;
    }

    @Bean(name = "motorEletrico")
    public Motor motorEletrico(){
        var motor = new Motor();
        motor.setCavalos(110);
        motor.setCilindros(3);
        motor.setModelo("TH-10");
        motor.setLitragem(1.4);
        motor.setTipo(TipoMotor.ELETRICO);
        return motor;
    }


    @Bean(name = "motorTurbo")
    public Motor motorTurbo(){
        var motor = new Motor();
        motor.setCavalos(180);
        motor.setCilindros(4);
        motor.setModelo("XPTO-01");
        motor.setLitragem(1.5);
        motor.setTipo(TipoMotor.TURBO);
        return motor;
    }


}
