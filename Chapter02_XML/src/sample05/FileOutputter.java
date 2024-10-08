package sample05;
// 결과를 파일로 출력(내보내는) 클래스

import java.io.FileWriter;
import java.io.IOException;

public class FileOutputter implements Outputter {

	private String filePath;
	private String fileName;
	

	public void setFilePath(String filePath) {
		this.filePath = filePath;
		System.out.println("SETTER : setFilePath(String filePath) ");
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
		System.out.println("SETTER : setFileName(String fileName)");
	}


	@Override
	public void output(String message) {
		System.out.println("output(String message)");
		
		try {
			FileWriter fileWriter = new FileWriter(filePath + fileName);	// 파일 객체 생성
			fileWriter.write(message);
			fileWriter.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
	}

}
