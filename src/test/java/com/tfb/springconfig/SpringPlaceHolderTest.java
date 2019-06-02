package com.tfb.springconfig;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ImportResource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.sql.SQLException;
import java.sql.Statement;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
@WebAppConfiguration("src/main/webapp")
@ImportResource("classpath:/applicationContext.xml")
public class SpringPlaceHolderTest {
    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    DriverManagerDataSource dataSource;
    @Value("${jdbc.url}")
    public String url;
    @Value("${jdbc.driver}")
    public String driver;
    @Value("${jdbc.username}")
    public String username;
    @Value("${jdbc.password}")
    public String password;
    @Test
    public void runTest() throws SQLException {
        logger.debug("spring configuration right");
        logger.debug("jdbc.url:{}",url);
        logger.debug("jdbc.username:{}",username);
        logger.debug("jdbc.driver:{}",driver);
        logger.debug("jdbc.password:{}",password);
        Statement statement = dataSource.getConnection().createStatement();
        String sql = "create table test(uuid int )";
        statement.execute(sql);
    }
}
