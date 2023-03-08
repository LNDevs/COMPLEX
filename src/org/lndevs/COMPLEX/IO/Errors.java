package org.lndevs.COMPLEX.IO;

import jdk.jfr.StackTrace;

public class Errors
{
	
	public static void Throw(Types Error, String... args)
	{
		// we can make a StackTrace to detect where the error was thrown.
		StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
		StackTraceElement caller = stackTrace[2];
		
		System.err.println("==================== COMPLEX_ERROR ====================");
		switch (Error)
		{
			case FILE_NOT_FOUND:
				System.err.println("FILE_NOT_FOUND " + args[0] + " @ " + caller.getMethodName());
				break;
			case FILE_NOT_READABLE:
				System.err.println("FILE_NOT_READABLE " + args[0] + " @ " + caller.getMethodName());
				break;
			case UNKNOWN_EXCEPTION:
				System.err.println("UNKNOWN_EXCEPTION " + caller.getClassName() + "#" + caller.getMethodName());
				break;
		}
		System.err.println("=======================================================");
	}
	
	public enum Types
	{
		FILE_NOT_FOUND,
		FILE_NOT_READABLE,
		UNKNOWN_EXCEPTION;
	}
}
