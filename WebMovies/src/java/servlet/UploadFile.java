/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author Admin
 */
public class UploadFile {
    
    public static Map upload(HttpServletRequest request) {
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        if (isMultipart) {
            // Create a factory for disk-based file items
            FileItemFactory factory = new DiskFileItemFactory();

            // Create a new file upload handler
            ServletFileUpload upload = new ServletFileUpload(factory);

            Map map = new HashMap();
            try {
                // Parse the request
                List items = upload.parseRequest(request);
                Iterator iterator = items.iterator();
                
                while (iterator.hasNext()) {
                    FileItem item = (FileItem) iterator.next();
                    if (!item.isFormField()) {
                        String fileName = item.getName();

                        String root = request.getServletContext().getRealPath("/");                        
                        String dir = root.replaceAll("\\\\build", "") + "/images/movie";

                        File folder = new File(dir);
                        if (!folder.exists()) {
                            folder.mkdir();
                        }
                        String path = null;
                        if (fileName != null) {

                            path = folder + File.separator + fileName;
                            
                        } else {
                            path = folder + File.separator + "default.png";
                        }

                        File uploadedFile = new File(path);
                        if (!uploadedFile.exists()) {
                            item.write(uploadedFile);
                        }
                        
                        map.put("imgPath", path);                        
                    } else {                        
                         map.put(item.getFieldName(), item.getString());                        
                    }
                }
                return map;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
