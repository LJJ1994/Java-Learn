package config;

import com.itheima.factory.BeanFactory;
import com.itheima.service.IAccountService;
import com.itheima.utils.ConnectionUtils;
import com.itheima.utils.TransactionManager;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

/**
 * @Author: LJJ
 * @Program: spring-day02
 * @Description:
 * @Create: 2020-05-07 18:07:07
 * @Modified By:
 */
@Configuration
public class JdbcConfig {
    @Value("${jdbc.driver}")
    private String driver;

    @Value("${jdbc.url}")
    private String url;

    @Value("${jdbc.username}")
    private String username;

    @Value("${jdbc.password}")
    private String password;

    @Bean(name = "dataSource")
    public DataSource createDataSource(){
        try{
            ComboPooledDataSource cp = new ComboPooledDataSource();
            cp.setUser(username);
            cp.setPassword(password);
            cp.setDriverClass(driver);
            cp.setJdbcUrl(url);
            return cp;
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Bean(name = "runner")
    public QueryRunner createQueryRunner(@Qualifier("dataSource") DataSource dataSource){
        return new QueryRunner(dataSource);
    }

    @Bean(name = "connectionUtils")
    public ConnectionUtils createConUtils(@Qualifier("dataSource") DataSource dataSource){
        return new ConnectionUtils(dataSource);
    }

    @Bean(name = "txManager")
    public TransactionManager transactionManager(@Qualifier("connectionUtils") ConnectionUtils connectionUtils){
        return new TransactionManager(connectionUtils);
    }

    @Bean(name = "beanFactory")
    public BeanFactory beanFactory(){
        return new BeanFactory();
    }
}
