/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shared;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.Part;



public class FileUploader {
    
    public static List<String> uploadImages(List<Part> imageParts, String subName, String path, String folder) {
        List<String> imageWithPaths = new ArrayList<>();
        
        imageParts.stream().forEach(part -> {
            String submittedFileName = part.getSubmittedFileName();
            String fileName;
            
            if (subName != null) {
                fileName = folder + File.separator + subName + submittedFileName; 
            } else {
                fileName = folder + File.separator + submittedFileName;
            }
            
           imageWithPaths.add(fileName);
            
            System.out.println(fileName);
            try {
                part.write(path + File.separator + fileName);
            } catch (IOException ex) {
                Logger.getLogger(FileUploader.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        return imageWithPaths;
    }
    
    
}
