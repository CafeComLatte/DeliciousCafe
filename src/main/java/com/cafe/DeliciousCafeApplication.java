package com.cafe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@Controller
@SpringBootApplication
//@EnableRedisHttpSession
public class DeliciousCafeApplication {

	public static void main(String[] args) {
		SpringApplication.run(DeliciousCafeApplication.class, args);
	}
/*
	@GetMapping("/")
    @ResponseBody
    public String index(HttpSession session) {
        session.setAttribute("name", "sup2is");
        return session.getId() + "\nHello " + session.getAttribute("name");
    }
*/
}
