package io.github.matheusfontana.csv.domain;

import com.opencsv.bean.CsvBindByPosition;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class Player extends CsvBean{
    @CsvBindByPosition(position=0)
    private String id;
    @CsvBindByPosition(position=1)
    private String name;
    @CsvBindByPosition(position=3)
    private String shirt;
    @CsvBindByPosition(position=4)
    private String shirtNational;
    @CsvBindByPosition(position=10)
    private String age;
    @CsvBindByPosition(position=118)
    private String contractUntil;
    @CsvBindByPosition(position=119)
    private String loanUntil;
}
