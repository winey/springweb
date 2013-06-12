package myboard.config;

import myboard.repository.BoardMemoryRepository;
import myboard.repository.BoardRepository;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

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
        return new BoardMemoryRepository();
    }
    @Bean
    public MessageSource messageSource () {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("/messages");
        return messageSource;
    }
}
