package user.service;

import java.util.List;

import user.bean.UserUploadDTO;

public interface UserUploadService {

	void upload(List<UserUploadDTO> imageUploadList);

}
