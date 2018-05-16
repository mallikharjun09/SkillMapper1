package com.niit.skillmapper.configuration;

import java.util.Properties;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;


import com.niit.skillmapper.services.SkillServiceImplementation;
import com.niit.skillmapper.model.Employee;
import com.niit.skillmapper.model.Skills;
import com.niit.skillmapper.services.EmployeeServices;
import com.niit.skillmapper.services.EmployeeServicesImplementation;
import com.niit.skillmapper.services.SkillService;

@Configuration
@ComponentScan(basePackages="com.niit")
@EnableTransactionManagement
public class SpringConfiguration {
	@Bean(name="dataSource")
    public DataSource getDataSource(){
        BasicDataSource dataSource=new BasicDataSource();
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUrl("jdbc:h2:tcp://localhost/~/skillmapper");
        dataSource.setUsername("sa");
        dataSource.setPassword("");
        return dataSource;
    }

    private Properties getHibernateProperties(){
       Properties props=new Properties();
       props.setProperty("hibernate.show_sql","true");
       props.setProperty("hibernate.dialect","org.hibernate.dialect.H2Dialect");
       props.setProperty("hibernate.hbm2ddl.auto","update");
       return props;
    }

    @Autowired
    @Bean(name="sessionFactory")
    public SessionFactory getSessionFactory(DataSource dataSource){
       LocalSessionFactoryBuilder sessionBuilder=new LocalSessionFactoryBuilder(dataSource);
       sessionBuilder.addProperties(getHibernateProperties());
	   sessionBuilder.addAnnotatedClass(Employee.class);
	   sessionBuilder.addAnnotatedClass(Skills.class);
	   System.out.println("Session Factory created");
       return sessionBuilder.buildSessionFactory();
    }

    @Autowired
    @Bean(name="transactionManager")
    public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory){
       HibernateTransactionManager transactionManager=new HibernateTransactionManager(sessionFactory);
       System.out.println("Transaction Manager created");
	return transactionManager;
    }

    @Autowired
    @Bean(name="employeeServices")
    public EmployeeServices getEmployeeServices(){
    	System.out.println("Services created");
    	return new EmployeeServicesImplementation();
    }
    
    @Autowired
    @Bean(name="skillService")
    public SkillService getSkillService(){
    	System.out.println("Services created");
    	return new SkillServiceImplementation();
    }
    
    
    
}
