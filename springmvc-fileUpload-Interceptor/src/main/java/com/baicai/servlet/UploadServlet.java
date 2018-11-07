package com.baicai.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;

@MultipartConfig(location = "/tmp",
        maxFileSize = 1 * 1024,
        maxRequestSize = 10 * 1024 * 1024,
        fileSizeThreshold = 0)
@WebServlet(name = "uploadServlet", urlPatterns = "/uploadServlet", loadOnStartup = 1)
public class UploadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        Part part = request.getPart("avatar");
        if (part != null) {
            // 存储路径
            String path = request.getServletContext().getRealPath("/images/");
            String fileName = part.getSubmittedFileName();
            File filePath = new File(path, fileName);
            // 判断路径是否存在，不存在就创建
            if (!filePath.getParentFile().exists()) {
                filePath.getParentFile().mkdirs();
            }
            part.write(new File(path + File.separator + fileName).toString());
            response.getWriter().println("上传成功！");
            //跳转到下载页
        }else {
            response.getWriter().println("上传失败！");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
