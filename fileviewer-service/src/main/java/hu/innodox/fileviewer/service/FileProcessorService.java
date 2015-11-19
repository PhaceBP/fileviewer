package hu.innodox.fileviewer.service;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import hu.innodox.fileviewer.dto.ProcessedLine;
import hu.innodox.fileviewer.service.task.FileProcessingTask;

public final class FileProcessorService {

	
	public static Map<String,Future<List<ProcessedLine>>> processFiles(File...files){
		
		ExecutorService executorService = Executors.newFixedThreadPool(files.length);
		
		Map<String,Future<List<ProcessedLine>>> tasksInProgess = new HashMap<>();

		for(File f : files){
			FileProcessingTask task = new FileProcessingTask(f);
			Future<List<ProcessedLine>> processedLines = executorService.submit(task);
			tasksInProgess.put(f.getName(),processedLines);
		}
		
		executorService.shutdown();
		
		return tasksInProgess;
	}
}
