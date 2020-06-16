package meli.exam.mutants.services.impl;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import meli.exam.mutants.model.Dna;
import meli.exam.mutants.utils.suffixtree.GeneralizedSuffixTree;

@Service
public class MutantDnaAnalyzerServiceImpl extends DnaAnalyzerServiceImpl {
    private static final String[] MUTANT_DNA_SEQUENCES = { "AAAA", "CCCC", "GGGG", "TTTT" };

    @Override
    public boolean isMutant(String[] dnaString) {
        Dna dna = dnaRepository.findBySequence(dnaString);
        if (dna != null)
            return dna.isMutant();

        dna = new Dna(dnaString, false);
        GeneralizedSuffixTree generalizedSuffixTree = new GeneralizedSuffixTree();
        ArrayList<String> sequence = reorganizeDnaSequence(dna);
        for (int i = 0; i < sequence.size(); i++) {
            generalizedSuffixTree.put(sequence.get(i), i);
        }
        int count = 0;
        for (String mutantDnaSequence : MUTANT_DNA_SEQUENCES) {
            count += generalizedSuffixTree.search(mutantDnaSequence).size();
            if (count >= 2) {
                dna.setMutant(true);
                break;
            }
        }
        dnaRepository.save(dna);
        return dna.isMutant();
    }

    private static ArrayList<String> reorganizeDnaSequence(Dna dna) {
        ArrayList<String> sequenceReorganized = new ArrayList<>();
        String[] sequence = dna.getSequence();
        // Reorganizo filas
        for (String s : sequence) {
            sequenceReorganized.add(s);
        }
        // Reorganizo Columnas
        for (int row = 0; row < sequence.length; row++) {
            StringBuffer strColumn = new StringBuffer(sequence.length);
            for (int column = 0; column < sequence.length; column++) {
                strColumn.append(sequence[column].charAt(row));
            }
            sequenceReorganized.add(strColumn.toString());
        }
        // Reorganizo oblicuo
        for (int i = 0; i < sequence.length / 2; i++) {
            StringBuffer obliqueDna1 = new StringBuffer(sequence.length);
            StringBuffer obliqueDna2 = new StringBuffer(sequence.length);
            for (int j = 0; j < sequence.length - i; j++) {
                obliqueDna1.append(sequence[j].charAt(j + i));
                if (i != 0) {
                    obliqueDna2.append(sequence[i + j].charAt(j));
                }
            }
            if (obliqueDna1.length() > 0) {
                sequenceReorganized.add(obliqueDna1.toString());
            }
            if (obliqueDna2.length() > 0) {
                sequenceReorganized.add(obliqueDna2.toString());
            }
        }
        return sequenceReorganized;
    }

}