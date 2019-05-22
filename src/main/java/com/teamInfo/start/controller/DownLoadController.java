package com.teamInfo.start.controller;

import com.teamInfo.start.utils.RedisOperating;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Enumeration;

/**
 * @author jijngbao
 * @date 19-3-8
 */
@Controller
public class DownLoadController {
    @ResponseBody
    @RequestMapping(value = "/download")
    public void downLoad(HttpServletRequest request, HttpServletResponse response
            ) throws IOException {


        String fileName=request.getParameter("fileName");
        response.setHeader("content-type", "application/octet-stream");
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
        downLoad("/home/jingbao/文档/doc/"+fileName+".doc",response);
    }

    private void downLoad(String fileName,HttpServletResponse res) throws
            IOException {
        System.out.println("down");
        File file=new File(fileName);
        FileChannel input=new FileInputStream(file).getChannel();
        ByteBuffer buff=ByteBuffer.allocate(1024);
        buff.clear();
        int length=-1;
        while ((length = input.read(buff)) != -1){
            buff.flip();
            byte[] temp=buff.array();
            res.getOutputStream().write(temp,0,length);
            res.getOutputStream().flush();;

        }
        System.out.println("success");
    }

    @RequestMapping("/upLoad")
//    @ResponseBody
    public String fileUpload(@RequestParam("fileName") MultipartFile file,
                             HttpServletRequest request){
        System.out.println(request.getContentLength());
        if(file.isEmpty()){
            System.out.println("file.isEmpty");
            return "/error";
        }
        String fileName = file.getOriginalFilename();
        int size = (int) file.getSize();
        System.out.println(fileName + "-->" + size);

        String path = "/home/jingbao/文档/上传" ;
        File dest = new File(path + "/" + fileName);
        if(!dest.getParentFile().exists()){ //判断文件父目录是否存在
            dest.getParentFile().mkdir();
        }
        try {
            file.transferTo(dest); //保存文件
            return "/success";
        } catch (IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return "/error";
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return "/error";
        }
    }
}
