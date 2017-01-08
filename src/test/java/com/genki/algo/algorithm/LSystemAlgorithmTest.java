package com.genki.algo.algorithm;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import com.genki.algo.algorithm.exception.InvalidAlgorithmException;
import com.genki.algo.algorithm.rule.Rule;
import com.genki.algo.algorithm.textual.LSystemAlgorithm;

public class LSystemAlgorithmTest {

	@Test(expected = InvalidAlgorithmException.class)
	public void badInitial() throws InvalidAlgorithmException {
		final LSystemAlgorithm algo = new LSystemAlgorithm("A", "AC", null);
		algo.run();
	}

	@Test(expected = InvalidAlgorithmException.class)
	public void badRuleFromInit() throws InvalidAlgorithmException {
		final Set<Rule> rules = new HashSet<Rule>();
		rules.add(new Rule('B', "A"));
		final LSystemAlgorithm algo = new LSystemAlgorithm("A", "A", rules);
		algo.run();
	}

	@Test(expected = InvalidAlgorithmException.class)
	public void badRuleSameFromInit() throws InvalidAlgorithmException {
		final Set<Rule> rules = new HashSet<Rule>();
		rules.add(new Rule('B', "A"));
		rules.add(new Rule('B', "AB"));
		final LSystemAlgorithm algo = new LSystemAlgorithm("AB", "A", rules);
		algo.run();
	}

	@Test(expected = InvalidAlgorithmException.class)
	public void badRuleToInit() throws InvalidAlgorithmException {
		final Set<Rule> rules = new HashSet<Rule>();
		rules.add(new Rule('A', "B"));
		final LSystemAlgorithm algo = new LSystemAlgorithm("A", "A", rules);
		algo.run();
	}
}
