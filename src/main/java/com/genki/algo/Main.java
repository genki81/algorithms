package com.genki.algo;

import java.util.HashSet;
import java.util.Set;

import javax.swing.JFrame;

import com.genki.algo.algorithm.graphical.LSystemGraphicalAlgorithm;
import com.genki.algo.algorithm.rule.Rule;

public class Main {

	public static void main(final String[] args) {
		final Set<Rule> rules = new HashSet<Rule>();
		rules.add(new Rule('F', "FGF"));
		final LSystemGraphicalAlgorithm algo = new LSystemGraphicalAlgorithm("FG", "F", rules);

		final JFrame application = new JFrame();

		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		application.setUndecorated(true);
		application.add(algo.getPanel());
		application.setSize(algo.getWidth(), algo.getHeight());
		application.setVisible(true);

	}

}
