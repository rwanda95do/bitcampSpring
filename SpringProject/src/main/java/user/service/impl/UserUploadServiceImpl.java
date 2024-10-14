package user.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import user.bean.UserUploadDTO;
import user.dao.UserUploadDAO;
import user.service.ObjectStorateService;
import user.service.UserUploadService;

@Service
public class UserUploadServiceImpl implements UserUploadService {

	@Autowired
	private UserUploadDAO userUploadDAO; 
	@Autowired
	private HttpSession session;
	@Autowired
	private ObjectStorateService objectStorateService;
	
	private String bucketName = "bitcamp-9th-bucket-115";
	
	@Override
	public void upload(List<UserUploadDTO> imageUploadList) {
		userUploadDAO.upload(imageUploadList);
	}

	@Override
	public List<UserUploadDTO> uploadList() {
		return userUploadDAO.uploadList();
	}

	@Override
	public UserUploadDTO getUploadDTO(String seq) {

		return userUploadDAO.getUploadDTO(seq);
	}

	@Override
	public void uploadUpdate(UserUploadDTO userUploadDTO, MultipartFile img) {
		String filePath = session.getServletContext().getRealPath("WEB-INF/storage");
		System.out.println("실제폴더 : " + filePath);
		
	//Object Storage(NCP)는 이미지를 덮어쓰지 않는다.
		// 1) DB에서 seq에 해당하는 imageFileName(UUID)을 꺼내와서 
		String imageFileName = userUploadDAO.getImageFileName(userUploadDTO.getSeq());
		System.out.println(imageFileName);
		
		// 2)Object Storage(NCP)에 이미지를 삭제하고
		objectStorateService.deleteFile(bucketName, "storage/", imageFileName);
		// 3) 새로운 이미지를 올린다.
		imageFileName = objectStorateService.uploadFile(bucketName, "storage/", img);
		
		String imageOriginalFileName = img.getOriginalFilename(); 
		File file = new File(filePath, imageOriginalFileName);
		
		try {
			img.transferTo(file);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		userUploadDTO.setImageFileName(imageFileName);
		userUploadDTO.setImageOriginalFileName(imageOriginalFileName);
		// 4) DB에 수정
		userUploadDAO.uploadUpdate(userUploadDTO);
	}


}
