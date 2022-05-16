package ateam.techreturners.healthyfood;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HealthyfoodApplication {

	@Bean
	public GroupedOpenApi swaggerConfiguration() {
		return GroupedOpenApi.builder()
				.group("healthyfood-api")
				.pathsToMatch("/api/v1/**")
				.build();
	}

	@Bean
	public OpenAPI healthyFoodInfoApi() {
		return new OpenAPI()
			.info(new Info().title("\uD83E\uDD57 Healthy Food API")
			.description("Do you need to make your diet healthier? Then this is the API for you! \uD83D\uDE0A")
			.version("v1")
			.license(new License().name("GNU General Public License v3.0").url("https://github.com/abcpaem/healthy-food-api/blob/main/LICENSE")));
	}

	public static void main(String[] args) {
		SpringApplication.run(HealthyfoodApplication.class, args);
	}

}
