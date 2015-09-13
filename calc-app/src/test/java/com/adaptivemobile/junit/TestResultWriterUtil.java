package com.adaptivemobile.junit;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.adaptivemobile.util.ResultWriterUtil;

public class TestResultWriterUtil {

	private String resultexpr;
	private String file;

	@Before
	public void setupData() {
		resultexpr = "23+22=45";
		file = "result/result.txt";
	}

	@After
	public void cleanUpData() {
		resultexpr = "";
		file = "";
	}

	@Test
	public void testwriteResult() {
		ResultWriterUtil.writeResult(resultexpr, file);
		assertTrue("PrintWriter written the resultexpr into file ", true);
	}

}
