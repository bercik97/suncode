package pl.robert.suncode.test.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "tabela_testowa")
@Table(name = "tabela_testowa")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
class TestTableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String kolumna1;
    private String kolumna2;
    private String kolumna3;
    private long kolumna4;
}
