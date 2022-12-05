package br.com.futurodev.primeiraapi.springfox;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;


import javax.tools.DocumentationTool;

@Configuration
@EnableSwagger2
public class SpringFoxConfig  extends WebMvcConfigurationSupport {

    @Bean
    public Docket apiDocket(){
        return new Docket(DocumentationType.SWAGGER_2) // Informa qual tipo de documentação que vamos usar
                .select() // retormamos um builder para selecionar os endpoints que deve ser expostos
                .apis(RequestHandlerSelectors.any()) // especificar oque queremos, e quais controladores, endpoints que o springfox irá scanear
                .build() // montamos nosso sumário Docket
                .apiInfo(metaData());
    }


    private ApiInfo metaData(){
        return new ApiInfoBuilder()
                .title("Spring Boot REST API")
                .description("Nossa primeira Spring Boot REST API")
                .version("1.0.0")
                .license("Apache Licence Version 2.0")
                .licenseUrl("https://www.apache.org/licences/LICENSE-2.0")
                .build();
    }

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html") // informamos o arquivo a ser renderezado no navegador
                .addResourceLocations("classpath:/META-INF/resources/"); // informamos o caminho do arquivo

        registry.addResourceHandler("/webjars/**") //informa outros arquivos de css, js, png dentre outros
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
}
