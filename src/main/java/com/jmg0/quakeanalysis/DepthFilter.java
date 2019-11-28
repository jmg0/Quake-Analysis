package com.jmg0.quakeanalysis;

public class DepthFilter implements Filter {
    private double minDepth, maxDepth;
    private String name;

    public DepthFilter(double minDepth, double maxDepth, String name) {
        this.minDepth = minDepth;
        this.maxDepth = maxDepth;
        this.name = name;
    }

    @Override
    public boolean satisfies(Earthquake earthquake) {
        return earthquake.getDepth() >= minDepth && earthquake.getDepth() <= maxDepth;
    }

    @Override
    public String filterDescription() {
        return "Earthquakes with depth between " + minDepth + " and " + maxDepth + " (inclusive)";
    }

    @Override
    public String getName() {
        return name;
    }
}
