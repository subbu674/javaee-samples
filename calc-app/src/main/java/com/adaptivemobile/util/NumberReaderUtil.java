package com.adaptivemobile.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.adaptivemobile.exceptions.FileReadException;
import com.adaptivemobile.exceptions.InvalidNumberException;

public class NumberReaderUtil {
	
	private static BufferedReader br = null;
	private static int number;
	private static String line;

	public static int getNumberForInputFile(String inputfile) {
		try {
			br = new BufferedReader(new FileReader(inputfile));
			line = br.readLine();
			number = Integer.parseInt(line);
			
		} catch (FileNotFoundException e) {
			throw new FileReadException("Couldn't find The  Input File Path : " + inputfile, e);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		catch (NumberFormatException e) {
			throw new InvalidNumberException("The Input in the text file is Not a Number or too long : " + line + ", Valid Number Range is from 0 to  "+Integer.MAX_VALUE, e);
		}
		finally
		{
			try {
				if(br!=null)
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return number;
	}

}
