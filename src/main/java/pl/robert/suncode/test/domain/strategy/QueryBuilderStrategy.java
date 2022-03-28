package pl.robert.suncode.test.domain.strategy;

import pl.robert.suncode.test.domain.QueryType;

public interface QueryBuilderStrategy {

    boolean isApplicableFor(QueryType type);

    String buildSQL(String columnName);
}
