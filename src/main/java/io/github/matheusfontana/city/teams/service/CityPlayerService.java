package io.github.matheusfontana.city.teams.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import io.github.matheusfontana.city.teams.domain.Player;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URL;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Getter
@Setter
@Slf4j
public class CityPlayerService extends BaseService {
    final String filePath = "file:src/main/resources/fontanacity/players.json";

    private List<Player> playerList;

    public CityPlayerService(){
        try {
            playerList = this.readJsonFile();
        } catch (Exception e){
            log.error(e.getMessage());
        }
    }

    @Override
    protected List<Player> readJsonFile() throws IOException {
        try {
            JsonNode jsonNode = objectMapper.readTree(new URL(filePath));
            List<Player> list = objectMapper.readerFor(new TypeReference<List<Player>>(){})
                    .readValue(jsonNode.get("players"));
            return list.stream()
                    .sorted(Comparator.comparing(Player::getOverall).reversed())
                    .collect(Collectors.toList());
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return Collections.emptyList();
    }
}
