package com.klymchuk;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@SqlGroup({
    @Sql(executionPhase = ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:beforeTestRunHSQLDB.sql"),
    @Sql(executionPhase = ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:afterTestRunHSQLDB.sql") 
})
public class ApplicationTest {
	
    @Autowired
    private JdbcTemplate jdbcTemplate;
	
    @Test
    public void preloadDBTestForHSQLDB() {
    	
    	String selectQuery = "SELECT * from PERSON WHERE PERSONID = 1";

        	List<Map<String, Object>> resultSet = jdbcTemplate.queryForList(selectQuery);

        System.out.println(resultSet);
        
    }
    
    /*
     * Code the same preloadDBTestForHSQLDB
     * 1. add mySql dependency
     * 2. add application.properties with mySql configuration
     * 
     */
    @Test
    public void preloadDBTestForMySQL() {
    	
    	String selectQuery = "SELECT * from PERSON WHERE PERSONID = 1";

        	List<Map<String, Object>> resultSet = jdbcTemplate.queryForList(selectQuery);

        System.out.println(resultSet);
        
    }

}
