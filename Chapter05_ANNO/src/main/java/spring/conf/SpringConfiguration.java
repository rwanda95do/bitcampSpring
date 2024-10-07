package spring.conf;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import user.bean.UserDTO;
import user.main.HelloSpring;
import user.service.UserDeleteService;
import user.service.UserInsertService;
import user.service.UserSelectService;
import user.service.UserUpdateService;

@Configuration
@EnableTransactionManagement
@PropertySource("classpath:spring/db.properties") 		// property 파일 알려줌
public class SpringConfiguration {

// Connection Pool
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
// Mybatis
// SqlSessionFactory
	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		
		sqlSessionFactoryBean.setDataSource(datasource());
		sqlSessionFactoryBean.setConfigLocation(new ClassPathResource("spring/mybatis-config.xml"));
		sqlSessionFactoryBean.setMapperLocations(new ClassPathResource("mapper/userMapper.xml"));
		
		//.getObject() 를 사용해서 sqlSessionFactory를 return 한다.
		return sqlSessionFactoryBean.getObject();
	}
// 	 SqlSession
	@Bean
	public SqlSessionTemplate sqlSession () throws Exception {
		SqlSessionTemplate sqlsessionTemplate = new SqlSessionTemplate(sqlSessionFactory());
		return sqlsessionTemplate;
	}
//  AOP기능 : Transaction 자동  commit & close
	@Bean
	public DataSourceTransactionManager transactionManager() {
		DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager(datasource());
		return dataSourceTransactionManager;
	}
	
}
