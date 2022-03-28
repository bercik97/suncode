package pl.robert.suncode.test.domain.strategy;

import lombok.RequiredArgsConstructor;
import pl.robert.suncode.test.domain.QueryType;

@RequiredArgsConstructor
public class QueryBuilderStrategyService {

    private final QueryBuilderStrategyFactory queryBuilderStrategyFactory;

    public String query(String columnName, QueryType queryType) {
        QueryBuilderStrategy strategy = queryBuilderStrategyFactory.getStrategyFor(queryType);
        return strategy.buildSQL(columnName);
    }
}
