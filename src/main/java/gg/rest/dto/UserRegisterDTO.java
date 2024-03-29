package gg.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import gg.rest.model.User;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
public class UserRegisterDTO {
    @JsonProperty("id")
    private UUID id;

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("sur_name")
    private String surName;

    private String position;

    @JsonProperty("github_profile_url")
    private String githubProfileUrl;

    public User toEntity(){
        return User.builder()
                .id(id == null ? UUID.randomUUID() : id)
                .firstName(firstName)
                .surName(surName)
                .position(position)
                .githubProfileUrl(githubProfileUrl)
                .build();
    }

    @Builder
    public UserRegisterDTO(UUID id,
                           String firstName,
                           String surName,
                           String position,
                           String githubProfileUrl) {
        this.id = id;
        this.firstName = firstName;
        this.surName = surName;
        this.position = position;
        this.githubProfileUrl = githubProfileUrl;
    }
}
