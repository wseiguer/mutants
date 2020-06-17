package meli.exam.mutants;

/**
 * TestConstant
 */
public class TestConstants {
	public static final String[] MUTANT_DNA = {"ATGCGA", "CAGTGC", "TTATGT",
			"AGAAGG", "CCCCTA", "TCACTG"};
	public static final String[] MUTANT_DNA_2 = {"AAAACCAAAA", "GTGTGTGTGT",
			"ACACACACAC", "GTGTGTGTGT", "ACACACACAC", "GTGTGTGTGT",
			"ACACACACAC", "GTGTGTGTGT", "ACACACACAC", "GTGTGTGTGT"};
	public static final String[] HUMAN_DNA = {"ACGTGA", "TGAATG", "ACACAC",
			"CTGGAT", "TGTCAC", "GTACTC"};
	public static final String[] HUMAN_DNA_2 = {"AAAAAA", "GTGTGT", "ACACAC",
			"GTGTGT", "ACACAC", "GTGTGT"};
	public static final String[] UNBALANCED_DNA = {"ACACACAAAA", "GTGTGT",
			"ACACAC", "GTGTGT", "ACACAC", "GTGTGT"};
	public static final String[] WRONG_CHARACTERS_DNA = {"XCACAC", "GTGTGT",
			"ACACAC", "GTGTGT", "ACACAC", "GTGTGT"};
	public static final String[] SMALL_DNA = {"AAA", "CCC", "GGG"};
}