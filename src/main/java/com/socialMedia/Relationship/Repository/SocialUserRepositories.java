package com.socialMedia.Relationship.Repository;

import com.socialMedia.Relationship.Model.SocialUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SocialUserRepositories extends JpaRepository<SocialUser,Long> {
}
