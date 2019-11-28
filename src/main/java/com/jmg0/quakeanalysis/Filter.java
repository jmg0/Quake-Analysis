package com.jmg0.quakeanalysis;

public interface Filter {
    /**
     * Checks whether earthquake parameter satisfies precondition of implmenting class
     * @param earthquake
     * @return
     */
    public boolean satisfies(Earthquake earthquake);

    /**
     * Returns String description of implementing class
     * @return
     */
    public String filterDescription();

    /**
     * Returns Filter name
     * @return
     */
    public String getName();
}
