package com.example.bmdb.service;

import com.example.bmdb.domain.Media;
import com.example.bmdb.domain.Review;
import com.example.bmdb.domain.User;
import com.example.bmdb.repository.MediaRepository;
import com.example.bmdb.repository.ReviewRepository;
import com.example.bmdb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@ComponentScan("com.example.bmdb.repository")
public class Service {
    private User user;
    private List<Media> medias;

    @Autowired
    UserRepository userRepository;
    @Autowired
    MediaRepository mediaRepository;
    @Autowired
    ReviewRepository reviewRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public Service() {
        this.medias = TestDataGenerator.generateTestData();
        //this.loadTestDataToDatabase();
    }

    public void loadTestDataToDatabase() {

        // Sets encoding for user passwords
        for(Media media : this.medias){
                for(Review review : media.getReviews()){
                    review.getCreator()
                            .setPassWord(bCryptPasswordEncoder.encode
                                    (review.getCreator().getPassWord()));
                }
        }

        this.mediaRepository.saveAll(medias);
    }

    public void saveUser(User user) {
        this.user = user;
        user.setPassWord(bCryptPasswordEncoder.encode(user.getPassWord()));
        this.userRepository.save(user);
    }

    public Iterable<User> findAllUsers(){
        return this.userRepository.findAll();
    }

    public User findUser() {
        return this.user;
        //Todo find user in db
    }

    public User findUserbyId(int id){
        Optional<User> userLookup = this.userRepository.findById(Integer.toString(id));
        if(userLookup.get() == null){
            return null;
        }
        return userLookup.get();
    }

    public User findUserbyEmail(String email){
        Iterable<User> userLookup = this.userRepository.findAll();
        List<User> allUsers = new ArrayList<User>();
        userLookup.forEach(allUsers::add);

        List<User> allUsersList = allUsers.stream()
                .filter(u -> u.getEmail().equals(email))
                .collect(Collectors.toList());

        if(allUsersList.size() == 0){
            return null;
        }

        return allUsersList.get(0);
    }

    public List<Media> findAllMedia() {
        return this.medias;
    }

    public void saveReview(Media media, Review review) {
        media.addReview(review);
        review.setMedia(media);
        // TODO cascade elvileg megoldja
        this.reviewRepository.save(review);
        this.mediaRepository.save(media);
    }

    public List<Review> findAllReview(Media media) {
        // TODO query database
        return media.getReviews();
    }

    public BCryptPasswordEncoder getbCryptPasswordEncoder() {
        return bCryptPasswordEncoder;
    }
}
