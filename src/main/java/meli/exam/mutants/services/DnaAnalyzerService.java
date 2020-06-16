package meli.exam.mutants.services;

import meli.exam.mutants.services.dtos.Stats;

public interface DnaAnalyzerService {
    boolean isMutant(String[] dna);

    Stats getStats();
}