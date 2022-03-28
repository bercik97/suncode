package pl.robert.suncode.test.domain.response;

import lombok.Value;

@Value(staticConstructor = "of")
public class TestQueryResponse {

    long id;
    String kolumna1;
    String kolumna2;
    String kolumna3;
    long kolumna4;

    @Override
    public String toString() {
        return String.format("%d;\"%s\";\"%s\";\"%s\";\"%d\"", id, kolumna1, kolumna2, kolumna3, kolumna4);
    }
}
