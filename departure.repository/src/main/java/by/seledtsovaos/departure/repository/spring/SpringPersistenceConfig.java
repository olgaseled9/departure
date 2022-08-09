package by.seledtsovaos.departure.repository.spring;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Application context configuration class.
 */
@Configuration
@ComponentScan(basePackages = {"by.seledtsovaos.departure.repository"})
@PropertySource(value = {"classpath:db.properties"})
public class SpringPersistenceConfig {

    @Autowired
    Environment environment;

    @Bean
    public BasicDataSource dataSource() {
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setDriverClassName(environment.getProperty("db.driver"));
        basicDataSource.setUrl(environment.getProperty("db.url"));
        basicDataSource.setUsername(environment.getProperty("db.user"));
        basicDataSource.setPassword(environment.getProperty("db.password"));
        return basicDataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }

//    @Bean
//    PassengerDaoImpl passengerDaoBean() {
//        return new PassengerDaoImpl(jdbcTemplate());
//    }
//
//    @Bean
//    FlightDaoImpl flightDaoBean() {
//        return new FlightDaoImpl(jdbcTemplate());
//    }
//
////    @Bean
////    CountryDaoImpl countryDaoBean() {
////        return new CountryDaoImpl(jdbcTemplate());
////    }
//
//    @Bean
//    AirportDaoImpl airportDaoBean() {
//        return new AirportDaoImpl(jdbcTemplate());
//    }
}

