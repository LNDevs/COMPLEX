package org.lndevs.COMPLEX.program;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Program
{
	private ArrayList<Line> Lines = new ArrayList<Line>();
	public Program(ArrayList<String> lines) {
		lines.forEach((line) -> {
			Lines.add(new Line(line));
		});
	}
	
	/**
	 * A Line implementation in COMPLEX. It wraps default strings and allows some utilities.
	 * */
	public class Line {
		public String Line;
		public int LineNumber;
		public boolean IsCalled = false;
		
		/**
		 * @param line The line of code.
		 * @param lineNumber The line number.
		 * @param isCalled If the line is called or not.
		 * Instances a new Line object using provided parameters.
		 * IsCalled is used to determine if the line is called or not. If it is called, it will not execute by default.
		 * */
		public Line(String line, int lineNumber, boolean isCalled) {
			Line = line;
			LineNumber = lineNumber;
			IsCalled = isCalled;
		}
		
		/**
		 * @param UnParsedLine The line of code.
		 * Instances a new Line object the easy way. This will be used externally.
		 * Also determines if the line is called or not. Called lines will not execute by default. this is defined in the line number e.g line 10 is a non-called line (will execute) and line 10C is a called line (will not execute).
		 * Checks for any Syntax errors will throw an error if found.
		 * */
		public Line(String UnParsedLine) {
			String[] command = UnParsedLine.split(" ");
			
			// Instantly remove any comments from the line.
			UnParsedLine = UnParsedLine.replaceAll("//.*", "");
			
			if (UnParsedLine.length() == 0) {
				// Line is empty, so we can just return.
				return;
			}
			
			if (!LU.HasLineNumber(UnParsedLine)) {
				// Line does not have a line number, so we can just return.
				return;
			}
			
			String lineNumber = LU.GetLineNumber(UnParsedLine);
			if (lineNumber == null) return; // Line number is null, so we can just return. Its likely just a empty line.
			if (LU.IsCallable(lineNumber)) {
				IsCalled = true;
			}
			
			Line = UnParsedLine.replace(lineNumber, "");
		}
	}
	
	private static class LU
	{
		public static boolean HasLineNumber(String line) {
			// Define the regular expression to match line numbers with or without a "C" suffix
			String lineNumberRegex = "^\\d+([Cc])?\\s";
			
			// Use the regular expression to check whether the line starts with a line number
			return line.matches(lineNumberRegex);
		}
		
		public static String GetLineNumber(String line) {
			// Define the regular expression to match line numbers with or without a "C" suffix
			String lineNumberRegex = "^(\\d+([Cc])?)\\s";
			
			// Use a Pattern and Matcher to find the line number in the string
			Pattern pattern = Pattern.compile(lineNumberRegex);
			Matcher matcher = pattern.matcher(line);
			if (matcher.find()) {
				return matcher.group(1);
			} else {
				return null;
			}
		}
		
		public static boolean IsCallable(String number) {
			return number.endsWith("C");
		}
		
		
	}
}
