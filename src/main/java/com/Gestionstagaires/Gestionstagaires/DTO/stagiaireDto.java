package com.Gestionstagaires.Gestionstagaires.DTO;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class stagiaireDto {
    private String cin;
    private String nom;
    private String prenom;
    private String email;
    private Long Tel;
    private Date Date;
    private String etablissment;

    private Long idstage ;
    private Long idencadrent ;


}
