package restovoteApp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class DatabaseConfig {

    @Bean
    public DriverManagerDataSource getDataSource() {

        DriverManagerDataSource bds = new DriverManagerDataSource();
        bds.setDriverClassName("org.h2.Driver");
        bds.setUrl("jdbc:h2:mem:restovote");
        bds.setUsername("root");
        bds.setPassword("");

        return bds;
    }
}
