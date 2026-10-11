package com.socialMedia.Relationship.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SocialUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long UserId;

    @OneToOne(mappedBy = "socialUser")
    private SocialProfile socialProfile;

    @OneToMany(mappedBy = "socialUser")
    private List<SocialPost> socialPost = new ArrayList<>();

    @ManyToMany
    @JoinTable (
            name = "user_group_map",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "group_id")
    )
    private Set<SocialGroup> socialGroup = new HashSet<>();
}
