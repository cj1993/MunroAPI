package com.project.munroapi.csv;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

import com.opencsv.bean.CsvToBeanBuilder;
import com.project.munroapi.model.Munro;

public class ParseCSV {

    private static List<Munro> munroData;

    public void init() {
        try {
            List<Munro> munros = new CsvToBeanBuilder<Munro>(new FileReader("./munrotab_v6.2.csv"))
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

    private void setMunroData(List<Munro> munros) {
        ParseCSV.munroData = munros;
    }

    public List<Munro> getMunroData() {
        return ParseCSV.munroData;
    }
}
