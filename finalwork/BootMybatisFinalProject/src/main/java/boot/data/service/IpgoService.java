package boot.data.service;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import boot.data.dto.IpgoDto;
import boot.data.mapper.IpgoMapperInter;
import jakarta.servlet.http.HttpSession;

@Service
public class IpgoService {

	@Autowired
	IpgoMapperInter inter;
	
    //총 함계
	public int getTotalCount() {
		return inter.getTotalCount();
	}
	
	//insert
	public void insertIpgo(IpgoDto dto,ArrayList<MultipartFile> upload,HttpSession session) {
		
		String realPath=session.getServletContext().getRealPath("/ipgosave");
		System.out.println(realPath);
		
		String uploadName="";
		if(upload.get(0).getOriginalFilename().equals("")) {
			uploadName="no";
		}else {
			for(MultipartFile f:upload) {
				SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
				String fName=sdf.format(new Date())+"_"+f.getOriginalFilename();
				uploadName+=fName+",";
				
				//업로드
				try {
					f.transferTo(new File(realPath+"\\"+fName));
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			//마지막 ,제거
			uploadName=uploadName.substring(0, uploadName.length()-1);
		}
		
		//dto에 uploadNmae 담기
		dto.setPhotoname(uploadName);
		inter.insertIpgo(dto);
	}
	
	//모든 데이터 출력(list)
	public List<IpgoDto> getAllSangpums(){
		return inter.getAllSangpums();
	}
}
