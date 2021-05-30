package com.magneto.project.models.entities;


import com.google.cloud.spring.data.datastore.core.mapping.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Adn {

    @Id
    private String adnId;

    private String baseAdn;

    private Boolean esMutante;
}
