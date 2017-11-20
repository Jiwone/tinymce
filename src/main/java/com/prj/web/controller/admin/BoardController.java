package com.prj.web.controller.admin;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.prj.web.entity.Free;
import com.prj.web.entity.Info;
import com.prj.web.service.admin.BoardService;

@Controller
@RequestMapping("/admin/board/*")
public class BoardController {

	@Autowired
	private BoardService service;
	
	@RequestMapping("free")
	public String advice(@RequestParam(value = "p", defaultValue = "1") int page, Model model) {
		List<Free> list = service.getFreeList(page);
		System.out.println("나 프리");
		model.addAttribute("list", list);
		return "admin.board.free.image";
	}
	

	@RequestMapping("free/{id}")
	public String freeDetail(@PathVariable("id") String id, Model model) {

		model.addAttribute("f", service.getFree(id));
		model.addAttribute("prev", service.getFreePrev(id));
		model.addAttribute("next", service.getFreeNext(id));

		return "admin.board.notice.detail";
	}
	
	/*Info 泥ロ럹�씠吏�*/
	@RequestMapping("info")
	public String info(@RequestParam(value = "p", defaultValue = "1") int page, Model model) {
	
		  List<Info> listInfo = service.getInfoList(page);
          model.addAttribute("list", listInfo);
		
          return "admin.board.info.list";
		
	}

	
	/*info �뵒�뀒�씪*/
	@RequestMapping("info/{id}")
	public String infoDetail(@PathVariable("id") String id,Model model) {
	
		  model.addAttribute("n", service.getInfo(id));
	      model.addAttribute("prev", service.getInfoPrev(id));
	      model.addAttribute("next", service.getInfoNext(id));
	         
	      return "admin.board.info.detail";
	}
	
	/*info �벑濡�*/
	

    @RequestMapping(value="info/reg", method=RequestMethod.GET)
    public String noticeReg() {
       
       return "admin.board.info.reg";
    }
	@RequestMapping(value="info/reg", method=RequestMethod.POST)
	public String infoReg(Info info,MultipartFile file,HttpServletRequest request) throws IOException {

		System.out.println("content : "+info.getContent());
		int row = service.infoInsert(info);
		
		return "redirect:../info";
	
		
	}
	
	
	/*info �렪吏�*/
	@RequestMapping(value="info/{id}/edit",method=RequestMethod.POST)
	public String infoEdit(@PathVariable("id") String id,Info info) {
		int row =service.infoUpdate(id,info);
	return "redirect:../../info/{id}";	
	}
	
	@RequestMapping(value="info/{id}/edit",method=RequestMethod.GET)
	public String infoEdit(@PathVariable("id") String id,Model model) {
		model.addAttribute("up", service.getInfo(id));
		return "admin.board.info.edit";
		
	}

	
	
	
	
}



























