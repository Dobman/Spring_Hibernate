package pl.coderslab.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import javax.persistence.EntityManagerFactory;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan(basePackages = {"pl.coderslab.controller", "pl.coderslab.Entity", "pl.coderslab.Dao" })
public class AppConfig {
    @Bean
    public ViewResolver viewResolver(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }
   @Bean
    public	LocalEntityManagerFactoryBean	entityManagerFactoryBean()	{
        LocalEntityManagerFactoryBean	emfb	=	new LocalEntityManagerFactoryBean();
        emfb.setPersistenceUnitName("bookstorePersistenceUnit");
        return	emfb;	}
    @Bean
    public	JpaTransactionManager	transactionManager(EntityManagerFactory emf)	{
        JpaTransactionManager	tm	=	new JpaTransactionManager(emf);
        return	tm;	}
}
