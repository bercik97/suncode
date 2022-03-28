package pl.robert.suncode.test.domain.strategy;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.robert.suncode.test.domain.QueryType;

import java.util.List;

@Component
@RequiredArgsConstructor
public class QueryBuilderStrategyFactory {

    private final List<QueryBuilderStrategy> queryTypes;

    public QueryBuilderStrategy getStrategyFor(QueryType queryType) {
        return queryTypes.stream()
                .filter(strategy -> strategy.isApplicableFor(queryType))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Invalid type for query type strategy"));
    }
}
