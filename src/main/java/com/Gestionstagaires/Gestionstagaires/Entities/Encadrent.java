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
public class Encadrent {
    @Id @GeneratedValue
    private Long id;
    private String cin ;
    private String email;
    private String nom;
    private String prenom;
    private String Tel;
    @ManyToOne(cascade = CascadeType.REMOVE)
    private Division division;
    @OneToMany(mappedBy="encadrent",orphanRemoval = true,cascade = CascadeType.ALL)
    @JsonProperty(access= JsonProperty.Access.WRITE_ONLY)
    private List<Stagiaire> stagiaire;
}
