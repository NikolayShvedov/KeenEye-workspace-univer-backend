package dev.vorstu;
import dev.vorstu.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavaApplication {

	private static Initializer initiator;
	
	@Autowired
	public void setInitialLoader(Initializer initiator) {
		JavaApplication.initiator = initiator;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(JavaApplication.class, args);
		
		initiator.initial();
	}
}
