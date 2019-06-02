package me.kafeitu.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("classpath:/applicationJDBC.xml")
public class SpringConfiguration {
    Logger logger = LoggerFactory.getLogger(getClass());

    @Value("${jdbc.url}")
    private String url;

    @Value("${jdbc.username}")
    private String username;

    @Value("${jdbc.password}")
    private String password;

    /*@Bean
    public DataSource dataSource() {
        logger.info("{},{},{}",url,username,password);
        return new DriverManagerDataSource(url, username, password);
    }*/
}
