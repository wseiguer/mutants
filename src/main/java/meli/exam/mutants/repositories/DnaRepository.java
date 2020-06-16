package meli.exam.mutants.repositories;

import org.springframework.data.repository.CrudRepository;

import meli.exam.mutants.model.Dna;

public interface DnaRepository extends CrudRepository<Dna, Integer> {
    Dna findBySequence(String[] sequence);

    long countAllByIsMutant(Boolean isMutant);
}