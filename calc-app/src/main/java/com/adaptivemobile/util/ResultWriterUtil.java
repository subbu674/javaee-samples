package com.adaptivemobile.util;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class ResultWriterUtil {

	private static PrintWriter pw = null;
	public static void writeResult(String resultexpr, String file) {
		try {
			pw = new PrintWriter(file);
			pw.printf(resultexpr);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		finally
		{
			if(pw!=null)
			{
				pw.close();
			}
		}
		
	}

}
