package com.prj.web.controller;


import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/*")
public class HomeController {

	@RequestMapping("index")
	public String index() {
		return "home.index";
	}

	@RequestMapping(value="login", method=RequestMethod.GET)
	public String login() {
		return "home.login";
	}
	
	@RequestMapping("upload")
	@ResponseBody
	public String upload() {
		return "hi";
		
	}
	
/*
	@Controller 
	@RequestMapping(value = "daumOpenEditor") 
	public class DaumOpenEditorController {
	
		
		
		// �̹��� ÷�� �˾� 
		@RequestMapping(value = "/imagePopup") 
		public String imagePopup() { 
			System.out.println("�̹����˾�");
			return "daumOpenEditor/image.jsp"; 
			} 
			
		
		//���� ���� ���ε� Ajax 
		@RequestMapping(value = "/singleUploadImageAjax", method = RequestMethod.POST) 
		public @ResponseBody HashMap singleUploadImageAjax(@RequestParam("Filedata") MultipartFile multipartFile, HttpSession httpSession) { 
			HashMap fileInfo = new HashMap(); // CallBack�� �� �̹��� ������ ���� Map 
			// ���ε� ������ �����ϸ� 
			if(multipartFile != null && !(multipartFile.getOriginalFilename().equals(""))) {
		// Ȯ���� ����
				String originalName = multipartFile.getOriginalFilename(); // ���� ���ϸ� 
				String originalNameExtension = originalName.substring(originalName.lastIndexOf(".") + 1).toLowerCase(); // �������� Ȯ���� (�ҹ��ں���) 
				if( !( (originalNameExtension.equals("jpg")) || (originalNameExtension.equals("gif")) || (originalNameExtension.equals("png")) || (originalNameExtension.equals("bmp")) ) ){ fileInfo.put("result", -1); // ��� Ȯ���ڰ� �ƴ� ��� 
				return fileInfo; } // ����ũ������ (1MB) 
				long filesize = multipartFile.getSize(); // ����ũ�� 
				long limitFileSize = 1*1024*1024; // 1MB 
				if(limitFileSize < filesize){ // ���Ѻ��� ����ũ�Ⱑ Ŭ ��� 
					fileInfo.put("result", -2); return fileInfo; } // ������ 
				String defaultPath = httpSession.getServletContext().getRealPath("/"); // �����⺻��� (������Ʈ ���� �ƴ�) 
				String path = defaultPath + File.separator + "upload" + File.separator + "board" + File.separator + "images" + File.separator + ""; // ������ ó�� 
				File file = new File(path); if(!file.exists()) { // ���丮 �������� ������� ���丮 ���� 
					file.mkdirs(); } // ���� ����� ó�� (20150702091941-fd8-db619e6040d5.Ȯ����) 
				SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss"); String today= formatter.format(new Date()); String modifyName = today + "-" + UUID.randomUUID().toString().substring(20) + "." + originalNameExtension; // Multipart ó�� 
				try { // ������ ���� ���� (����) 
					multipartFile.transferTo(new File(path + modifyName)); // �α� 
					System.out.println("** upload ���� **"); System.out.println("** path : " + path + " **"); System.out.println("** originalName : " + originalName + " **"); System.out.println("** modifyName : " + modifyName + " **"); } catch (Exception e) { e.printStackTrace(); System.out.println("�̹������Ͼ��ε� ���� - singleUploadImageAjax"); } // CallBack - Map�� ��� 
				String imageurl = httpSession.getServletContext().getContextPath() + "/upload/board/images/" + modifyName; // separator�ʹ� �ٸ�! 
				fileInfo.put("imageurl", imageurl); // ������ϰ��(�����ȯ�̳� ������ ����) 
				fileInfo.put("filename", modifyName); // ���ϸ� 
				fileInfo.put("filesize", filesize); // ���ϻ����� 
				fileInfo.put("imagealign", "C"); // �̹�������(C:center) 
				fileInfo.put("originalurl", imageurl); // �������ϰ�� 
				fileInfo.put("thumburl", imageurl); // ��������ϰ��(�����ȯ�̳� ������ ����) 
				fileInfo.put("result", 1); // -1, -2�� ������ �ƹ��ų� �ƾ �� 
				} return fileInfo; // @ResponseBody ������̼��� ����Ͽ� Map�� JSON���·� ��ȯ 
				}
				
		
	
			}


	*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

		/*
	@RequestMapping("upload")
	@ResponseBody
	public String upload(String title, MultipartFile file, HttpServletRequest request) throws IOException {

		System.out.println(title);
		System.out.println(file.getOriginalFilename());

		ServletContext ctx = request.getServletContext();
		String path = ctx.getRealPath("/resource/upload");

		path += File.separator + file.getOriginalFilename();
		File f2 = new File(path);

		InputStream fis = file.getInputStream();
		OutputStream fos = new FileOutputStream(f2);

		byte[] buf = new byte[1024];

		int size = 0;
		while ((size = fis.read(buf)) > 0)
			fos.write(buf, 0, size);

		System.out.println(path);
		fos.close();
		fis.close();

		return title;

	}

	@RequestMapping("file-list")
	@ResponseBody
	public String fileList(HttpServletRequest request){

		ServletContext ctx = request.getServletContext();
		String path = ctx.getRealPath("/resource/upload");

		StringBuilder json = new StringBuilder();
		json.append("[");

		File folder = new File(path);

		if(folder.isDirectory()) {
			int i;
			File[] files = folder.listFiles();

			for(i = 0; i<files.length; i++) {
				json.append(String.format("\"%s\"", files[i].getName()));
				if(i+1 < files.length)
					json.append(",");
			}
		}

		json.append("]");

		System.out.println(json);

		return json.toString();
	}*/
	
