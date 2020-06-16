package meli.exam.mutants.services.impl;

import org.springframework.beans.factory.annotation.Autowired;

import meli.exam.mutants.repositories.DnaRepository;
import meli.exam.mutants.services.DnaAnalyzerService;
import meli.exam.mutants.services.dtos.Stats;

public abstract class DnaAnalyzerServiceImpl implements DnaAnalyzerService {
    @Autowired
    protected DnaRepository dnaRepository;

    public abstract boolean isMutant(String[] dna);

    public Stats getStats() {
        long countMutants = dnaRepository.countAllByIsMutant(true);
        long countHuman = dnaRepository.countAllByIsMutant(false);
        Stats stats = new Stats(countMutants, countHuman);
        return stats;
    }
}