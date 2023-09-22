package com.Gestionstagaires.Gestionstagaires.Entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Division {
    @Id @GeneratedValue
    private Long id;
    private String Nom_Div;
    @OneToMany(mappedBy = "division")
    @JsonProperty(access= JsonProperty.Access.WRITE_ONLY)
    private List<Encadrent> encadrentList;
}
