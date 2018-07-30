package com.purchase.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.purchase.util.GlobalUtil;
import com.purchase.util.ResultUtil;

@Controller
@RequestMapping("pic")
public class PictureController {

	@RequestMapping(value = "/upload", produces = MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8")
	@ResponseBody
	public ResultUtil uploadFile(MultipartFile file, HttpServletRequest req) {
		if (file == null) {
			return ResultUtil.error("文件不能为空！");
		}
		String fileSub = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."))
				.toLowerCase();
		if (".jpg".equals(fileSub) || ".jpeg".equals(fileSub) || ".png".equals(fileSub) || ".gif".equals(fileSub)) {
			Random d = new Random();
			String img = UUID.randomUUID().toString().replace("-", "") + d.nextInt(10000) + "" + fileSub;
			try {
				// uploadFile.transferTo(new
				// File(req.getServletContext().getRealPath("WEB-INF/upload"),img));
				file.transferTo(new File(GlobalUtil.getValue("upfile.path"), img));
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			Map<String, String> map = new HashMap<>();
			map.put("src", GlobalUtil.getValue("upfile.code") + img);
			return ResultUtil.ok(map);
		} else {
			return ResultUtil.error("文件格式不支持,请重新选择！");
		}
	}

	/**
	 * 本地图片回显
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/showPic")
	@ResponseBody
	public String showPic(String fileName, HttpServletResponse response) {
		// String fileName="4d857472b93b4b9bb04d65f1506b2a329707.jpeg";
		FileInputStream fis = null;
		OutputStream os = null;
		try {
			//图片的本地全路径
			fis = new FileInputStream("d:/upload/" + fileName);
			os = response.getOutputStream();
			int count = 0;
			byte[] buffer = new byte[1024 * 8];
			while ((count = fis.read(buffer)) != -1) {
				os.write(buffer, 0, count);
				os.flush();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			fis.close();
			os.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "ok";
	}
}
