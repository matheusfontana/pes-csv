package io.github.matheusfontana.city.teams.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import io.github.matheusfontana.city.teams.domain.Player;
import io.github.matheusfontana.city.teams.domain.Team;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URL;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CityTeamService extends BaseService {

    final String filePath = "file:src/main/resources/fontanacity/teams.json";

    private CityPlayerService cityPlayerService = new CityPlayerService();

    @Override
    protected List<Team> readJsonFile() throws IOException {
        try {
            JsonNode jsonNode = objectMapper.readTree(new URL(filePath));
            return objectMapper.readerFor(new TypeReference<List<Team>>() {
            }).readValue(jsonNode.get("teams"));
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return Collections.EMPTY_LIST;
    }

    public List<Team> getTeams() {
        try {
            return this.readJsonFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void squadBuilder(Team team) throws IOException {
        List<Player> playerList = cityPlayerService.getPlayerList();
        List<Player> homegrown = playerList.stream()
                .filter(player -> (player.getHomegrown().equalsIgnoreCase(team.getCountry())))
                .collect(Collectors.toList());

        team.setPlayers(homegrown);
    }
}
