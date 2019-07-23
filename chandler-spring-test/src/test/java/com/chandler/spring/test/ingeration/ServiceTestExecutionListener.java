/*
 * ServiceTestExecutionListener.java
 * 2019年7月22日 上午11:51:33
 *
 * Please contact chandler 
 * if you need additional information or have any questions.
 * @author 钱丁君-chandler
 * @version 1.0
 */

package com.chandler.spring.test.ingeration;

import org.dbunit.IDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.util.fileloader.XlsDataFileLoader;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.TestExecutionListener;

import com.chandler.spring.test.annotation.DataSets;

/**
 * 类功能描述
 * 
 * @version
 * @author 钱丁君-chandler 2019年7月22日上午11:51:33
 * @since 1.8
 */
public class ServiceTestExecutionListener implements TestExecutionListener {
	private IDatabaseTester databaseTester;

	@Override
	public void afterTestClass(TestContext arg0) throws Exception {
	}

	@Override
	public void afterTestMethod(TestContext arg0) throws Exception {
		if (databaseTester != null) {
			databaseTester.onTearDown();
		}
	}

	@Override
	public void beforeTestClass(TestContext arg0) throws Exception {
	}

	@Override
	public void beforeTestMethod(TestContext testCtx) throws Exception {
		DataSets dataSetAnnotation = testCtx.getTestMethod().getAnnotation(DataSets.class);

		if (dataSetAnnotation == null) {
			return;
		}

		String dataSetName = dataSetAnnotation.setUpDataSet();

		if (!dataSetName.equals("")) {
			databaseTester = (IDatabaseTester) testCtx.getApplicationContext().getBean("databaseTester");
			XlsDataFileLoader xlsDataFileLoader = (XlsDataFileLoader) testCtx.getApplicationContext()
					.getBean("xlsDataFileLoader");
			IDataSet dataSet = xlsDataFileLoader.load(dataSetName);
			databaseTester.setDataSet(dataSet);
			databaseTester.onSetup();
		}
	}

	@Override
	public void prepareTestInstance(TestContext arg0) throws Exception {
	}
}
