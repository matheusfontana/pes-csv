package io.github.matheusfontana.csv;

import io.github.matheusfontana.csv.service.ProEvolutionSoccerCSVService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.Year;

@SpringBootApplication
@Slf4j
public class PesCsvApplication implements CommandLineRunner {

    @Autowired
    private ProEvolutionSoccerCSVService proEvolutionSoccerCSVService;

    @Override
    public void run(String... args) {
        try {
            final Year startingYear = Year.parse("2022");

            proEvolutionSoccerCSVService.changeContractUntilParameter(startingYear);
        } catch (Exception e) {
           log.info(e.getMessage());
        }
    }

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(PesCsvApplication.class);
        // disable spring banner
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }
}
