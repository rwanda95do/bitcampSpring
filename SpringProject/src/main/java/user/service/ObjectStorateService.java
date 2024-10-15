package user.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public interface ObjectStorateService {

	public String uploadFile(String bucketName, String string, MultipartFile img);

	public void deleteFile(String bucketName, String string, String imageFileName);
	public void deleteFile(String bucketName, String directoryPath, List<String> list);
}
