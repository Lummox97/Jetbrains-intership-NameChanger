import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.File;
import java.util.stream.Collectors;
import java.util.*;

public class ParseJavaKt {
	public static void main(String [] argv) {
		List<File> arr;

		try {
		arr = Files.walk(Paths.get("."))
				   .filter(ParseJavaKt::ends)
			   	   .map(Path::toFile)
			 	   .collect(Collectors.toList());
		}
		catch(Exception e) {
			System.out.println("Something is wrong");
			return;
		}

		for (File o : arr) {
			if (o.renameTo(new File(o.getPath() + ".2019")))
				System.out.println(o.toString() + ".2019");
		}
	}

	public static boolean ends(Path pat) {
		return pat.toString().endsWith(".kt") || pat.toString().endsWith(".java");
	}
}