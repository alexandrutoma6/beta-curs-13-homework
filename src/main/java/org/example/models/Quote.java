package org.example.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@EqualsAndHashCode
@ToString
@Getter
public class Quote {
    private static int nextId = 1;
    private final int id;
    private final String author;
    private final String quote;
    @Setter
    private boolean favorite;

    public Quote(String author, String quote){
        this.id = nextId++;
        this.author = author;
        this.quote = quote;
        this.favorite = false;
    }

}
