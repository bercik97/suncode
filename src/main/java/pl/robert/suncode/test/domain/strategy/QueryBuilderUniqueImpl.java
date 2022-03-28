package pl.robert.suncode.test.domain.strategy;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.robert.suncode.test.domain.QueryType;

@Component
@RequiredArgsConstructor
class QueryBuilderUniqueImpl implements QueryBuilderStrategy {

    private final QueryType UNIQUE_QUERY_TYPE = QueryType.UNIQUE;

    @Override
    public boolean isApplicableFor(QueryType type) {
        return type == UNIQUE_QUERY_TYPE;
    }

    @Override
    public String buildSQL(String columnName) {
        String sql = "SELECT * FROM tabela_testowa WHERE %s IN (SELECT %s FROM tabela_testowa GROUP BY %s HAVING COUNT(%s) = 1)";
        return sql.replace("%s", columnName);
    }
}
