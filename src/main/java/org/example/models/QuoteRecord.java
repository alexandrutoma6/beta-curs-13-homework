package org.example.models;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public record QuoteRecord(int id, String author, String quote, AtomicBoolean favorite) {
    private static int nextId = 1;

    public QuoteRecord(String author, String quote) {
        this(nextId++, author, quote, new AtomicBoolean(false));
    }

    public boolean isFavorite() {
        return favorite.get();
    }

    public void setFavorite(boolean favorite) {
        this.favorite.set(favorite);
    }

    public static void main(String[] args) {
        QuoteRecord quote = new QuoteRecord("Mihai","Imi place sa mananc");

        System.out.println(quote);
        quote.setFavorite(true);
        System.out.println(quote);
    }
}
