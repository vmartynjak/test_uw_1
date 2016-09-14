package com.martynyak.uw_test_1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;

/**
 * Created by vova on 14.09.16.
 */
@Service
public class TemperatureService {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void updateTemperature(int temperature) {
        String SQL = "insert into time_temperature (TEMP_TIME, TEMPERATURE) values (NOW(), ?)";
        jdbcTemplate.update( SQL, temperature);
    }

    public int getLast() {
        String SQL = "select TEMPERATURE from time_temperature order by TEMP_TIME desc limit 1";
        Integer temperature = jdbcTemplate.queryForObject(SQL, Integer.class);

        return temperature;
    }
}
