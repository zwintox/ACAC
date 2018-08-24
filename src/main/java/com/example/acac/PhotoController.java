package com.example.acac;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;


@Controller
public class PhotoController {
    @Autowired
    private PhotoRepository photoRepository;

    private static final Logger logger =  LoggerFactory
            .getLogger(PhotoController.class);

    /**
     * Upload single file using Spring Controller
     */


    /**
     * Upload multiple file using Spring Controller
     */
  /*  @RequestMapping(value = "/uploadMultipleFile", method = RequestMethod.POST)
    public @ResponseBody
    String uploadMultipleFileHandler(@RequestParam("name") String[] names,
                                     @RequestParam("file") MultipartFile[] files,
                                     HttpServletRequest request) {
        System.out.println("HEEEJ");
        HttpSession session = request.getSession(false);
        if(session !=null){

        if (files.length != names.length)
            return "Mandatory information missing";

        String message = "";
        for (int i = 0; i < files.length; i++) {
            MultipartFile file = files[i];
            String name = names[i];
            try {
                byte[] bytes = file.getBytes();

                // Creating the directory to store file
                String workingDir = System.getProperty("user.dir");

                System.out.format("Working Dir: %s", workingDir);
                String rootPath = System.getProperty("catalina.home");
                File dir = new File(workingDir + File.separator + "src" + File.separator + "main" + File.separator + "images" + File.separator + "tmpFiles" + File.separator + session.getId());
                if (!dir.exists())
                    dir.mkdirs();

                // Create the file on server
                File serverFile = new File(dir.getAbsolutePath()
                        + File.separator + name);
                BufferedOutputStream stream = new BufferedOutputStream(
                        new FileOutputStream(serverFile));
                stream.write(bytes);
                stream.close();

                logger.info("Server File Location=" + serverFile.getAbsolutePath());

                message = message + "You successfully uploaded file=" + name
                        + "<br />";
            } catch (Exception e) {
                return "You failed to upload " + name + " => " + e.getMessage();
            }
            return message;
        }

        }
        return "index";

        }

*/





  /*
    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    public @ResponseBody
    String uploadFileHandler(@RequestParam("name") String name,
                             @RequestParam("file")
                                     MultipartFile file,
                            HttpServletRequest request) {

        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();

                // Creating the directory to store file
               // String rootPath = System.getProperty("catalina.home");
                String workingDir = System.getProperty("user.dir");

                System.out.format("Working Dir: %s", workingDir);

                File dir = new File( workingDir + File.separator + "tmpFiles");
                if (!dir.exists())
                    dir.mkdirs();

                // Create the file on server
                File serverFile = new File( workingDir + File.separator + name);
                BufferedOutputStream stream = new BufferedOutputStream(
                        new FileOutputStream(serverFile));
                stream.write(bytes);
                stream.close();

                logger.info("Server File Location="
                        + serverFile.getAbsolutePath());

                return "You successfully uploaded file=" + name;
            } catch (Exception e) {
                return "You failed to upload " + name + " => " + e.getMessage();
            }
        } else {
            return "You failed to upload " + name
                    + " because the file was empty.";
        }
    }
*/
}