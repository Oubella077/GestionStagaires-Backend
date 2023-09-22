package com.Gestionstagaires.Gestionstagaires.Entities;

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
public class Absent {
    @Id @GeneratedValue
    private Long id;
    @ManyToOne
    private Stagiaire stagiaire;
    private Date Date_debut;
    private Date Date_fin;
    private String Justification;
}
