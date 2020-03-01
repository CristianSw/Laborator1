package org.example;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class AcessByIndex {
    private static final String PATH_STUDENTS = "students.csv";

    public static void main(String[] args) throws IOException {
        try (
                Reader reader = Files.newBufferedReader(Paths.get(PATH_STUDENTS));
                CSVParser parser = new CSVParser(reader, CSVFormat.DEFAULT);
        ) {
            for (CSVRecord record : parser) {
                String ID = record.get(0);
                String name = record.get(1);
                String faculty = record.get(2);
                String year = record.get(3);
                String nationality = record.get(4);

                ReadByManualHeaderAcess.printCSV(record, ID, name, faculty, year, nationality);
            }
        }
    }
}
