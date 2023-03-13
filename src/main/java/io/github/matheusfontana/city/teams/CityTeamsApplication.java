package io.github.matheusfontana.city.teams;

import io.github.matheusfontana.city.teams.domain.Team;
import io.github.matheusfontana.city.teams.service.CityTeamService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.*;
import java.util.List;

@SpringBootApplication
@Slf4j
public class CityTeamsApplication implements CommandLineRunner {
    @Override
    public void run(String... args) {
        CityTeamService cityTeamService = new CityTeamService();
        List<Team> teamList = cityTeamService.getTeams();
        assert teamList != null;
        teamList.stream().forEach(
                team -> {
                    try {
                        cityTeamService.squadBuilder(team);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    log.info("{} {}",team.getAlias(), team.getPlayers().toString());
                }
        );
    }

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(CityTeamsApplication.class);
        try {
            System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out), true, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        // disable spring banner
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }
}
