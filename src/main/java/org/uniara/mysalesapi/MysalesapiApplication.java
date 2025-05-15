package org.uniara.mysalesapi;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "MySales API", version = "0", description = "API to provide and manage data from Flutter app MySales"))
public class MysalesapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MysalesapiApplication.class, args);
	}

}
