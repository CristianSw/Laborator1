package org.example;


import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class CSVWriter {
    private static final String SAMPLE_CSV_FILE = "students2.csv";

    public static void main(String[] args) throws IOException {
        try (
                BufferedWriter writer = new BufferedWriter(new FileWriter(SAMPLE_CSV_FILE));

                CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT
                        .withHeader("ID", "Name", "Faculty", "Year","Nationality"))
        ) {
            csvPrinter.printRecord("1", "Pojar Felicia", "Fizica si Inginerie", "3","Moldoveanca");
            csvPrinter.printRecord("2", "Dolinta Cristian", "Fizica si Inginerie", "3","Moldovean");
            csvPrinter.printRecord("3", "Robu Pavel", "Fizica si Inginerie","3", "Moldovean");
            csvPrinter.printRecord("4", "Surugiu Anatol", "Fizica si Inginerie","3", "Moldovean");
            csvPrinter.printRecord(Arrays.asList("5", "John Grubii", "Economie", "3","Rus"));

            csvPrinter.flush();
        }
    }

}
