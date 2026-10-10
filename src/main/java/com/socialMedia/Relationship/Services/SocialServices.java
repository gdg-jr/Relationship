package com.socialMedia.Relationship.Services;

import com.socialMedia.Relationship.Model.SocialUser;
import com.socialMedia.Relationship.Repository.SocialUserRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SocialServices {

    @Autowired
    private SocialUserRepositories socialUserRepositories;

    public List<SocialUser> getAllUsers() {
        return socialUserRepositories.findAll();
    }

    public SocialUser saveUser(SocialUser socialUser) {
        return socialUserRepositories.save(socialUser);
    }
}
