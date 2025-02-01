package yhr.demo.blockhound_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.blockhound.BlockHound;

@SpringBootApplication
public class BlockHoundDemoApplication {

	public static void main(String[] args) {
//		BlockHound.install();
		SpringApplication.run(BlockHoundDemoApplication.class, args);
	}

}
