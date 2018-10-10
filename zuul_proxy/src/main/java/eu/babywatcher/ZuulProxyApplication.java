package eu.babywatcher;

import java.security.Principal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import eu.babywatcher.filters.AuthHeaderFilter;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableAutoConfiguration
@Configuration
@EnableDiscoveryClient
@EnableZuulProxy
@EnableSwagger2
@EnableOAuth2Sso
@RestController
//@SpringBootApplication//(exclude = {SecurityAutoConfiguration.class })
public class ZuulProxyApplication {

	@RequestMapping("/")
	  public String home(Principal user) {
	    return "Hello " + user.getName();
	  }

	public static void main(String[] args) {
		//SpringApplication.run(ZuulProxyApplication.class, args);
		new SpringApplicationBuilder(ZuulProxyApplication.class)
        .properties("spring.config.name=client").run(args);

	}
	
	@Bean
    AuthHeaderFilter authHeaderFilter() {

        return new AuthHeaderFilter();

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
