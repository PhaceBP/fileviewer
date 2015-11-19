package hu.innodox.fileviewer.dto;

import hu.innodox.fileviewer.utils.DateUtils;
import java.io.Serializable;

public class ProcessedLine implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2140073177627363917L;

	private final String processingTimeStamp;
	
	private final String threadName;
	
	private final String line;
	
	
	
	public ProcessedLine(String line){
		this.processingTimeStamp = DateUtils.getCurrentTimeStamp();
		this.threadName = Thread.currentThread().getName();
		this.line = line;
	}


	public String getProcessingDate() {
		return processingTimeStamp;
	}



	public String getThreadName() {
		return threadName;
	}



	public String getLine() {
		return line;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((line == null) ? 0 : line.hashCode());
		result = prime * result + ((processingTimeStamp == null) ? 0 : processingTimeStamp.hashCode());
		result = prime * result + ((threadName == null) ? 0 : threadName.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProcessedLine other = (ProcessedLine) obj;
		if (line == null) {
			if (other.line != null)
				return false;
		} else if (!line.equals(other.line))
			return false;
		if (processingTimeStamp == null) {
			if (other.processingTimeStamp != null)
				return false;
		} else if (!processingTimeStamp.equals(other.processingTimeStamp))
			return false;
		if (threadName == null) {
			if (other.threadName != null)
				return false;
		} else if (!threadName.equals(other.threadName))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "ProcessedLine [processingTimeStamp=" + processingTimeStamp + ", threadName=" + threadName + ", line="
				+ line + "]";
	}
	
}
