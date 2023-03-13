package io.github.matheusfontana.city.teams.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.matheusfontana.city.teams.enums.PESPositionEnum;
import lombok.Data;
import org.springframework.lang.Nullable;

import java.util.ArrayList;
import java.util.List;
@Data
public class Player {
    @Nullable
    @JsonProperty("favoriteNumbers")
    private List<Integer> favoriteNumbers = new ArrayList<>();
    @JsonProperty("name")
    private String name;
    @JsonProperty("position")
    private PESPositionEnum position;
    @JsonProperty("eFootball")
    private String eFootball;
    @Nullable
    @JsonProperty("pesID")
    private String pesID;
    @JsonProperty("overall")
    private Integer overall;
    @JsonProperty("nation")
    private String nation;
    @JsonProperty("homegrown")
    private String homegrown;
    @Nullable
    @JsonProperty("secondNation")
    private String secondNation;
}
