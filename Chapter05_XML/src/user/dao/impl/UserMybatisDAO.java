package user.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;


import lombok.Setter;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;

import user.bean.UserDTO;
import user.dao.UserDAO;

@Transactional  		// 트랜잭션 자동 commit&close => 메소드 머리위에마다 걸어도됨
public class UserMybatisDAO implements UserDAO {

	@Setter
	private SqlSession sqlSession;

	
	//UserInsertService
	@Override
	public void write(UserDTO userDTO) {		
		sqlSession.insert("userSQL.write", userDTO);
	}
	
	//UserSelectService
	@Override
	public List<UserDTO> getUserList() {
		return sqlSession.selectList("userSQL.getUserList");
	}

	
	// UserUpdateService
	@Override
	public UserDTO getExistId(String id) {
			return sqlSession.selectOne("userSQL.getExistId", id);
	}

	@Override
	public void update(Map<String, String> map) {
		sqlSession.update("userSQL.update", map);
	}

	// UserDeleteService
	@Override
	public void delete(String id) {
		sqlSession.delete("userSQL.delete", id);		
	}

}
