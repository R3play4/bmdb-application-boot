package com.example.bmdb.service;

import com.example.bmdb.domain.*;
import com.example.bmdb.domain.builders.ActorBuilder;
import com.example.bmdb.domain.builders.MediaBuilder;
import com.example.bmdb.domain.builders.ReviewBuilder;
import com.example.bmdb.domain.builders.UserBuilder;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Component
public class TestDataGenerator {

    public static List<Media> generateTestData() {

        List<Media> testData = new ArrayList<Media>();

        // formatter for premier dates and born dates
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/d");

        // Creating Actors

        Actor michaelJFox = new ActorBuilder()
                .setName("Michael J Fox")
                .setBorn(LocalDate.parse("1965/04/04", formatter))
                .setBiography("Lárifári klári")
                .setSex(Sex.MALE)
                .buildActor();

        Actor markHamil = new ActorBuilder()
                .setName("Mark Hamil")
                .setBorn(LocalDate.parse("1950/06/14", formatter))
                .setBiography("Just Luke Skywalker. Still with us")
                .setSex(Sex.MALE)
                .buildActor();

        Actor carrieFisher = new ActorBuilder()
                .setName("Carrie Fisher")
                .setBorn(LocalDate.parse("1954/12/06", formatter))
                .setBiography("Prince Leila mainly. Also a huge hippie")
                .setSex(Sex.FEMALE)
                .buildActor();

        Actor aaronPaul = new ActorBuilder()
                .setName("Aaron Paul")
                .setBorn(LocalDate.parse("1988/10/08", formatter))
                .setBiography("Known for: Science Bitch!, also Todd in Bojack Horseman")
                .setSex(Sex.MALE)
                .buildActor();

        Actor bryanCranston = new ActorBuilder()
                .setName("Bryan Cranston")
                .setBorn(LocalDate.parse("1968/11/11", formatter))
                .setBiography("Mr Walter White and usually the stereotipical good guy in other movies")
                .setSex(Sex.MALE)
                .buildActor();

        Actor kevinHart = new ActorBuilder()
                .setName("Kevin Hart")
                .setBorn(LocalDate.parse("1989/10/22", formatter))
                .setBiography("Big deal in small package")
                .setSex(Sex.MALE)
                .buildActor();

        Actor dwayneJohnson = new ActorBuilder()
                .setName("Dwayne Johnson")
                .setBorn(LocalDate.parse("1970/01/16", formatter))
                .setBiography("Big Guy with the funky eybrows")
                .setSex(Sex.MALE)
                .buildActor();

        Actor henryCavill = new ActorBuilder()
                .setName("Henry Cavill")
                .setBorn(LocalDate.parse("1982/08/12", formatter))
                .setBiography("Surprisingly good actor.")
                .setSex(Sex.MALE)
                .buildActor();

        Actor christianBale = new ActorBuilder()
                .setName("Christian Bale")
                .setBorn(LocalDate.parse("1972/03/10", formatter))
                .setBiography("Not just Batman. The Machinist was also great")
                .setSex(Sex.MALE)
                .buildActor();

        Actor garyOldman = new ActorBuilder()
                .setName("Gary Oldman")
                .setBorn(LocalDate.parse("1970/05/05", formatter))
                .setBiography("Yes he is an oldman, and a police officer in batman")
                .setSex(Sex.MALE)
                .buildActor();

        // Creating Media

        Movie starWars = new MediaBuilder()
                .setId(new BigDecimal(1))
                .setTitle("Star Wars")
                .setDescription("You should know it already")
                .setPremier(LocalDate.parse("1977/03/22", formatter))
                .addCast(markHamil)
                .addCast(carrieFisher)
                .buildMovie();

        carrieFisher.addFilm(starWars);
        markHamil.addFilm(starWars);

        Movie backToTheFuture = new MediaBuilder()
                .setId(new BigDecimal(2))
                .setTitle("Back To The Future")
                .setDescription("Confusing time travel saga")
                .setPremier(LocalDate.parse("1985/07/03", formatter))
                .addCast(michaelJFox)
                .buildMovie();

        michaelJFox.addFilm(backToTheFuture);

        Movie centralIntelligence = new MediaBuilder()
                .setId(new BigDecimal(3))
                .setTitle("Central Intelligence")
                .setDescription("You need to be drunk to enjoy this")
                .setPremier(LocalDate.parse("1988/06/02", formatter))
                .addCast(kevinHart)
                .addCast(dwayneJohnson)
                .buildMovie();

        kevinHart.addFilm(centralIntelligence);
        dwayneJohnson.addFilm(centralIntelligence);

        Series theWitcher = new MediaBuilder()
                .setId(new BigDecimal(4))
                .setTitle("The Witcher")
                .setDescription("Nerdy Gamer's delight")
                .setPremier(LocalDate.parse("2019/06/02", formatter))
                .addCast(henryCavill)
                .buildSeries();

        henryCavill.addFilm(theWitcher);

        Movie theDarkKnightRises = new MediaBuilder()
                .setId(new BigDecimal(5))
                .setTitle("Batman: The Dark Knight Rises")
                .setDescription("The most epic comic adaptaion ever")
                .setPremier(LocalDate.parse("2004/07/01", formatter))
                .addCast(garyOldman)
                .addCast(christianBale)
                .buildMovie();

        christianBale.addFilm(theDarkKnightRises);
        garyOldman.addFilm(theDarkKnightRises);

        Series breakingBad = new MediaBuilder()
                .setId(new BigDecimal(6))
                .setTitle("Breaking Bad")
                .setDescription("Slow and painfully realistic crime stroy")
                .setPremier(LocalDate.parse("2010/03/22", formatter))
                .addCast(bryanCranston)
                .addCast(aaronPaul)
                .buildSeries();

        bryanCranston.addFilm(breakingBad);
        aaronPaul.addFilm(breakingBad);

        Series bojackHorseman = new MediaBuilder()
                .setId(new BigDecimal(7))
                .setTitle("Bojack Horseman")
                .setDescription("Very deep but animated serries. Genius")
                .setPremier(LocalDate.parse("2014/04/22", formatter))
                .addCast(aaronPaul)
                .buildSeries();

        aaronPaul.addFilm(bojackHorseman);

        // Creating Users
        User user1 = new UserBuilder()
                .setName("Gipsz Jakab")
                .setEmail("gjacob@gmail.com")
                .setPassWord("Welcome123")
                .buildUser();

        User user2 = new UserBuilder()
                .setName("Sarah Ferrari")
                .setEmail("ferrari@gmail.com")
                .setPassWord("tplink123")
                .buildUser();

        User user3 = new UserBuilder()
                .setName("Paul Pierce")
                .setEmail("pauly@gmail.com")
                .setPassWord("Lemon.123")
                .buildUser();

        // Creating Reviews

        Review review1 = new ReviewBuilder()
                //.setId(1)
                .setMedia(bojackHorseman)
                .setText("The best animated series ever created")
                .setRating(Rating.GOOD)
                .setCreator(user1)
                .buildReview();

        user1.addReview(review1);
        bojackHorseman.addReview(review1);


        Review review2 = new ReviewBuilder()
                //.setId(2)
                .setMedia(starWars)
                .setText("Timeless classical, but fuck Disney for ruining it")
                .setRating(Rating.AVERAGE)
                .setCreator(user2)
                .buildReview();

        user2.addReview(review2);
        starWars.addReview(review2);

        Review review3 = new ReviewBuilder()
                //.setId(3)
                .setMedia(breakingBad)
                .setText("Too slow for me but I can see why people like it")
                .setRating(Rating.BAD)
                .setCreator(user3)
                .buildReview();

        user3.addReview(review3);
        breakingBad.addReview(review3);

        Review review4 = new ReviewBuilder()
                //.setId(4)
                .setMedia(bojackHorseman)
                .setText("Too depressing")
                .setRating(Rating.BAD)
                .setCreator(user2)
                .buildReview();

        user2.addReview(review4);
        bojackHorseman.addReview(review4);

        Review review5 = new ReviewBuilder()
                //.setId(5)
                .setMedia(theWitcher)
                .setText("As a nerd I love it")
                .setRating(Rating.GOOD)
                .setCreator(user3)
                .buildReview();

        user3.addReview(review5);
        theWitcher.addReview(review5);


        Review review6 = new ReviewBuilder()
                //.setId(6)
                .setMedia(breakingBad)
                .setText("So realistic. Love it")
                .setRating(Rating.GOOD)
                .setCreator(user1)
                .buildReview();

        user1.addReview(review6);
        breakingBad.addReview(review6);

        testData.add(starWars);
        testData.add(backToTheFuture);
        testData.add(centralIntelligence);
        testData.add(theWitcher);
        testData.add(theDarkKnightRises);
        testData.add(breakingBad);
        testData.add(bojackHorseman);

        return testData;
    }
}
