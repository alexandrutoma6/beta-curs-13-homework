package org.example;

import org.example.models.Quote;
import org.example.services.FileReader;
import org.example.services.QuoteService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        FileReader reader = new FileReader();
        List<Quote> quotes = reader.readQuotesFromFile("src/main/resources/quotes.txt");

//        printList(quotes);
        QuoteService quoteService = new QuoteService(quotes);

        System.out.println(quoteService.getAllQuotes());
        System.out.println(quoteService.getRandomQuote());
        System.out.println(quoteService.getFavourites());

    }

    private static void printList(List<Quote> quotes) {
        for (Quote quote : quotes) {
            System.out.println(quote);
        }
    }
}