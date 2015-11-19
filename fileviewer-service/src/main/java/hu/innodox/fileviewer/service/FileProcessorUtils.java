package hu.innodox.fileviewer.service;

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

	public static List<ProcessedLine> readAndProcessFilePerLine(File file) {

		List<ProcessedLine> ret = new ArrayList<>();

		try (Stream<String> lines = Files.lines(file.toPath())) {
			lines.forEach(l -> ret.add(new ProcessedLine(l)));
		} catch (IOException ex) {
			throw new ProcessingException(file.getName(), ex.getLocalizedMessage());
		}

		return ret;
	}
}
