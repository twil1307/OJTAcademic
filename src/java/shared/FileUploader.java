/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shared;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.Part;



public class FileUploader {
    
    public static void uploadImages(List<Part> imageParts, String subName, String path) {
        
        imageParts.stream().forEach(part -> {
            String fileName;
            
            if (subName != null) {
                fileName = path + File.separator + subName + part.getSubmittedFileName();
            } else {
                fileName = path + File.separator + part.getSubmittedFileName();
            }
            
            System.out.println(fileName);
            try {
                part.write(fileName);
            } catch (IOException ex) {
                Logger.getLogger(FileUploader.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
}
