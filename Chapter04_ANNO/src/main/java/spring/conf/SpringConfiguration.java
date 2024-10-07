package spring.conf;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import user.bean.UserDTO;
import user.dao.impl.UserDAOImpl;
import user.main.HelloSpring;
import user.service.UserDeleteService;
import user.service.UserInsertService;
import user.service.UserSelectService;
import user.service.UserUpdateService;

@Configuration
@PropertySource("classpath:spring/db.properties") 		// property 파일 알려줌
public class SpringConfiguration {

	private @Value("${jdbc.driver}") String driver;
	private @Value("${jdbc.url}") String url;
	private @Value("${jdbc.username}") String username;
	private @Value("${jdbc.password}") String password;
	
	@Bean
	public BasicDataSource datasource() {
		BasicDataSource basicDataSource =  new BasicDataSource();
		
		// basicDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");  	// 가능하지만, @PropertySource("classpath:spring/db.properties") 사용하면.. 
		
		basicDataSource.setDriverClassName(driver);
		basicDataSource.setUrl(url);
		basicDataSource.setUsername(username);
		basicDataSource.setPassword(password);
		
		return basicDataSource;
	}

}
