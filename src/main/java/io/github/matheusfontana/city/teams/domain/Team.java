package io.github.matheusfontana.city.teams.domain;

import lombok.Data;
import org.springframework.lang.Nullable;

import java.util.List;

@Data
public class Team {
    private long id;
    private String alias;
    private String country;
    private String stadium;
    private String sponsorAirline;
    private String sponsorBus;
    private String manager;
    private Integer minHomeGrown;
    private Integer maxForeigners;
    private boolean allowEU;
    private boolean allowCotonou;
    private boolean allowAsia;
    private Integer maxTeamSize;
    @Nullable
    private List<Player> players;
}
