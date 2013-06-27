package myboard.config;

import myboard.interceptor.LoginCheckInterceptor;
import myboard.repository.BoardJdbcRepository;
import myboard.repository.BoardRepository;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.sql.DataSource;

/**
 * Created with IntelliJ IDEA.
 * User: winey
 * Date: 13. 6. 7
 * Time: 오후 1:26
 * To change this template use File | Settings | File Templates.
 */
@EnableWebMvc
@ComponentScan(basePackages = {"myboard"})
@Configuration
public class BoardConfig extends WebMvcConfigurerAdapter {
    @Bean
    public BoardRepository boardRepository() {
        //return new BoardMemoryRepository();
        //return new BoardDBRepository();
        return new BoardJdbcRepository(psqlDataSource());
    }
    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("/messages");
        return messageSource;
    }

    @Bean
    public LoginCheckInterceptor loginCheckInterceptor() {
        return new LoginCheckInterceptor();
    }


    @Bean
    public DataSource psqlDataSource (){
        SimpleDriverDataSource dataSource = new SimpleDriverDataSource( );
        dataSource.setDriverClass(org.postgresql.Driver.class);
        dataSource.setUrl("jdbc:postgresql://localhost:5432/myboard");
        dataSource.setUsername("myboard");
        dataSource.setPassword("myboard");

        return dataSource;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //registry.addInterceptor(loginCheckInterceptor()).excludePathPatterns("/login/**");
        registry.addInterceptor(loginCheckInterceptor()).addPathPatterns("/myboard/**");


    }
}
