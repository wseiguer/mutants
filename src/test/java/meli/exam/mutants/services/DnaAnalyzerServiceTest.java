package meli.exam.mutants.services;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import meli.exam.mutants.TestConstants;
import meli.exam.mutants.model.Dna;
import meli.exam.mutants.repositories.DnaRepository;
import meli.exam.mutants.services.impl.MutantDnaAnalyzerServiceImpl;

@TestPropertySource(locations = {"classpath:application.properties"})
@ContextConfiguration
@RunWith(SpringRunner.class)
public class DnaAnalyzerServiceTest {

	@TestConfiguration
	static class DnaAnalyzerServiceTestContextConfiguration {

		@Bean
		public DnaAnalyzerService dnaService() {
			return new MutantDnaAnalyzerServiceImpl();
		}
	}

	@Autowired
	private DnaAnalyzerService dnaService;

	@MockBean
	private DnaRepository dnaRepository;

	@Test
	public void isMutantDna1() {
		assertTrue(dnaService.isMutant(TestConstants.MUTANT_DNA));
	}

	@Test
	public void isMutantDna2() {
		Dna dna = new Dna();
		dna.setSequence(TestConstants.MUTANT_DNA_2);
		dna.setMutant(true);
		when(dnaRepository.findBySequence(TestConstants.MUTANT_DNA_2))
				.thenReturn(dna);

		assertTrue(dnaService.isMutant(TestConstants.MUTANT_DNA_2));
	}

	@Test
	public void isHumanDna() {
		assertFalse(dnaService.isMutant(TestConstants.HUMAN_DNA));
	}

	@Test
	public void getStats() {
		assertNotNull(dnaService.getStats());
	}
}