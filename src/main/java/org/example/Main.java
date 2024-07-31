package org.example;

import org.example.models.Quote;
import org.example.services.FileReader;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        FileReader reader = new FileReader();
        List<Quote> quotes = reader.readQuotesFromFile("src/main/resources/quotes.txt");
        for (Quote quote : quotes) {
            System.out.println(quote);
        }
    }
}