package hu.innodox.fileviewer.service.task;

import java.io.File;
import java.util.List;
import java.util.concurrent.Callable;

import hu.innodox.fileviewer.dto.ProcessedLine;
import hu.innodox.fileviewer.service.FileProcessorUtils;

public class FileProcessingTask implements Callable<List<ProcessedLine>>{
	
	private File fileToProcess;
	
	public FileProcessingTask(File fileToProcess) {
		this.fileToProcess = fileToProcess;
	}

	public File getFileToProcess() {
		return fileToProcess;
	}

	@Override
	public List<ProcessedLine> call() throws Exception {
		return FileProcessorUtils.readAndProcessFilePerLine(fileToProcess);
	}
}
