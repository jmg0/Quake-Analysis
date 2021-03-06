package com.jmg0.quakeanalysis;

import java.util.ArrayList;

public class CompositeFilter implements Filter {
    private ArrayList<Filter> filters;

    public CompositeFilter() {
        filters = new ArrayList<>();
    }

    public void addFilter(Filter f) {
        filters.add(f);
    }

    @Override
    public boolean satisfies(Earthquake earthquake) {
        for(Filter f : filters) {
            if(!f.satisfies(earthquake)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String filterDescription() {
        return "Earthquakes that satisfy all filters combined in this composite filter";
    }

    @Override
    public String getName() {
        StringBuilder name = new StringBuilder();
        for(int i = 0; i < filters.size(); i++) {
            if(i != filters.size() - 1) {
                name.append(filters.get(i).getName()).append(", ");
            }
            else {
                name.append(filters.get(i).getName());
            }
        }
        return name.toString();
    }
}
