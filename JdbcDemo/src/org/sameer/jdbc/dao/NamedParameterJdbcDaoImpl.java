package org.sameer.jdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.sameer.jdbc.model.Circle;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

public class NamedParameterJdbcDaoImpl extends NamedParameterJdbcDaoSupport {
	public Circle getCircle(int circleId) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
				String sql="SELECT * FROM CIRCLE WHERE ID=:id";
				SqlParameterSource namedParameter = new MapSqlParameterSource("id", circleId);
				Circle circle = (Circle) this.getNamedParameterJdbcTemplate().queryForObject(sql,namedParameter, new CircleMapper());
				return 	circle;
			}
	
	
	private static final class CircleMapper implements RowMapper<Circle>{

		@Override
		public Circle mapRow(ResultSet resultSet, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			Circle circle = new Circle();
			circle.setId(resultSet.getInt("ID"));
			circle.setName(resultSet.getString("NAME"));
			return circle;
		}
		
	}

}
