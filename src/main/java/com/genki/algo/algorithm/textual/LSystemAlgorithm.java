package com.genki.algo.algorithm.textual;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.genki.algo.algorithm.exception.InvalidAlgorithmException;
import com.genki.algo.algorithm.rule.Rule;

public class LSystemAlgorithm extends AbstractTextualAlgorithm {
	private final static Logger LOGGER = LoggerFactory.getLogger(LSystemAlgorithm.class);

	private String current;
	private final String alphabet;
	private final Set<Rule> rules;

	public LSystemAlgorithm(final String alphabet, final String initial, final Set<Rule> rules) {
		super();
		this.alphabet = alphabet;
		this.current = initial;
		this.rules = rules;
	}

	@Override
	protected void next() {
		final StringBuilder result = new StringBuilder();
		for (final char c : this.current.toCharArray()) {
			for (final Rule r : this.rules) {
				if (r.getFrom() == c) {
					result.append(r.getTo());
					break;
				}
			}
		}
		this.current = result.toString();
		LOGGER.info(this.current);
	}

	@Override
	protected void checkAlgorithm() throws InvalidAlgorithmException {
		if (!StringUtils.containsOnly(this.current, this.alphabet)) {
			throw new InvalidAlgorithmException("Initial state invalid");
		}
		final List<String> froms = new ArrayList<String>();
		for (final Rule r : this.rules) {
			if (!StringUtils.containsOnly(r.getTo(), this.alphabet)) {
				throw new InvalidAlgorithmException("Rule " + r.toString() + " invalid");
			}
			if (!StringUtils.containsOnly(String.valueOf(r.getFrom()), this.alphabet)) {
				throw new InvalidAlgorithmException("Rule " + r.toString() + " invalid");
			}
			if (!froms.contains(String.valueOf(r.getFrom()))) {
				froms.add(String.valueOf(r.getFrom()));
			} else {
				throw new InvalidAlgorithmException("Rule " + r.toString() + " invalid");
			}
		}

	}

	@Override
	protected void postInit() {
		LOGGER.info(this.current);
	}

}
