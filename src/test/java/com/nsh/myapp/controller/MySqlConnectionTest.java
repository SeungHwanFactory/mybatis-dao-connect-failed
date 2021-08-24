package com.nsh.myapp.controller;

import java.sql.Connection;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
@Log4j
public class MySqlConnectionTest {
	
	
	@Inject
	private DataSource ds;


	@Test
	public void testConnection() {

		try (Connection con = ds.getConnection()){

			log.info("\n MySQL 연결 : " + con);

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

}
