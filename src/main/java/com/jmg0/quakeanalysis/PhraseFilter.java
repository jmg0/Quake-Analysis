package com.jmg0.quakeanalysis;

public class PhraseFilter implements Filter {
    private String phrase;

    public PhraseFilter(String phrase) {
        this.phrase = phrase;
    }

    @Override
    public boolean satisfies(Earthquake earthquake) {
        return earthquake.getTitle().contains(phrase);
    }

    @Override
    public String filterDescription() {
        return "Earthquakes whose title contains the phrase: " + phrase;
    }
}
