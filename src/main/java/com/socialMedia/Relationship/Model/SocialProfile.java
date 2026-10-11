package com.socialMedia.Relationship.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SocialProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long profileId;

    @OneToOne
    @JoinColumn(name = "social_user")
    @JsonIgnore
    private SocialUser socialUser;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SocialProfile other)) return false;
        return profileId != null && profileId.equals(other.profileId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

}
