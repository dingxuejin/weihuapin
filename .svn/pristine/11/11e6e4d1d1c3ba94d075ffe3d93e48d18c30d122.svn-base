package com.mobiusVision;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Author: zhangzhirong
 * @Description:
 * @Date:Created in 14:55 2018/6/23/023
 * @Modify By:
 **/
@Configuration
@EnableSwagger2
public class SwaggerConfig {

        @Bean
        public Docket customDocket() {
            return new Docket(DocumentationType.SWAGGER_2)
            .apiInfo(apiInfo())
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.mobiusVision.controller"))
            .paths(PathSelectors.any())
            .build();
        }

        private ApiInfo apiInfo() {
            return new ApiInfoBuilder()
            .title("危化品 RESTful APIs")
            .description("")
            .termsOfServiceUrl("http://www..com")
            .version("1.0")
            .build();
        }

}
