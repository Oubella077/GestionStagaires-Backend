package com.Gestionstagaires.Gestionstagaires.web;

import com.Gestionstagaires.Gestionstagaires.Entities.Stage;
import com.Gestionstagaires.Gestionstagaires.Entities.Stagiaire;
import com.Gestionstagaires.Gestionstagaires.Services.Stageservice;
import com.Gestionstagaires.Gestionstagaires.Services.Stagiaireservice;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Stage")
@AllArgsConstructor
@CrossOrigin("*")
public class StagieApi {
 Stageservice stageservice;
    @PreAuthorize("hasAuthority('SCOPE_USER')")
    @GetMapping("/Liste")
    public ResponseEntity<List<Stage>> GetStages() {
        return new  ResponseEntity<>(stageservice.getStages(), HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<Stage> Addstagiaire(@RequestBody Stage stage) {
        return new ResponseEntity<>(stageservice.Addstage(stage), HttpStatus.OK);}
    @DeleteMapping("/delete/{idstagiaire}")
    @PreAuthorize("hasAuthority('SCOPE_USER')")
    public void Addstagiaire(@PathVariable Long idstagiaire) {
         stageservice.Deletestage(idstagiaire);}
    @PutMapping("/update/{idstage}")
    public ResponseEntity<Stage> Addstagiaire(@RequestBody Stage stage, @PathVariable Long idstage) {
        return new ResponseEntity<>(stageservice.Updatestage(stage,idstage),HttpStatus.OK);}
}