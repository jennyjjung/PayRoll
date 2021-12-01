package ca.sheridancollege.jungjuyo.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.jungjuyo.beans.User;

@Repository
public class UserRepository {
	
	@Autowired
	private NamedParameterJdbcTemplate jdbc;
	
	public User findUserAccount(String userName) {
		
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query = "SELECT * FROM sec_user WHERE userName=:userName";
		parameters.addValue("userName", userName);
		
		ArrayList<User> users = (ArrayList<User>)
				jdbc.query(query, parameters, 
						new BeanPropertyRowMapper<User>(User.class));
		
		if (users.size() > 0) {
			return users.get(0);
		} else {
			return null;
		}
	}
	
	
	public List<String> getRoleById(long userId) {
		
		ArrayList<String> roles = new ArrayList<String>();
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		
		String query = "SELECT user_role.userId, sec_role.roleName FROM "
				+ "user_role, sec_role WHERE user_role.roleId = sec_role.roleID "
				+ "AND userId=:id";
		
		parameters.addValue("id", userId);
		List<Map<String, Object>> rows = jdbc.queryForList(query, parameters);
		for (Map<String, Object> row : rows) {
			roles.add((String)row.get("roleName"));
		}
		
		return roles;
	}
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	public void addUser(String username, String password) {
		
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query = "INSERT INTO sec_user (userName, encryptedPassword, enabled) "
				+ "VALUES (:user, :pass, 1)";
		
		parameters.addValue("user", username);
		parameters.addValue("pass", passwordEncoder.encode(password));
		jdbc.update(query, parameters);
	}
	
	public void addRole(long userId, long roleId) {
		
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query = "INSERT INTO user_role (userId, roleId) VALUES (:uid, :rid)";
		
		parameters.addValue("uid", userId);
		parameters.addValue("rid", roleId);
		
		jdbc.update(query, parameters);
	}
	
	public void deleteUser(User user) {
		
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query = "DELETE FROM sec_user WHERE userId=:id";
		
		parameters.addValue("id", user.getUserId());
		jdbc.update(query, parameters);
	}
	
	public void deleteUserRole(User user) {
		
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query = "DELETE FROM user_role WHERE userId=:id";
		
		parameters.addValue("id", user.getUserId());
		jdbc.update(query, parameters);
	}

}
