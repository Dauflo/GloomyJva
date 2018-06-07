package com.gloomy.util;

public class ContentType  {

    public static String getContentTypeWithExtension(String extension) {
        switch (extension){
            case "txt":
                extension = "text/plain";
                break;
            case "mp4":
                extension = "video/mp4";
                break;
            case "gif":
                extension = "image/gif";
                break;
            case "pdf":
                extension = "application/pdf";
                break;
            case "pptx":
                extension = "application/vnd.openxmlformats-officedocument.presentationml.presentation";
                break;
            case "docx":
                extension = "application/vnd.openxmlformats-officedocument.wordprocessingml.document";
                break;
        }
        return extension;
    }

}