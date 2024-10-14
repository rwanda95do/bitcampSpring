package spring.conf;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import user.bean.UserDTO;


@Configuration
@EnableTransactionManagement
@PropertySource("classpath:spring/db.properties") 		// property 파일 알려줌
@MapperScan("user.dao")     // UserDAO만 사용하는 방법2  
public class SpringConfiguration {
// *Mapper 2개 이상 [와일드카드]
	@Autowired
	private ApplicationContext context;

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
		//sqlSessionFactoryBean.setConfigLocation(new ClassPathResource("spring/mybatis-config.xml"));  // 지웠으니까 같이 삭제해줘야한다.
	// Mapper
		// 1개
		//sqlSessionFactoryBean.setMapperLocations(new ClassPathResource("mapper/userMapper.xml"));
		// 2개 이상 [배열]
		//sqlSessionFactoryBean.setMapperLocations(new ClassPathResource("mapper/userMapper.xml")
		//										,new ClassPathResource("mapper/userMapper.xml"));
		// * 2개 이상 [와일드카드]
		sqlSessionFactoryBean.setMapperLocations(context.getResources("classpath:mapper/*Mapper.xml"));
	// Ailias
		//sqlSessionFactoryBean.setTypeAliasesPackage("user.bean"); // 클래스명을 알리아스명으로 잡아버림
		sqlSessionFactoryBean.setTypeAliasesPackage("*.bean"); // 패키지를 따로 잡았을 경우
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
