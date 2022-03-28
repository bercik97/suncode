package pl.robert.suncode.test;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.util.Pair;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.robert.suncode.test.domain.QueryType;
import pl.robert.suncode.test.domain.TestTableService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/test-table")
@RequiredArgsConstructor
class TestTableController {

    private final TestTableService service;

    @Cacheable("columns-with-query-types")
    @GetMapping("columns-with-query-types")
    public Map<String, List<String>> findAllColumnsWithQueryTypes() {
        final Pair<List<String>, List<String>> columnsWithQueryTypes = service.findAllColumnsWithQueryTypes();
        return Map.of("columns", columnsWithQueryTypes.getFirst(), "queryTypes", columnsWithQueryTypes.getSecond());
    }

    @GetMapping("{columnName}")
    public String findByColumnNameAndQueryType(@PathVariable String columnName, @RequestParam(name = "query_type") QueryType queryType) {
        return service.findByColumnNameAndQueryType(columnName, queryType);
    }
}
