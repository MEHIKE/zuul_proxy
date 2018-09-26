package eu.babywatcher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableDiscoveryClient
@EnableZuulProxy
@EnableSwagger2
@SpringBootApplication
public class ZuulProxyApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulProxyApplication.class, args);
	}
	
	/*@Bean
	public Docket swaggerApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("eu.babywatcher"))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(new ApiInfoBuilder().version("1.0")
						.title("Babywatcher API")
						.description("Documentation Babywatcher API v1.0").build());
	}*/
}
