package com.jmg0.quakeanalysis;

public class DepthFilter implements Filter {
    private double minDepth, maxDepth;

    public DepthFilter(double minDepth, double maxDepth) {
        this.minDepth = minDepth;
        this.maxDepth = maxDepth;
    }

    @Override
    public boolean satisfies(Earthquake earthquake) {
        return earthquake.getDepth() >= minDepth && earthquake.getDepth() <= maxDepth;
    }

    @Override
    public String filterDescription() {
        return "Earthquakes with depth between " + minDepth + " and " + maxDepth + " (inclusive)";
    }
}
