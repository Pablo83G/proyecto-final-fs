package com.futurespace.proyecto_final_pvalverde.configs;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;
@Configuration //indica que la clase sobre la que se encuentra aplicada debe ser usada como parte de la configuración de Spring.
@EnableTransactionManagement//Habilita la gestión de transacciones para la configuracion de la bd
public class DatabaseConfigs {
    @Autowired//inyecta el entorno para poder leer las propiedades del archivo application.properties
    private Environment env;

    /* DataSource es un conjunto de conexiones que se crean al arrancar el servidor de aplicaciones y están disponibles
    para cada aplicación durante su ciclo de vida. Las configuraciones se leen desde el archivo application.properties
    (utilizando el objeto env)*/
    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("db.driver"));
        dataSource.setUrl(env.getProperty("db.url"));
        dataSource.setUsername(env.getProperty("db.username"));
        dataSource.setPassword(env.getProperty("db.password"));
        return dataSource;
    }

    /*LocalContainerEntityManagerFactoryBean da acceso completo a la configuración del EntityManagerFactory. Configura
    las propiedades Hibernate, como el dialecto, si se deben mostras las consultas SQL, etc. */
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean entityManagerFactory =
                new LocalContainerEntityManagerFactoryBean();

        entityManagerFactory.setDataSource(dataSource());
        entityManagerFactory.setPackagesToScan("entitymanager.packagesToScan");

        // Escaneo del classpath de clases anotadas con @Component, @Service, etc.
        entityManagerFactory.setPackagesToScan(
                env.getProperty("entitymanager.packagesToScan"));

        // Adaptador del proveedor
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        entityManagerFactory.setJpaVendorAdapter(vendorAdapter);
        // Propiedades de Hibernate
        Properties additionalProperties = new Properties();
        additionalProperties.put(
                "hibernate.dialect",
                env.getProperty("hibernate.dialect"));
        additionalProperties.put(
                "hibernate.show_sql",
                env.getProperty("hibernate.show_sql"));
        additionalProperties.put(
                "hibernate.hbm2ddl.auto",
                env.getProperty("hibernate.hbm2ddl.auto"));
        entityManagerFactory.setJpaProperties(additionalProperties);

        return entityManagerFactory;
    }
    /*
     * Declaración del administrador de transacciones  JPA que utiliza el entityManagerFactory ya configurado.
     * JpaTransactionManager es el responsable de crear apertura de transacciones en el EntityManager y enlazarla al
     * hilo del contexto actual. La etiqueta <tx:annotation-driven /> le dice a Spring que debe de poner un aviso sobre
     *  cualquier método o clase que tenga la anotación @Transactional.
     */
    @Bean
    public JpaTransactionManager transactionManager(LocalContainerEntityManagerFactoryBean entityManagerFactory) {
        JpaTransactionManager transactionManager =
                new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(
                entityManagerFactory.getObject());
        return transactionManager;
    }

    /*
     * PersistenceExceptionTranslationPostProcessor es un bean post procesador que agrega un asesor a cualquier bean
     * anotado con Repository para que cualquier excepción específica de la plataforma sea capturada y luego lanzada
     * como una excepción de acceso a datos no verificada de Spring (es decir, una subclase de DataAccessException).
     */
    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }

}
