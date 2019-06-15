package com.tw.example.demo4;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2Config {

	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.tw.example.demo4"))
				.paths(PathSelectors.any())
				.build();
	}

	@SuppressWarnings("deprecation")
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("Hermes 部分接口文档（baseUrl: http://120.55.62.79:8081）")
				.description("该文档包含了Dionysus中需要使用到的接口有："
						+ "1:注册用户\n 2:用户登陆\n 3:用户查询\n"
						+ "baseUrl+/Hermes/user/login，拼接出来就是 http://120.55.62.79:8081/Hermes/user/login")
				.termsOfServiceUrl("http://120.55.62.79:8081")
				.contact("brank")
				.version("1.0")
				.build();
	}
}

