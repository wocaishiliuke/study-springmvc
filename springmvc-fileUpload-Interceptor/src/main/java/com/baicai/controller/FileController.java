package com.baicai.controller;

import com.baicai.pojo.User;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping(value = "/file")
public class FileController {

    /**
     * 上传页路由
     */
    @RequestMapping(value = "/upload", method = RequestMethod.GET)
    public String upload() {
        return "fileUpload/upload";
    }

    @RequestMapping(value = "/uploadServlet", method = RequestMethod.GET)
    public String uploadServlet() {
        return "fileUpload/uploadServlet";
    }

    /**
     * 文件上传
     * @param request
     //* @param user
     * @param model
     * @return
     * @throws IOException
     */
//    @RequestMapping(value = "/upload", method = RequestMethod.POST)
//    public String upload(HttpServletRequest request
//                         ,/*@ModelAttribute*/ User user
//                         ///*,@RequestParam("username")*/ String username
//                         ///*,@RequestParam("avatar")*/ MultipartFile avatar
//                         , Model model) throws IOException {
//        String username = user.getUsername();
//        MultipartFile avatar = user.getAvatar();
//        System.out.println(username);
//        if (!avatar.isEmpty()) {
//            // .../springmvc-fileUpload-Interceptor/target/springmvc-fileUpload-Interceptor/images/
//            String path = request.getServletContext().getRealPath("/images/");
//            String fileName = avatar.getOriginalFilename();
//            File filePath = new File(path, fileName);
//            // 判断路径是否存在，不存在就创建
//            if (!filePath.getParentFile().exists()) {
//                filePath.getParentFile().mkdirs();
//            }
//            avatar.transferTo(new File(path + File.separator + fileName));
//            //return "fileUpload/success";
//            //跳转到下载页
//            model.addAttribute("user", user);
//            return "fileUpload/userInfo";
//        }else {
//            return "fileUpload/error";
//        }
//    }

//    @RequestMapping(value = "/upload", method = RequestMethod.POST)
//    public String upload(HttpServletRequest request
//                         ,/*@RequestParam("username")*/ String username
//                         ,/*@RequestParam("avatar")*/ /*@RequestPart*/ Part avatar
//            , Model model) throws IOException, ServletException {
//        System.out.println(username);
//        //Part avatar = request.getPart("avatar");
//        if (avatar != null) {
//            // .../springmvc-fileUpload-Interceptor/target/springmvc-fileUpload-Interceptor/images/
//            String path = request.getServletContext().getRealPath("/images/");
//            String fileName = avatar.getSubmittedFileName();
//            File filePath = new File(path, fileName);
//            // 判断路径是否存在，不存在就创建
//            if (!filePath.getParentFile().exists()) {
//                filePath.getParentFile().mkdirs();
//            }
//            avatar.write(new File(path + File.separator + fileName).toString());
//            //return "fileUpload/success";
//            //跳转到下载页
//            User user = new User(username, null, null);
//            model.addAttribute("user", user);
//            return "fileUpload/userInfo";
//        }else {
//            return "fileUpload/error";
//        }
//    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String upload(HttpServletRequest request
            ,/*@RequestParam("username")*/ String username
            ,/*@RequestParam("avatar")*/ /*@RequestPart*/ MultipartFile avatar
            , Model model) throws IOException, ServletException {
        System.out.println(username);
        //Part avatar = request.getPart("avatar");
        if (avatar != null) {
            // .../springmvc-fileUpload-Interceptor/target/springmvc-fileUpload-Interceptor/images/
            String path = request.getServletContext().getRealPath("/images/");
            String fileName = avatar.getOriginalFilename();
            File filePath = new File(path, fileName);
            // 判断路径是否存在，不存在就创建
            if (!filePath.getParentFile().exists()) {
                filePath.getParentFile().mkdirs();
            }
            avatar.transferTo(new File(path + File.separator + fileName));
            //return "fileUpload/success";
            //跳转到下载页
            User user = new User(username, null, null);
            model.addAttribute("user", user);
            return "fileUpload/userInfo";
        }else {
            return "fileUpload/error";
        }
    }

    /**
     * 文件下载
     * @param request
     * @param avatarName
     * @param model
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/download", method = RequestMethod.GET)
    public ResponseEntity<byte[]> download(HttpServletRequest request
            , @RequestParam("avatarName") String avatarName, Model model) throws IOException {
        String path = request.getServletContext().getRealPath("/images/");
        File file = new File(path + File.separator + avatarName);
        HttpHeaders headers = new HttpHeaders();
        //下载显式的文件名，并解决中文乱码
        String downloadFileName = new String(avatarName.getBytes("UTF-8"), "ISO-8859-1");
        //通知浏览器以attachment（下载方式）打开图片
        headers.setContentDispositionFormData("attachment", downloadFileName);
        //application/octet-stream：二进制数据流（最常见的文件下载）
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        return new ResponseEntity<byte[]>(null/*FileUtils.readFileToByteArray(file)*/, headers, HttpStatus.CREATED);
    }
}
