package io.github.matheusfontana.csv.helper;

import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import io.github.matheusfontana.csv.domain.CsvBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.Writer;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;

@Service
@Slf4j
public class ProEvolutionSoccerCSVFileWriter {
    public void writeCsvFromBean(Path path) throws Exception {

        List<CsvBean> sampleData = Collections.emptyList();

        try (Writer writer  = new FileWriter(path.toString())) {

            StatefulBeanToCsv<CsvBean> sbc = new StatefulBeanToCsvBuilder<CsvBean>(writer)
                    .withQuotechar('\'')
                    .withSeparator(CSVWriter.DEFAULT_SEPARATOR)
                    .build();

            sbc.write(sampleData);
        }

    }

}
