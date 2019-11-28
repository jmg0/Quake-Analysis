package com.jmg0.quakeanalysis;

public class PhraseFilter implements Filter {
    private String phrase, name;

    public PhraseFilter(String phrase, String name) {
        this.phrase = phrase;
        this.name = name;
    }

    @Override
    public boolean satisfies(Earthquake earthquake) {
        return earthquake.getTitle().contains(phrase);
    }

    @Override
    public String filterDescription() {
        return "Earthquakes whose title contains the phrase: " + phrase;
    }

    @Override
    public String getName() {
        return name;
    }
}
