package com.adaptivemobile.main.app;

import com.adaptivemobile.constants.CalculatorConstants;
import com.adaptivemobile.service.CaluculationService;
import com.adaptivemobile.service.CaluculationServiceImpl;
import com.adaptivemobile.util.NumberReaderUtil;
import com.adaptivemobile.util.ResultWriterUtil;

public class CalculatorApp {
	
	private static StringBuffer buffer = new StringBuffer();

	public static void main(String[] args) {
		
		int  numberA = NumberReaderUtil.getNumberForInputFile(CalculatorConstants.NUMBER_A_FILE_PATH);
		int  numberB = NumberReaderUtil.getNumberForInputFile(CalculatorConstants.NUMBER_B_FILE_PATH);
		
		CaluculationService service = new  CaluculationServiceImpl();
		
		int result = service.add(numberA, numberB);
		System.out.printf("%d + %d = %d", numberA,numberB,result);
		buffer.append(numberA+" + "+numberB+" = "+result+"\n");

		result = service.sub(numberA, numberB);
		System.out.println();
		System.out.printf("%d - %d = %d", numberA,numberB,result);
		buffer.append(numberA+" - "+numberB+" = "+result+"\n");
		
		result = service.sub(numberA, numberB);
		System.out.println();
		System.out.printf("%d - %d = %d", numberA,numberB,result);
		buffer.append(numberA+" - "+numberB+" = "+result+"\n");
		
		ResultWriterUtil.writeResult(buffer.toString(),CalculatorConstants.RESULT_FILE_PATH);
		
	}
}
