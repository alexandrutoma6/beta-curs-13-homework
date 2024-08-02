package org.example.services;

import org.example.models.Quote;

import java.util.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class FileReader {

    public List<Quote> readQuotesFromFile(String filename) {
        List<Quote> quotes = new ArrayList<>();

        try (BufferedReader br = Files.newBufferedReader(Paths.get(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("~");
                if (parts.length == 2) {
                    Quote quote = createQuote(parts);
                    quotes.add(quote);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return quotes;
    }

    private static Quote createQuote(String[] parts) {
        String author = parts[0];
        String quoteText = parts[1];
        return new Quote(author, quoteText);
    }

}
