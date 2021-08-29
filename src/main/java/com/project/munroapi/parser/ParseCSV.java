package com.project.munroapi.parser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

import com.opencsv.bean.CsvToBeanBuilder;
import com.project.munroapi.model.Munro;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ParseCSV implements CommandLineRunner {

    private static List<Munro> munroData;

    @Value("${csv.file.location}")
    private String csvFileLocation;

    @Override
    public void run(String... args) {
        init();
    }

    private void init() {
        try {
            List<Munro> munros = new CsvToBeanBuilder<Munro>(new FileReader(csvFileLocation))
                    .withType(Munro.class)
                    .build()
                    .parse();

            sanitiseMunroData(munros);
            setMunroData(munros);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void sanitiseMunroData(List<Munro> munros) {
        munros.removeIf(munro -> (munro.getRunningNo().isEmpty() || munro.getPost1997().isEmpty()));
    }

    public void setMunroData(List<Munro> munros) {
        ParseCSV.munroData = munros;
    }

    public List<Munro> getMunroData() {
        return ParseCSV.munroData;
    }
}
