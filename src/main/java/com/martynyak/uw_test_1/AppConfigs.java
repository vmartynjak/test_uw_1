package com.martynyak.uw_test_1;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * Created by vova on 14.09.16.
 */
@Configuration
public class AppConfigs {

    @Value("${db.user}")
    private String user;

    @Value("${db.pwd}")
    private String pwd;

    @Value("${db.url}")
    private String url;

    @Value("${db.datasource_driver}")
    private String driver;

    @Bean
    public DataSource getDb() throws ClassNotFoundException, SQLException {
        HikariConfig config = new HikariConfig();

        config.setDataSourceClassName(driver);
        config.setConnectionTestQuery("VALUES 1");
        config.addDataSourceProperty("URL", url);
        config.addDataSourceProperty("user", user);
        config.addDataSourceProperty("password", pwd);

        HikariDataSource ds = new HikariDataSource(config);
        return ds;
    }
}
