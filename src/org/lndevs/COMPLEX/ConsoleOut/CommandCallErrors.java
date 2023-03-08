package org.lndevs.COMPLEX.ConsoleOut;

public class CommandCallErrors
{
	public void CallableNotFound(String command)
	{
		pout.error("CallableNotFound: " + command + " could not find the callable corresponding to this CallableName. Please ensure that this CallableName is indeed, defined.");
	}
}
