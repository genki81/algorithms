package com.genki.algo.algorithm.rule;

public class Rule {
	private char from;
	private String to;

	public Rule(final char from, final String to) {
		this.from = from;
		this.to = to;
	}

	public char getFrom() {
		return this.from;
	}

	public void setFrom(final char from) {
		this.from = from;
	}

	public String getTo() {
		return this.to;
	}

	public void setTo(final String to) {
		this.to = to;
	}

	@Override
	public String toString() {
		return "[" + this.from + "] -> [" + this.to + "]";
	}
}
