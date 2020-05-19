package config;

import com.itheima.utils.ConnectionUtils;
import com.itheima.utils.TransactionManager;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

/**
 * @Author: LJJ
 * @Program: spring-day02
 * @Description:
 * @Create: 2020-05-07 18:04:04
 * @Modified By:
 */
@Configuration
@ComponentScan("com.itheima")
@Import({JdbcConfig.class})
@PropertySource("classpath:jdbcConfig.properties")
public class SpringConfiguration {

}
