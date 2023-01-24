package com.fk.utility;

import org.testng.IExecutionListener;

import com.flipkart.base.TestBase;

public class ExecutionListener implements IExecutionListener {

	@Override
	public void onExecutionStart() {

	}

	@Override
	public void onExecutionFinish() {
		new TestBase().createdEmailableReport();
	}

}
