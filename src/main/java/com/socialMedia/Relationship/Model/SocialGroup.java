package com.socialMedia.Relationship.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class SocialGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long groupId;

    @ManyToMany(mappedBy = "socialGroup")
    @JsonIgnore
    private Set<SocialUser> userSet = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SocialGroup other)) return false;
        return groupId != null && groupId.equals(other.groupId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
