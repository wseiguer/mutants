package meli.exam.mutants.repositories;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import meli.exam.mutants.TestConstants;
import meli.exam.mutants.model.Dna;

/**
 * DnaRepositoryIntegrationTest
 */
@RunWith(SpringRunner.class)
@DataJpaTest
@TestPropertySource("classpath:application.properties")
public class DnaRepositoryTest {
	@Autowired
	private DnaRepository dnaRepository;
	@Autowired
	private TestEntityManager entityManager;
	
	private Dna human;
	private Dna mutant;

	@Before
	public void init() {
		entityManager.clear();
		mutant = new Dna(TestConstants.MUTANT_DNA, true);
		human = new Dna(TestConstants.HUMAN_DNA, false);
	}

	@Test
	public void findById() {
		assertNull(dnaRepository.findBySequence(mutant.getSequence()));
		entityManager.persist(mutant);
		entityManager.flush();
		assertNotNull(dnaRepository.findById(mutant.getId()));
	}

	@Test
	public void findBySequence() {
		assertNull(dnaRepository.findBySequence(mutant.getSequence()));
		entityManager.persist(mutant);
		entityManager.flush();
		assertNotNull(dnaRepository.findBySequence(mutant.getSequence()));
	}

	@Test
	public void countAllByIsMutant() {
		assertEquals(0, dnaRepository.countAllByIsMutant(true));
		assertEquals(0, dnaRepository.countAllByIsMutant(false));
		entityManager.persist(mutant);
		entityManager.flush();
		assertEquals(1, dnaRepository.countAllByIsMutant(true));
		assertEquals(0, dnaRepository.countAllByIsMutant(false));
	}

	@Test
	public void countAllByIsNotMutant() {
		assertEquals(0, dnaRepository.countAllByIsMutant(false));
		assertEquals(0, dnaRepository.countAllByIsMutant(true));
		entityManager.persist(human);
		entityManager.flush();
		assertEquals(1, dnaRepository.countAllByIsMutant(false));
		assertEquals(0, dnaRepository.countAllByIsMutant(true));
	}

}