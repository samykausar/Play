package org.sameer.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.sameer.jdbc.model.Circle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

public class JdbcDaoImpl {
	DataSource dataSource;
	@Autowired
	JdbcTemplate jdbcTemplate;
	NamedParameterJdbcTemplate namedParamenterJdbcTemplate;
	public DataSource getDataSource() {
		return dataSource;
	}
	
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		this.namedParamenterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	public Circle getCircle(int circleId) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
/*		Connection conn = null;
		conn = dataSource.getConnection();*/
/*		this.jdbcTemplate.setDataSource(getDataSource());*/
		String sql="SELECT * FROM CIRCLE WHERE ID=:id";
		SqlParameterSource namedParameter = new MapSqlParameterSource("id", circleId);
		Circle circle = (Circle) namedParamenterJdbcTemplate.queryForObject(sql,namedParameter, new CircleMapper());


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
