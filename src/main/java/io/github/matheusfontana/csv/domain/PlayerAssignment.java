package io.github.matheusfontana.csv.domain;

import com.opencsv.bean.CsvBindByPosition;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class PlayerAssignment extends CsvBean{
    @CsvBindByPosition(position=0)
    private String id;
    @CsvBindByPosition(position=1)
    private String idPlayer;
    @CsvBindByPosition(position=2)
    private String idTeam;
    @CsvBindByPosition(position=3)
    private String shirtNumber;
}
