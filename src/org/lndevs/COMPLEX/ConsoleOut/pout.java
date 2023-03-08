package org.lndevs.COMPLEX.ConsoleOut;

public class pout
{
	public static void error(String message) {
		System.out.println("ERROR -> " + message);
	}
	
	public static void NiceStackTrace() {
		StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
		StackTraceElement caller = stackTrace[2];
		System.out.println("TRACE: " + caller.getClassName() + "#" + caller.getMethodName());
	}
}
