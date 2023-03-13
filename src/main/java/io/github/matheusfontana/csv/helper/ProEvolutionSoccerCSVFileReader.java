package io.github.matheusfontana.csv.helper;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvValidationException;
import io.github.matheusfontana.csv.domain.CsvBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@Slf4j
public class ProEvolutionSoccerCSVFileReader {
    public List<CsvBean> parseCsvFileToBean(Path path, Class<? extends CsvBean> clazz) {

        try (Reader reader = Files.newBufferedReader(path)) {
            CsvToBean<CsvBean> cb = new CsvToBeanBuilder<CsvBean>(reader)
                    .withType(clazz)
                    .withSeparator(';')
                    .withSkipLines(0)
                    .build();

            return cb.parse();
        } catch (Exception e) {
            log.error(e.getMessage());
        }

        return Collections.emptyList();
    }

    public List<String[]> parseCsvFileToString(Path path) throws IOException {
        List<String[]> list = new ArrayList<>();

        try (Reader reader = Files.newBufferedReader(path)) {
            CSVParser parser = new CSVParserBuilder()
                    .withSeparator(';')
                    .withIgnoreQuotations(true)
                    .build();

            try (CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(0).withCSVParser(parser).build()) {
                String[] line;
                while ((line = csvReader.readNext()) != null) {
                    list.add(line);
                }
            }
        } catch (IOException | CsvValidationException e) {
            log.error(e.getMessage());
        }

        return list;
    }
}
