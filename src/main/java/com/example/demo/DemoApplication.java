package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.FileCopyUtils;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    @Autowired
    FilesRepository fileRepository;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... arg0) throws Exception {
        /*
         *  images
         */
//        ClassPathResource jsaCoverImgFile = new ClassPathResource("files/jsa-cover.png");
//        byte[] arrayData = new byte[(int) jsaCoverImgFile.contentLength()];
//        jsaCoverImgFile.getInputStream().read(arrayData);
//        FileModel coverModel = new FileModel(1, "JSA-Cover", "png", arrayData);
//
//        ClassPathResource jsaVisionImgFile = new ClassPathResource("files/jsa-vision.png");
//        arrayData = new byte[(int) jsaVisionImgFile.contentLength()];
//        jsaVisionImgFile.getInputStream().read(arrayData);
//        FileModel visionModel = new FileModel(2, "JSA-Vision", "png", arrayData);
//
//        // file .txt
//        ClassPathResource jsaAboutFile = new ClassPathResource("files/jsa-about.txt");
//        arrayData = new byte[(int) jsaAboutFile.contentLength()];
//        jsaAboutFile.getInputStream().read(arrayData);
//        FileModel aboutModel = new FileModel(3, "JSA-About", "txt", arrayData);
//
//
//        // store files to PostgreSQL via SpringJPA
//        fileRepository.saveAll(Arrays.asList(coverModel, visionModel, aboutModel));

        ClassPathResource docx = new ClassPathResource("files/l.pdf");
        byte[] arrayData2 =new byte[(int) docx.contentLength()];
        FileModel docModel = new FileModel(5, "l", "pdf", arrayData2 );
        fileRepository.save(docModel);


        // retrieve image from PostgreSQL via SpringJPA
        for(FileModel imageModel : fileRepository.findAll()){
            Files.write(Paths.get(  "download/" + imageModel.getName() + "." + imageModel.getType()), imageModel.getPic());
//            FileCopyUtils.copy()
        }
    }
}
