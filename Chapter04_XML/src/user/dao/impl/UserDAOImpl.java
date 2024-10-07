package user.dao.impl;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import lombok.Setter;
import user.bean.UserDTO;
import user.dao.UserDAO;


public class UserDAOImpl implements UserDAO {

// 템플릿 클래스
	@Setter
	private JdbcTemplate jdbcTemplate = null;
	
	/*
	 * public void setJdbcTemplate(JdbcTemplate jdbcTemplate) { this.jdbcTemplate =
	 * jdbcTemplate; }
	 */

	//UserInsertService
	@Override
	public void write(UserDTO userDTO) {
		String sql = "insert into usertable values (?, ?, ?)";
		jdbcTemplate.update(sql, userDTO.getName(), userDTO.getId(), userDTO.getPwd());		// insert, update, delete 전부다함
	}
	
	//UserSelectService
	@Override
	public List<UserDTO> getUserList() {
		String sql = "select * from usertable";
		// new BeanPropertyRowMapper() : Spring 한줄씩 연결해줄께! : getID  
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<UserDTO>(UserDTO.class));	// select 
		// (UserDTO.class) : mysql이 누구랑 연결하는지 모르까 UserDTO랑 연결되는거야 라고 알려주는거임
	}

	//UserUpdateService
	@Override
	public UserDTO getUser(String id) {
		String sql = "select * from usertable where id=" + id;
		return (UserDTO) jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper(UserDTO.class));
	}

	@Override
	public void update(UserDTO userDTO) {
		String sql = "update usertable set name =?, pwd=? where id=?";
		jdbcTemplate.update(sql, userDTO.getName(), userDTO.getPwd(), userDTO.getId());
		
	}

}

