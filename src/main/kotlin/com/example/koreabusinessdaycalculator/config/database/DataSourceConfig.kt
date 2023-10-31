package com.example.koreabusinessdaycalculator.config.database

import com.zaxxer.hikari.HikariDataSource
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.jdbc.datasource.LazyConnectionDataSourceProxy
import org.springframework.transaction.annotation.EnableTransactionManagement
import javax.sql.DataSource

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
    basePackages = ["com.example.koreabusinessdaycalculator.api.*"],
)
class DataSourceConfig {

    @Bean("masterDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.master")
    fun masterDataSource(): DataSource {
        return DataSourceBuilder.create().type(HikariDataSource::class.java).build()
    }

    @Bean("slaveDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.slave")
    fun slaveDataSource(): DataSource {
        return DataSourceBuilder.create().type(HikariDataSource::class.java).build()
            .apply { isReadOnly = true }
    }

    @Bean
    @ConditionalOnBean(name = ["masterDataSource", "slaveDataSource"])
    fun routingDataSource(
        @Qualifier("masterDataSource") masterDataSource: DataSource,
        @Qualifier("slaveDataSource") slaveDataSource: DataSource
    ): DataSource {
        val routingDataSource = RoutingDataSource()
        val dataSources: Map<Any, Any> = mapOf("master" to masterDataSource, "slave" to slaveDataSource)
        routingDataSource.setTargetDataSources(dataSources)
        routingDataSource.setDefaultTargetDataSource(masterDataSource)
        return routingDataSource
    }

    @Primary
    @Bean(name = ["currentDataSource"])
    @ConditionalOnBean(name = ["routingDataSource"])
    fun currentDataSource(routingDataSource: DataSource) = LazyConnectionDataSourceProxy(routingDataSource)

//    @Primary
//    @Bean(name = ["entityManagerFactory"])
//    fun entityManagerFactory(
//        @Qualifier("currentDataSource") currentDataSource: DataSource
//    ): LocalContainerEntityManagerFactoryBean {
//        val entityManagerFactory = LocalContainerEntityManagerFactoryBean()
//        entityManagerFactory.dataSource = currentDataSource
//        entityManagerFactory.jpaVendorAdapter = HibernateJpaVendorAdapter()
//        return entityManagerFactory
//    }
}