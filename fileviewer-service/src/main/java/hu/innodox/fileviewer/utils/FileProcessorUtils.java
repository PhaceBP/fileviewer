package hu.innodox.fileviewer.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import hu.innodox.fileviewer.dto.ProcessedLine;
import hu.innodox.fileviewer.exception.ProcessingException;

public final class FileProcessorUtils {

	private FileProcessorUtils() {

	}

	public static List<ProcessedLine> readAndProcessFilePerLine(File...files) {

		List<ProcessedLine> ret = new ArrayList<>();

                for(File f : files){
                    try (Stream<String> lines = Files.lines(f.toPath())) {
                            lines.forEach(l -> ret.add(new ProcessedLine(l)));
                    } 
                    catch (IOException ex) {
                            throw new ProcessingException(f.getName(), ex.getLocalizedMessage());
                    }
                }
		return ret;
	}
        
        
        public static File[] finder(File directory){
            return directory.listFiles((File dir1, String filename) -> filename.endsWith(".txt"));
        }
}
