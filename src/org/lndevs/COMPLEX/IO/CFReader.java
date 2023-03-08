package org.lndevs.COMPLEX.IO;

import java.io.File;
import java.util.ArrayList;

/**
 * This is the COMPLEX File Reader class. it makes it easy to read files and hide the crappy OS stuff.
 */
public class CFReader
{
	private final String FilePath;
	private final ArrayList<String> FileLines = new ArrayList<String>();
	private int LineIndex = 0;
	
	public CFReader(String FileAbsDir, URIKind URIType)
	{
		if (URIType == URIKind.RELATIVE)
		{
			// Get CWD and append the relative path. This makes an absolute path. If the path is still invalid. We will throw the user an error to make their day a bit better :)
			FilePath = System.getProperty("user.dir") + File.separator + FileAbsDir;
		}
		else
		{
			// The directory is absolute, so we can just use it.
			FilePath = FileAbsDir;
		}
		
		if (DoesExist()) {
			// Read into the ArrayList to allow easy lexical analysis.
			File file = new File(FilePath);
			if (file.canRead()) {
				// Actually try to read it, and throw an error if it fails.
				try {
					java.util.Scanner scanner = new java.util.Scanner(file);
					while (scanner.hasNextLine()) {
						FileLines.add(scanner.nextLine());
					}
					scanner.close();
				} catch (Exception e) {
					Errors.Throw(Errors.Types.UNKNOWN_EXCEPTION);
				}
			} else {
				Errors.Throw(Errors.Types.FILE_NOT_READABLE);
			}
		} else {
			Errors.Throw(Errors.Types.FILE_NOT_FOUND);
		}
		
	}
	
	public boolean DoesExist()
	{
		// get file and check if existing.
		File file = new File(FilePath);
		return file.exists();
	}
	
	/**
	 * @return line a String of the next line in the local array of code lines.
	 * */
	public String NextLine() {
		if (LineIndex >= FileLines.size()) {
			LineIndex = 0;
			return null;
		}
		
		return FileLines.get(LineIndex++);
	}
	
	public String AtIndex(int index) {
		if (index >= FileLines.size()) return null;
		return FileLines.get(index);
	}
	
	public enum URIKind
	{
		RELATIVE,
		ABSOLUTE
	}
}
