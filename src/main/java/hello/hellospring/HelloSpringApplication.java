package hello.hellospring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelloSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloSpringApplication.class, args); // Embedded Tomcat

		/*

		선택한 라이브러리는 spring-web, thymeleaf만 선택했지만 라이브러리들은 엄청나게 많다
		왜 ? 그래들이나 메이븐 같은 빌드툴은 의존관계를 모두 관리를 해준다.
		spring-boot-start-web라이브러리를 선택하면 관련된 라이브러리들을 모두 땡겨온다.


		 */
	}

}
