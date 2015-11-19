package hu.innodox.fileviewer.service;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.junit.Test;

import hu.innodox.fileviewer.dto.ProcessedLine;

public class FileProcessorServiceTest {

	
	
	
	@Test
	public void testFileProcessorUtilsWorksProperly(){
		
		ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("ProcessFileSuccessfull.txt").getFile());
		List<ProcessedLine> lines = FileProcessorUtils.readAndProcessFilePerLine(file);
		
		lines.stream().forEach(l -> System.out.println(l));
		
		assertEquals(4, lines.size());
		
	}
	

	@Test
	public void testExecutorServiceWorksPropertly() throws InterruptedException, ExecutionException{
		
		ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("ProcessFileSuccessfull.txt").getFile());
        File file2 = new File(classLoader.getResource("ProcessFileSuccessfull2.txt").getFile());
		
        Map<String,Future<List<ProcessedLine>>> result = FileProcessorService.processFiles(file,file2);
		assertEquals(4, result.get("ProcessFileSuccessfull.txt").get().size());
		
	}
}
