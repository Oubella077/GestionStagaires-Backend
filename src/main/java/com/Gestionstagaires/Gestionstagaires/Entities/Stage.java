package com.Gestionstagaires.Gestionstagaires.Entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;
import java.util.List;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Stage {
    @Id
    @GeneratedValue
    private Long id;
    private String Sujet;
    @OneToMany(mappedBy = "stage",fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Stagiaire> stagiaire;
    private Date Date_debut;
    private Date Date_fin;
}
