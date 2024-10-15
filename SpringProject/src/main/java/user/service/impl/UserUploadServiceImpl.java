package user.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
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
		
		System.out.println("img : " + img);
		UserUploadDTO dto = userUploadDAO.getUploadDTO(userUploadDTO.getSeq()+"");  // 기존DB에 보관딘 1개의 정보
		
		if(img.getSize() != 0) { // 이미지를 바꿈 - 새롭게 업로드 하기	
	//Object Storage(NCP)는 이미지를 덮어쓰지 않는다.
			// 1) DB에서 seq에 해당하는 imageFileName(UUID)을 꺼내와서 
			String imageFileName = dto.getImageFileName();
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
		}else { // if(img.getSize() == 0) : 이미지를 수정하지 않았다면 기존DB에 보관된 정보를 올린다
			userUploadDTO.setImageFileName(dto.getImageFileName());
			userUploadDTO.setImageOriginalFileName(dto.getImageOriginalFileName());
		}
		
		
		// 4) DB에 수정
		userUploadDAO.uploadUpdate(userUploadDTO);
	}

	
	@Override
	public void uploadDelete(String[] check) {
	// userUploadMapper.xml에서 <foreach> 사용하려면 데이터를 List에 담는다 또는 애초에 리스트로 받아온다 
		List<String> list = new ArrayList<String>();
		
	//1. ncp삭제(Object Storage에 있는 이미지 삭제)
		for(String seq : check) {
			// 1-1) DB에서 seq에 해당하는 imageFileName(UUID)을 꺼내와서 
			String imageFileName = userUploadDAO.getImageFileName(Integer.parseInt(seq));
			System.out.println(imageFileName);
			list.add(imageFileName);
		}
		// 1-2)Object Storage(NCP)에 이미지를 삭제하고
		objectStorateService.deleteFile(bucketName, "storage/", list);
		
		
	//2. DB 삭제 
		userUploadDAO.uploadDelete(list);
	}



}
