package com.example.bmdb.view;

//import com.example.bmdb.config.MessageConfig;

import com.example.bmdb.domain.Actor;
import com.example.bmdb.domain.Media;
import com.example.bmdb.domain.Review;
import com.example.bmdb.domain.User;
import com.example.bmdb.domain.builders.UserBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Locale;

@Component
public class View {


    //@Value("${default.language}")
    @Value("en")
    private Locale locale;

    @Autowired
    MessageSource messageSource;

    private List<Media> medias;
    private String sayHello;
    private String greetings;

    public String getSayHello() {
        return this.sayHello;
    }

    public String getGreetings() {
        return this.greetings;
    }

    public void setSayHello(String sayHello) {
        this.sayHello = sayHello;
    }

    public void setGreetings(String greetings) {
        this.greetings = greetings;
    }

    public List<Media> getMedias() {
        return medias;
    }

    public void setMedias(List<Media> medias) {
        this.medias = medias;
    }

    public User readUserData() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        UserBuilder builder = new UserBuilder();

        try {

            System.out.println("What is your name?");
            String name = reader.readLine();

            System.out.println("What is your email?");
            String email = reader.readLine();

            System.out.println("Set a secure password !");
            String password = reader.readLine();


            return builder
                    .setName(name)
                    .setEmail(email)
                    .setPassWord(password)
                    .buildUser();

        } catch (IOException e) {
            System.out.println("Invalid User Data");
            return null;
        }
    }

    public void printWelcomeMessage(User user) {
        String hello = messageSource.getMessage("msg.hello", null, locale);
        String greetings = messageSource.getMessage("msg.greetings", null, locale);
        System.out.println(hello + " " + user.getName() + " " + greetings);
    }

    //
    public void printMedias() {
        for (Media media : this.medias) {
            System.out.println(media.getId() + ":'" + media.getTitle() + "'");
            System.out.println("Description:='" + media.getDescription() + "'");
            System.out.println("Preimer:=" + media.getPremier());

            // print Cast
            List<Actor> cast = media.getCast();

            System.out.println("Cast=[");
            for (Actor actor : cast) {
                printActorData(actor);
                if (cast.indexOf(actor) != cast.size() - 1) {
                    System.out.println(",");
                } else {
                    System.out.println("\n]");
                }
            }

            // print Reviews
            List<Review> reviews = media.getReviews();
            System.out.println("Reviews=[");
            for (int i = 0; i < reviews.size(); i++) {
                System.out.print("\t");
                System.out.print((i + 1) + ":");
                printReviewData(reviews.get(i));

                if (i != reviews.size() - 1) {
                    System.out.println(',');
                } else {
                    System.out.println("\n]");
                }
            }
        }
    }

    private void printActorData(Actor actor) {
        System.out.print("\tname= " + actor.getName() + ", born=" + actor.getBorn());
    }

    private void printReviewData(Review review) {
        System.out.print(review.getText() + " rating=" + review.getRating());
    }
}
