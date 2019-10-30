package com.torrento.app;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.torrento.app.bean.Rattings;
import com.torrento.app.service.RattingService;

@SpringBootApplication
public class TorrentoReadJsonApp implements CommandLineRunner {
	
	public static void main(String[] args) {
        SpringApplication.run(TorrentoReadJsonApp.class, args);
    }

	@Bean
	CommandLineRunner runner(RattingService service) {
		return args -> {
			// Read json file from Resource Folder
			ObjectMapper mapper = new ObjectMapper();
			TypeReference<List<Rattings>> typeReference = new TypeReference<List<Rattings>>(){};
			InputStream inputStream = TypeReference.class.getResourceAsStream("/json/ReadThisJson.json");
			try {
				List<Rattings> rattings = mapper.readValue(inputStream,typeReference);
				service.saveRattings(rattings);
			} catch (IOException e){
				System.out.println("Unable to save userRattings: " + e.getMessage());
			}
		};
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
