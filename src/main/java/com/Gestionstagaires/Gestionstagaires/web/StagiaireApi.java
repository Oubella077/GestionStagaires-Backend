package com.Gestionstagaires.Gestionstagaires.web;

import com.Gestionstagaires.Gestionstagaires.DTO.stagiaireDto;
import com.Gestionstagaires.Gestionstagaires.Entities.Stagiaire;
import com.Gestionstagaires.Gestionstagaires.Services.Stagiaireservice;
import jakarta.annotation.security.RolesAllowed;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/Stagiaires")
@AllArgsConstructor
@CrossOrigin("*")
public class StagiaireApi {
    Stagiaireservice stagiaireservice;
    @GetMapping("/Liste")
    @PreAuthorize("hasAnyAuthority('SCOPE_USER','SCOPE_ADMIN')")
   // @RolesAllowed("USER")
    public ResponseEntity<List<Stagiaire>> GetStagiaires() {
        return new  ResponseEntity<>(stagiaireservice.getStagiaires(), HttpStatus.OK);}
    @PostMapping("/create")
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    public ResponseEntity<stagiaireDto> Addstagiaire(@RequestBody stagiaireDto stagiaire) {
        return new ResponseEntity<>(stagiaireservice.Addstagiaire(stagiaire), HttpStatus.OK);}
    @DeleteMapping("/delete/{idstagiaire}")
    //@PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    public void Addstagiaire(@PathVariable Long idstagiaire) {
         stagiaireservice.Deletestagiaire(idstagiaire);}
    @PutMapping("/update/{idstagiaire}")
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    public ResponseEntity<stagiaireDto> Updatestagiaire(@RequestBody stagiaireDto stagiaire, @PathVariable Long idstagiaire) {
       return new ResponseEntity<>(stagiaireservice.Updatestagiaire(stagiaire,idstagiaire), HttpStatus.OK);}
}