package kh.semi.omjm.group.uploadfile;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.Part;

import kh.semi.omjm.group.vo.GroupAttachmentVo;

public class GroupFileUploader {
	public static GroupAttachmentVo uploadFile(Part f, String rootPath) throws IOException {
		
		String originName = f.getSubmittedFileName();
		String ext = originName.substring(originName.lastIndexOf("."), originName.length()); //lastIndexOf(".") 파일명 .부터  originName.length() 확장자 길이까지
		String changeName =  UUID.randomUUID().toString().substring(0, 5)+"_"+System.currentTimeMillis() + ext; //증복되지 않는값 넣기
		
		String filePath = "upload/img/group";
		String path = rootPath + filePath + "/";
		File target = new File(path + changeName);
		
		
		BufferedInputStream bis = new BufferedInputStream(f.getInputStream());
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(target));
		
		byte[] buf = new byte[1024];
		int size = 0;
		
		while((size = bis.read(buf)) != -1) {
			bos.write(buf, 0, size); //offset = 몇개를 건너뛰겠다 ,  length = 몇개를 처리하겠다
		}
		
		bos.flush();
		bis.close();
		bos.close();
		
		GroupAttachmentVo vo = new GroupAttachmentVo();
		vo.setChangeName(changeName);
		vo.setOriginName(originName);
		vo.setFilePath(filePath);
		
		return vo;
	}

}
