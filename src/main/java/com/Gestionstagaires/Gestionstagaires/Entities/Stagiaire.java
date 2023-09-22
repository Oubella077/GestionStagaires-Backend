package com.Gestionstagaires.Gestionstagaires.Entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
public class Stagiaire {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cin;
    private String nom;
    private String prenom;
    private String email;
    private String etablissment;
    private Date date_Naissance;
    private Long Tel;
    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name="encadrent_id")
    private  Encadrent encadrent;
    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name="stage_id")
    private  Stage stage;
    @OneToMany(mappedBy = "stagiaire",fetch = FetchType.LAZY,cascade = CascadeType.REMOVE)
    @JsonIgnore
    private List<Absent> absent;
}
