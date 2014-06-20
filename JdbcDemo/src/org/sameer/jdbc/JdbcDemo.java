package org.sameer.jdbc;

import java.sql.SQLException;

import org.sameer.jdbc.dao.JdbcDaoImpl;
import org.sameer.jdbc.dao.NamedParameterJdbcDaoImpl;
import org.sameer.jdbc.model.Circle;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JdbcDemo {
 public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
	 ApplicationContext context= new ClassPathXmlApplicationContext("spring.xml");
	 NamedParameterJdbcDaoImpl dao=(NamedParameterJdbcDaoImpl) context.getBean("namedParameterJdbcDaoImpl");
	 Circle circle = dao.getCircle(1);
	System.out.println(circle.getName());
 }
}
