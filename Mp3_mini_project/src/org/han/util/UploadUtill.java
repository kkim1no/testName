package org.han.util;

import java.io.File;
import java.util.UUID;

import javax.servlet.http.Part;

public class UploadUtill {
   
   public static String upload(Part part, String saveDir) throws Exception {
      
      String contentDisp = part.getHeader("content-disposition");
      
        String[] items = contentDisp.split(";");

        String fileName = UUID.randomUUID().toString();
        
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                fileName += "_" + s.substring(s.indexOf("=") + 2, s.length()-1);
            }
        }
        
        part.write(saveDir + File.separator + fileName);
      
      return fileName;
   }

}