package pl.robert.suncode.test.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.data.util.Pair;
import org.springframework.jdbc.core.JdbcTemplate;
import pl.robert.suncode.test.domain.response.TestQueryResponse;
import pl.robert.suncode.test.domain.strategy.QueryBuilderStrategyService;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class TestTableService {

    private final QueryBuilderStrategyService queryBuilderStrategyService;
    private final JdbcTemplate jdbcTemplate;

    public Pair<List<String>, List<String>> findAllColumnsWithQueryTypes() {
        List<String> columns = Arrays.stream(TestTableEntity.class.getDeclaredFields())
                .map(Field::getName)
                .filter(name -> !"id".equals(name))
                .collect(Collectors.toList());
        List<String> queryTypes = Arrays.stream(QueryType.values())
                .map(Enum::name)
                .collect(Collectors.toList());
        return Pair.of(columns, queryTypes);
    }

    public String findByColumnNameAndQueryType(String columnName, QueryType queryType) {
        final String sql = queryBuilderStrategyService.query(columnName, queryType);
        List<String> result = jdbcTemplate.query(sql, (resultSet, rowNum) ->
                TestQueryResponse.of(
                        resultSet.getLong(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getLong(5)))
                .stream()
                .map(TestQueryResponse::toString)
                .collect(Collectors.toList());
        return String.join("<br>", result);
    }
}
