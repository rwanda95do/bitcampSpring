package user.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import lombok.Setter;
import user.bean.UserDTO;
import user.dao.UserDAO;


// setDataSource를  NamedParameterJdbcDaoSupport의 부모가 가지고 있음(근데 final이라서 오버라이드 불가능)

// @Component
@Repository			// DB랑 연동중임을 나타내는 annotation
public class UserDAOImpl extends NamedParameterJdbcDaoSupport implements UserDAO {
	
	@Autowired
	public void setDS(DataSource dataSource) {	// 그래서 이름을 setDataSource라고 잡으면 안된다.
		setDataSource(dataSource);
		
	}
		
	//UserInsertService
	@Override
	public void write(UserDTO userDTO) {
		Map<String, String> map = new HashMap<>();
		map.put("name", userDTO.getName());
		map.put("id", userDTO.getId());
		map.put("pwd", userDTO.getPwd());
		
		String sql = "insert into usertable values (:name, :id, :pwd)";
		getNamedParameterJdbcTemplate().update(sql, map);
	}
	
	//UserSelectService
	@Override
	public List<UserDTO> getUserList() {
		String sql = "select * from usertable";
		// new BeanPropertyRowMapper() : Spring 한줄씩 연결해줄께! : getID  
		return getJdbcTemplate().query(sql, new BeanPropertyRowMapper<UserDTO>(UserDTO.class));	// select 
		// (UserDTO.class) : mysql이 누구랑 연결하는지 모르까 UserDTO랑 연결되는거야 라고 알려주는거임
	}

	
	// UserUpdateService
	@Override
	public UserDTO getExistId(String id) {
		String sql = "select * from usertable where id=?";
		try {
			// queryForObject : 하나만 가져올 때 
			return getJdbcTemplate().queryForObject(sql, new BeanPropertyRowMapper<UserDTO>(UserDTO.class), id);
			
		} catch (Exception e) {
			//e.printStackTrace();
			return null;
		}
	}

	@Override
	public void update(Map<String, String> map) {
		String sql = "update usertable set name=:name, pwd=:pwd where id=:id";
		getNamedParameterJdbcTemplate().update(sql, map);
		
	}

	// UserDeleteService
	@Override
	public void delete(String id) {
		// org.springframework.jdbc.BadSqlGrammarException : sql문법 오류
		String sql = "delete from usertable where id=?";
		getJdbcTemplate().update(sql, id);
		
	}

}
