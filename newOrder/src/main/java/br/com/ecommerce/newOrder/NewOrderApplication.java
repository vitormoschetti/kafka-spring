package br.com.ecommerce.newOrder;

import br.com.ecommerce.newOrder.service.NewOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class NewOrderApplication extends SpringBootServletInitializer {

	@Autowired
	private NewOrderService newOrder;

	public static void main(String[] args) {
		SpringApplication.run(NewOrderApplication.class, args);
	}

	@PostConstruct
	public void newOrder(){
		newOrder.create();
	}

}
