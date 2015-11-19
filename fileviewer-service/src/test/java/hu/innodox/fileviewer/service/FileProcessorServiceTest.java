package hu.innodox.fileviewer.service;

import hu.innodox.fileviewer.utils.FileProcessorUtils;
import static org.junit.Assert.assertEquals;

import java.io.File;
import java.util.List;

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
}
