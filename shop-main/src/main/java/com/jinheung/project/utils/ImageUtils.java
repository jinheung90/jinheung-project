package com.jinheung.project.utils;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class ImageUtils {

    @Getter
    @Setter
    public static class Size {
        private Integer width;
        private Integer height;
        public Size(Integer width, Integer height) {
            this.width = width;
            this.height = height;
        }
    }

    public static String getExtensionFromContentType(String contentType) {
        return contentType.substring(contentType.lastIndexOf("/") + 1);
    }

    public static Integer getSmallSideSizeOfMultipartFile(MultipartFile file) throws IOException {
        BufferedImage image = ImageIO.read(file.getInputStream());
        return Math.min(image.getWidth(), image.getHeight());
    }

    public static InputStream getInputStream(BufferedImage image, String imageType) throws IOException {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        ImageIO.write(image, imageType, os);
        return new ByteArrayInputStream(os.toByteArray());
    }

    public static Integer getSize(BufferedImage image, String imageType) throws IOException {
        ByteArrayOutputStream tmp = new ByteArrayOutputStream();
        ImageIO.write(image, imageType, tmp);
        tmp.close();
        return tmp.size();
    }

    public static Size getSizeByRatioAndSmallSideSize(BufferedImage image, Integer smallSideSize)
        throws IOException {
        Size size = new Size(0, 0);
        float width = image.getWidth();
        float height = image.getHeight();
        float standard = smallSideSize;
        if (width <= 0 || height <= 0) throw new IOException("ERR_MULTIPART_FILE_SIZE");
        float ratio = height / width;
        if (width > height) {
            size.setWidth(Math.round(standard / ratio));
            size.setHeight(Math.round(standard));
        } else {
            size.setWidth(Math.round(standard));
            size.setHeight(Math.round(standard * ratio));
        }
        return size;
    }

    public static BufferedImage resizeMultipartFileAndReturnBufferedImage(MultipartFile multipartFile, Integer smallSideSize)
        throws IOException {
        BufferedImage imageSrc = ImageIO.read(multipartFile.getInputStream());
        Size sizeTo = getSizeByRatioAndSmallSideSize(imageSrc, smallSideSize);
        BufferedImage outputImage = new BufferedImage(sizeTo.getWidth(), sizeTo.getHeight(), imageSrc.getType());
        Graphics2D graphics2D = outputImage.createGraphics();
        graphics2D.drawImage(imageSrc, 0, 0, sizeTo.getWidth(), sizeTo.getHeight(), null);
        graphics2D.dispose();
        return outputImage;
    }

//    public static MultipartFile resizeMultipartFileImage(
//        MultipartFile multipartFile,
//        Integer smallSideSize,
//        String resizedFileName
//    ) throws IOException, InterruptedException {
//        String type = multipartFile.getContentType();
//        if (type == null) throw new IOException("ERR_MULTIPART_RESIZE_INVALID_CONTENT_TYPE");
//        String ext = type.substring(type.lastIndexOf("/") + 1);
//        if (smallSideSize <= 0) throw new IOException("ERR_MULTIPART_RESIZE_ARG");
//        BufferedImage imageSrc;
//        imageSrc = ImageIO.read(multipartFile.getInputStream());
////        if (ext.equalsIgnoreCase("jpeg") || ext.equalsIgnoreCase("jpg")) {
//////            imageSrc = new ImageIcon(multipartFile.getInputStream()).getImage();
////        } else if (ext.equalsIgnoreCase("png")) {
////            imageSrc = ImageIO.read(multipartFile.getInputStream());
////        } else {
////            throw new IOException("ERR_MULTIPART_RESIZE_INVALID_CONTENT_IMAGE_TYPE");
////        }
//        int width = imageSrc.getWidth();
//        int height = imageSrc.getHeight();
//        if (width <= 0 || height <= 0) {
//            throw new IOException("ERR_MULTIPART_FILE_SIZE");
//        }
//        int ratio = height / width;
//        int widthResized = 0;
//        int heightResized = 0;
//        if (width > height) {
//            heightResized = smallSideSize;
//            widthResized = smallSideSize / ratio;
//        } else {
//            heightResized = smallSideSize * ratio;
//            widthResized = smallSideSize;
//        }
//        Image imageTarget = imageSrc.getScaledInstance(widthResized, heightResized, Image.SCALE_SMOOTH);
//        int pixels[] = new int[widthResized * heightResized];
//        PixelGrabber pg = new PixelGrabber(imageSrc, 0, 0, widthResized, heightResized, pixels, 0, widthResized);
//        try {
//            pg.grabPixels();
//        } catch (Exception e) {
//            throw new IOException(e.getMessage());
//        }
//        BufferedImage imageResized = new BufferedImage(widthResized, heightResized, BufferedImage.TYPE_INT_RGB);
//        imageResized.setRGB(0, 0, widthResized, heightResized, pixels, 0, widthResized);
//        return new MockMultipartFile(
//            resizedFileName,
//            multipartFile.getOriginalFilename(),
//            multipartFile.getContentType(),
//            ImageIO.read(ImageUtils.getInputStream(imageResized)));
//    }

}
