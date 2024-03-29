import java.io.*;
import java.util.*;

public class LineCount extends FileScanner {
	private int totalLineCount;

	public LineCount(){
		totalLineCount = 0;
	}

	public LineCount(String directory, String filePattern, boolean recurse) {
		super(directory, filePattern, recurse);
		totalLineCount = 0;
	}
	
	protected void run() {
		processDirectory(new File(directory));
		printResults("TOTAL: " + totalLineCount);
	}

	protected void performSpecificFileOperation(File file) {
		countLinesInFile(file);
	}

	@Override
	protected void setSearchVariables(String searchPat) {}

	private static void usage() {
		usage("java LineCount {-r} <dir> <file-pattern>");
	}

	// LineCount specific methods

	private void countLinesInFile(File file) {
		try {
			Reader reader = new BufferedReader(new FileReader(file));
			int curLineCount = 0;
			try {
				curLineCount = 0;
				Scanner input = new Scanner(reader);
				while (input.hasNextLine()) {
					String line = input.nextLine();
					++curLineCount;
					++totalLineCount;
				}
			}
			finally {
				System.out.println(curLineCount + "  " + file);
				reader.close();
			}
		}
		catch (IOException e) {
			printError(file, UNREADABLE_FILE);
		}
	}
	
	public static void main(String[] args) {
		LineCount lineCounter = new LineCount();

		if (!lineCounter.parseArgs(args, true)) {
			usage();
			return;
		}

		lineCounter.run();
	}
}
