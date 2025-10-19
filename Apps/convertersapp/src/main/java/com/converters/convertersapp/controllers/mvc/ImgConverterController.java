package com.converters.convertersapp.controllers.mvc;

import com.converters.convertersapp.services.mvc.ImgConverterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ImgConverterController {

    @Autowired
    private ImgConverterService imageConverterService;

    @GetMapping("/")
    public String homepage() {
        return "index";
    }

    @GetMapping("/home")
    public ModelAndView imagePage() {
        ModelAndView view = new ModelAndView();
        view.setViewName("home");
        return view;
    }

    @PostMapping("/convert")
    public String convertImage(@RequestParam("file") MultipartFile file,
                               @RequestParam("format") String format,
                               @RequestParam(value = "language", required = false) String language,
                               RedirectAttributes redirectAttributes,
                               Model model) {

            String base64Image = imageConverterService.convert(file, format, redirectAttributes);
            model.addAttribute("base64Image", base64Image);
            model.addAttribute("message", "Image converted successfully!");
            model.addAttribute("convertedFormat", format);

        return "home";
    }












   /* @PostMapping("/convert")
    public String convertImage(@RequestParam("file") MultipartFile file,
                               @RequestParam("format") String format,
                               RedirectAttributes redirectAttributes,
                               Model model) {
        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload.");
            return "redirect:/";
        }

        try {
            // Read the image from the uploaded file
            BufferedImage originalImage = ImageIO.read(file.getInputStream());

            // Write the image to a ByteArrayOutputStream in the desired format
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(originalImage, format.toLowerCase(), baos);
            byte[] convertedImageBytes = baos.toByteArray();

            // Encode the converted image to a Base64 string for display
            String base64Image = Base64.getEncoder().encodeToString(convertedImageBytes);
            model.addAttribute("base64Image", base64Image);
            model.addAttribute("message", "Image converted successfully!");
            model.addAttribute("convertedFormat", format);

        } catch (IOException e) {
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("message", "Error converting image.");
            return "redirect:/";
        }
        return "index";
    }*/
}