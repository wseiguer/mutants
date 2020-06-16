package meli.exam.mutants.services.dtos;

import java.text.DecimalFormat;

public class Stats {
    private long count_mutant_dna;
    private long count_human_dna;
    // private double ratio;

    public Stats(long countMutants, long countHuman) {
        this.count_mutant_dna = countMutants;
        this.count_human_dna = countHuman;
    }

    public long getCount_mutant_dna() {
        return count_mutant_dna;
    }

    public long getCount_human_dna() {
        return count_human_dna;
    }

    public double getRatio() {
        long total = count_mutant_dna + count_human_dna;
        if (total == 0) {
            return 1f;
        } else {
            DecimalFormat df = new DecimalFormat("#.##");
            String sRatio = df.format((count_mutant_dna / (double) total));
            double ratio = Double.valueOf(sRatio).doubleValue();
            return ratio;
        }
    }
}