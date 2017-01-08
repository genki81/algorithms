package com.genki.algo.algorithm;

import com.genki.algo.algorithm.exception.InvalidAlgorithmException;

public abstract class AbstractAlgorithm {

	private boolean checked = false;

	public AbstractAlgorithm() {
	}

	public void run() {
		if (!this.checked) {
			this.checkAlgorithm();
			this.checked = true;
			this.postInit();
		}
		if (this.checked) {
			this.preNext();
			this.next();
			this.postNext();
		}
	}

	protected abstract void checkAlgorithm() throws InvalidAlgorithmException;

	protected abstract void preNext();

	protected abstract void next();

	protected abstract void postNext();

	protected abstract void postInit();
}
