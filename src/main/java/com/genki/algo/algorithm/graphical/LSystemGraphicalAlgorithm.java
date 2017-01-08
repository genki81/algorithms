package com.genki.algo.algorithm.graphical;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.genki.algo.algorithm.exception.InvalidAlgorithmException;
import com.genki.algo.algorithm.rule.Rule;

public class LSystemGraphicalAlgorithm extends AbstractGraphicalAlgorithm {
	private final static Logger LOGGER = LoggerFactory.getLogger(LSystemGraphicalAlgorithm.class);

	private String current;
	private final String alphabet;
	private final Set<Rule> rules;
	private final int initLength;
	private int length;

	public LSystemGraphicalAlgorithm(final String alphabet, final String initial, final Set<Rule> rules) {
		super(800, 800);
		this.alphabet = alphabet;
		this.current = initial;
		this.rules = rules;
		this.initLength = this.getWidth();
		this.length = this.getWidth();
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
	protected void draw() {
		LOGGER.info(this.current);
		LOGGER.info(String.valueOf(this.length));
		this.reset();
		for (final char c : this.current.toCharArray()) {
			switch (c) {
			case 'F':
				this.move(this.length, this.length);
				this.addLine();
				break;
			case 'G':
				this.move(this.length, this.length);
				break;
			case '-':
				break;
			case '+':
				break;
			default:
				break;
			}
		}
	}

	@Override
	protected void preNext() {
		this.length = this.initLength / this.current.length();
	}

}
