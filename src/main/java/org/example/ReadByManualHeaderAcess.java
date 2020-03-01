package org.example;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadByManualHeaderAcess {
    private static final String PATH_STUDENTS = "students2.csv";

    public static void main(String[] args) throws IOException {
        try (
                Reader reader = Files.newBufferedReader(Paths.get(PATH_STUDENTS));
                CSVParser parser = new CSVParser(reader, CSVFormat.DEFAULT
                        .withHeader("ID", "Name", "Faculty", "Year", "Nationality")
                        .withIgnoreHeaderCase()
                        .withTrim());
        ) {
            for (CSVRecord record : parser) {
                String ID = record.get("ID");
                String name = record.get("Name");
                String faculty = record.get("Faculty");
                String year = record.get("Year");
                String nationality = record.get("Nationality");

                printCSV(record, ID, name, faculty, year, nationality);
            }
        }
    }

    public static void printCSV(CSVRecord record, String ID, String name, String faculty, String year, String nationality) {
        System.out.println("Record No: " + record.getRecordNumber());
        System.out.println("--------------------------------------");
        System.out.println("ID : " + ID);
        System.out.println("Name : " + name);
        System.out.println("Faculty : " + faculty);
        System.out.println("Year : " + year);
        System.out.println("Nationality : " + nationality);
        System.out.println("--------------------------------------");
    }
}
