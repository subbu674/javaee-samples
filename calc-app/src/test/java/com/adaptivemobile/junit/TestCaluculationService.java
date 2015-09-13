package com.adaptivemobile.junit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.adaptivemobile.service.CaluculationService;
import com.adaptivemobile.service.CaluculationServiceImpl;

public class TestCaluculationService {

	private CaluculationService calcService;
	private int numberA;
	private int numberB;
	@Before
	public void setupData()
	{
		calcService = new CaluculationServiceImpl();
		numberA = 52;
		numberB = 30;
	}
	
	@After
	public void cleanUpData()
	{
		calcService = null;
		numberA = 0;
		numberB = 0;
	}
	
	
	@Test
	public void testAddition()
	{
		assertEquals("The sum of 52 and 30 is 82 ", 82, calcService.add(numberA, numberB));
	}
	@Test
	public void testSubtraction()
	{
		assertEquals(" 52 minus 30 is 82 ", 22, calcService.sub(numberA, numberB));
	}
}

