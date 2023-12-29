package com.di.step6;

import com.di.step3.DaoOracle;
import com.di.step3.IDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.di.step6"})
public class JavaConfig {

//    @Bean
//    public IDao id(){
//        return new DaoOracle();
//    }
//

}
