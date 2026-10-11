package com.socialMedia.Relationship;

import com.socialMedia.Relationship.Model.SocialGroup;
import com.socialMedia.Relationship.Model.SocialPost;
import com.socialMedia.Relationship.Model.SocialProfile;
import com.socialMedia.Relationship.Model.SocialUser;
import com.socialMedia.Relationship.Repository.SocialGroupRepositories;
import com.socialMedia.Relationship.Repository.SocialPostRepositories;
import com.socialMedia.Relationship.Repository.SocialProfileRepositories;
import com.socialMedia.Relationship.Repository.SocialUserRepositories;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {


    /// You can do @Autowired in place of writing the Constructor below
    private final SocialUserRepositories userRepositories;
    private final SocialGroupRepositories groupRepositories;
    private final SocialProfileRepositories profileRepositories;
    private final SocialPostRepositories postRepositories;

    public DataInitializer(SocialUserRepositories userRepositories, SocialGroupRepositories groupRepositories, SocialProfileRepositories profileRepositories, SocialPostRepositories postRepositories) {
        this.userRepositories = userRepositories;
        this.groupRepositories = groupRepositories;
        this.profileRepositories = profileRepositories;
        this.postRepositories = postRepositories;
    }

    @Bean
    public CommandLineRunner initializeData() {
        return args -> {
            /// Creating Users
            SocialUser user1 = new SocialUser();
            SocialUser user2 = new SocialUser();
            SocialUser user3 = new SocialUser();

            /// Saving those users to database
//            userRepositories.save(user1);
//            userRepositories.save(user2);
//            userRepositories.save(user3);

            /// Creating Groups
            SocialGroup group1 = new SocialGroup();
            SocialGroup group2 = new SocialGroup();

            /// Save groups to database
            groupRepositories.save(group1);
            groupRepositories.save(group2);

            /// Associate groups to users
            user1.getSocialGroup().add(group1);
            user2.getSocialGroup().add(group1);
            user2.getSocialGroup().add(group2);
            user3.getSocialGroup().add(group2);



            /// Saving users back to database after the above association with groups
            userRepositories.save(user1);
            userRepositories.save(user2);
            userRepositories.save(user3);

            /// Creating Post
            SocialPost post1 = new SocialPost();
            SocialPost post2 = new SocialPost();
            SocialPost post3 = new SocialPost();

            /// Associate post to user
            post1.setSocialUser(user1);
            post2.setSocialUser(user2);
            post3.setSocialUser(user3);

            /// Saving posts to the database
            postRepositories.save(post1);
            postRepositories.save(post2);
            postRepositories.save(post3);

            /// Creating some Social Profiles
            SocialProfile profile1 = new SocialProfile();
            SocialProfile profile2 = new SocialProfile();
            SocialProfile profile3 = new SocialProfile();

            /// Associating Profiles with users
            profile1.setSocialUser(user1);
            profile2.setSocialUser(user2);
            profile3.setSocialUser(user3);

            /// Save the above profiles with users associated in database
            profileRepositories.save(profile1);
            profileRepositories.save(profile2);
            profileRepositories.save(profile3);
        };
    }
}
