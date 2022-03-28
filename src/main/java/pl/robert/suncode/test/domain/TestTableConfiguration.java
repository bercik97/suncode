package pl.robert.suncode.test.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import pl.robert.suncode.test.domain.strategy.QueryBuilderStrategy;
import pl.robert.suncode.test.domain.strategy.QueryBuilderStrategyFactory;
import pl.robert.suncode.test.domain.strategy.QueryBuilderStrategyService;

import java.util.List;

@Configuration
class TestTableConfiguration {

    @Bean
    public TestTableService testTableService(List<QueryBuilderStrategy> queryTypeStrategies,
                                             JdbcTemplate jdbcTemplate) {
        QueryBuilderStrategyFactory queryBuilderStrategyFactory = new QueryBuilderStrategyFactory(queryTypeStrategies);
        QueryBuilderStrategyService queryBuilderStrategyService = new QueryBuilderStrategyService(queryBuilderStrategyFactory);
        return new TestTableService(queryBuilderStrategyService, jdbcTemplate);
    }
}
