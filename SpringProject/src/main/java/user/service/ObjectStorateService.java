package user.service;

import org.springframework.web.multipart.MultipartFile;

public interface ObjectStorateService {

	public String uploadFile(String bucketName, String string, MultipartFile img);

	public void deleteFile(String bucketName, String string, String imageFileName);

}
