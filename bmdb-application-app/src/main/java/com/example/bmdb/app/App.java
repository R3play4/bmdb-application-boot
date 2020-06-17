package com.example.bmdb.app;

import com.example.bmdb.config.AppConfig;
import com.example.bmdb.config.RepositoryConfig;
import com.example.bmdb.domain.*;
import com.example.bmdb.domain.builders.ReviewBuilder;
import com.example.bmdb.service.Service;
import com.example.bmdb.view.View;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import javax.transaction.Transactional;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Transactional
public class App {
    private static final Logger logger = LogManager.getLogger(App.class);

    private View view;
    private Service service;

    public App(Service service, View view) {
        this.service = service;
        this.view = view;
        // GenerateTestData ?
    }

    public static void main(String[] args) {
        // With Spring
        try (ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class, RepositoryConfig.class )) {
            //configures logger
            App app = context.getBean(App.class);
            //app.testMsgSource();
            logger.info("App was started successfully");
            app.initDatabase();
            logger.info("Test data was loaded to database successfully");
            app.play();
        }
    }

    public void initDatabase() {
        this.service.loadTestDataToDatabase();
    }

    public void play() {
        createUser();
        this.view.printWelcomeMessage(this.service.findUser());
        this.view.setMedias(this.service.findAllMedia());
        this.view.printMedias();
        this.doReview();

        while (this.quit()) {
            this.view.printMedias();
            this.doReview();
        }
    }

    private void createUser() {
        User newUser = this.view.readUserData();
        this.service.saveUser(newUser);
    }

    private void doReview() {

        // Selects Movie
        Media selectedMedia = this.selectMedia();

        while(selectedMedia == null){
            System.out.println("Invalid. selection, please pick again!");
            selectedMedia = this.selectMedia();
        }

        // Creates Review
        Review review = new ReviewBuilder()
                .setCreator(this.service.findUser())
                .setText(this.writeReview())
                .setMedia(selectedMedia)
                .setRating(this.selectRating())
                .buildReview();

        // Adds review to user, and Media
        //selectedMedia.addReview(review);
        this.service.findUser().addReview(review);
        this.service.saveReview(selectedMedia, review);
    }

    private Media selectMedia() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Choose and id!");
        try {
            int index = Integer.parseInt(reader.readLine());
            System.out.println("Selected movie: " + service.findAllMedia().get(index - 1).getTitle());
            return this.service.findAllMedia().get(index - 1);
        } catch (IOException | IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    private String writeReview() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Write a review!");
        try {
            String review = reader.readLine();
            return review;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    private Rating selectRating() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Choose a rating! (good, average, bad)");
        try {
            String rating = reader.readLine();

            while (!this.validRating(rating)) {
                System.out.println("Invalid rating. Choose one from: good, average, bad");
                rating = reader.readLine();
            }

            return Rating.valueOf(rating.toUpperCase());
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    private boolean validRating(String rating) {
        if (rating.toUpperCase().equals("GOOD") || rating.toUpperCase().equals("AVERAGE") || rating.toUpperCase().equals("BAD")) {
            return true;
        }
        return false;
    }

    private boolean quit() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Do you want to write another review? (Type 'yes' or 'no')");

        try {
            String command = reader.readLine();

            while (!validCommand(command)) {
                System.out.println("Invalid command. Type 'yes' or 'no'");
                command = reader.readLine();
            }

            if (command.toLowerCase().equals("yes")) {
                return true;
            } else {
                return false;
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    private boolean validCommand(String command) {
        if (command.toLowerCase().equals("no") || command.toLowerCase().equals("yes")) {
            return true;
        }
        return false;
    }
}
