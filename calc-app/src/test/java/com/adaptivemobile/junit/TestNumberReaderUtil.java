package com.adaptivemobile.junit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.adaptivemobile.exceptions.FileReadException;
import com.adaptivemobile.exceptions.InvalidNumberException;
import com.adaptivemobile.util.NumberReaderUtil;

public class TestNumberReaderUtil {

	private String inputfile;
	private String inputfile2;
	@Before
	public void setupData()
	{
		inputfile = "inputs/numberA.txt";
		inputfile2 = "inputs/numberB.txt";
	}
	@After
	public void cleanUpData()
	{
		inputfile = "";
		inputfile2 = "";
	}
	@Test
	public void testGetNumberForInputFile()
	{
		assertEquals("File content 2147 ",2147,NumberReaderUtil.getNumberForInputFile(inputfile));
		
	}
	
	@Test(expected=FileReadException.class)
	public void testGetNumberForInputFile_WrongFilePath()
	{
		assertEquals("WrongFilePath provided ",2147,NumberReaderUtil.getNumberForInputFile(inputfile+"123"));
		
	}
	
	@Test(expected=InvalidNumberException.class)
	public void testGetNumberForInputFile_InvaildFileContent()
	{
		assertEquals("put InvaildFileContent like 175g55 in numberB txt file ",2147,NumberReaderUtil.getNumberForInputFile(inputfile2));
		
	}
	
}
