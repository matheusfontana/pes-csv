package io.github.matheusfontana.csv.service;

import io.github.matheusfontana.csv.helper.ProEvolutionSoccerCSVFileReader;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Year;
import java.util.List;

@Service
@Slf4j
public class ProEvolutionSoccerCSVService {
    @Autowired
    private ProEvolutionSoccerCSVFileReader ProEvolutionSoccerCSVFileReader;

    public void changeContractUntilParameter(Year startingYear) throws URISyntaxException {
        final Path PLAYER_ASSIGNMENTS = Paths.get(
                ClassLoader.getSystemResource("evowebdb/player_assignments_bin.csv").toURI());
        final Path PLAYER_LIST = Paths.get(
                ClassLoader.getSystemResource("evowebdb/player_bin.csv").toURI());

        final String under25 = startingYear.plusYears(5).toString();
        final String under32 = startingYear.plusYears(3).toString();
        final String over32 = startingYear.plusYears(1).toString();

        try {
            final List<String[]> playerAssignments = ProEvolutionSoccerCSVFileReader.parseCsvFileToString(PLAYER_ASSIGNMENTS);
            //List<CsvBean> playerAssignments = ProEvolutionSoccerCSVFileReader.parseCsvFileToBean(PLAYER_ASSIGNMENTS, PlayerAssignment.class);
            playerAssignments.forEach(assignment -> System.out.println(assignment.toString()));
            //List<CsvBean> players = ProEvolutionSoccerCSVFileReader.parseCsvFileToBean(PLAYER_LIST, Player.class);
            //players.forEach(System.out::println);
        } catch (Exception e) {
            log.error("Error while trying to read file");
        }
    }
}
