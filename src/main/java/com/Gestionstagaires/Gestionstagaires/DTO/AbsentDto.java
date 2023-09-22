package com.Gestionstagaires.Gestionstagaires.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AbsentDto {
   private String cin ;
   private Date date_debut;
   private String justification;
   private Date dateFN;
}
