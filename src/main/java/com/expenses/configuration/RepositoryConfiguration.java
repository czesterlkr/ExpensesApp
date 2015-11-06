package com.expenses.configuration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by gnester on 2015-10-28.
 */
@Configuration
@EnableAutoConfiguration
@EntityScan(basePackages = {"com.expenses.entity"})
@EnableJpaRepositories(basePackages = {"com.expenses.repository"})
@EnableTransactionManagement
public class RepositoryConfiguration {
}
