package com.example.springmysqljpashiroproject;
//
//import org.apache.shiro.realm.Realm;
//import org.apache.shiro.realm.text.PropertiesRealm;
//import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
//import org.apache.shiro.spring.web.config.ShiroFilterChainDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringMySqljpaShiroProjectApplication {
//    @Bean
//    public Realm realm(){
//        //uses"classpath:shiro-users.properties" by default
//        PropertiesRealm realm = new PropertiesRealm();
//        return realm;
//    }
//
//    @Bean
//    public ShiroFilterChainDefinition shiroFilterChainDefinition(){
//        DefaultShiroFilterChainDefinition defaultShiroFilterChainDefinition = new DefaultShiroFilterChainDefinition();
//        defaultShiroFilterChainDefinition.addPathDefinition("**","authcBasic");
//        return defaultShiroFilterChainDefinition;
//    }

    public static void main(String[] args) {
        SpringApplication.run(SpringMySqljpaShiroProjectApplication.class, args);
    }

}
