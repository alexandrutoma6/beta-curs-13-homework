package org.example.services;

import org.example.models.Quote;

import java.util.*;

public class QuoteService {
    private final List<Quote> quotes = new ArrayList<>();

    public QuoteService(List<Quote> list) {
        this.quotes.addAll(list);
    }

    public List<String> getAllQuotes() {
        List<String> result = new ArrayList<>();
        for (Quote quote : quotes) {
            result.add(quote.getQuote());
        }
        return result;
    }

    public List<Quote> getQuotesForAuthor(String author) {
        List<Quote> result = new ArrayList<>();
        for (Quote quote : quotes) {
            if (quote.getAuthor().equalsIgnoreCase(author)) {
                result.add(quote);
            }
        }
        return result;
    }

    public List<String> getAuthors() {
        Set<String> authors = new HashSet<>();
        for (Quote quote : quotes) {
            authors.add(quote.getAuthor());
        }
        return new ArrayList<>(authors);
    }

    public void setFavourite(int id) {
        for (Quote quote : quotes) {
            if (quote.getId() == id) {
                quote.setFavorite(true);
                break;
            }
        }
    }

    public List<Quote> getFavourites() {
        List<Quote> favourites = new ArrayList<>();
        for (Quote quote : quotes) {
            if (quote.isFavorite()) {
                favourites.add(quote);
            }
        }
        return favourites;
    }

    public String getRandomQuote() {
        if (quotes.isEmpty()) {
            return null;
        }
        Random random = new Random();
        int randomIndex = random.nextInt(quotes.size());
        return quotes.get(randomIndex).getQuote();
    }
}
