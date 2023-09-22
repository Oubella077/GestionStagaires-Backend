package com.Gestionstagaires.Gestionstagaires.web;
import com.Gestionstagaires.Gestionstagaires.DTO.EncadrentDto;
import com.Gestionstagaires.Gestionstagaires.Entities.Encadrent;
import com.Gestionstagaires.Gestionstagaires.Entities.Stagiaire;
import com.Gestionstagaires.Gestionstagaires.Services.Encadrentservice;
import com.Gestionstagaires.Gestionstagaires.Services.Stagiaireservice;
import jakarta.annotation.security.RolesAllowed;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/Encadrent")
@AllArgsConstructor
@CrossOrigin("*")
public class EncadrentApi {
    Encadrentservice encadrentservice;
    @GetMapping("/Liste")
    @PreAuthorize("hasAuthority('SCOPE_USER')")
 //@RolesAllowed({"USER","ADMIN"})
 public ResponseEntity<List<Encadrent>> GetEncadrent() {
        return new  ResponseEntity<>(encadrentservice.getEncadrent(), HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<Encadrent> AddEncadrent(@RequestBody EncadrentDto encadrent) {
        return new ResponseEntity<>(encadrentservice.AddEncadrent(encadrent), HttpStatus.OK);}
    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    //@PreAuthorize("hasAuthority('ADMIN')")
    public void Addstagiaire(@PathVariable Long id) {
         encadrentservice.DeleteEncadrent(id);}
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<Encadrent> Updatestagiaire(@RequestBody Encadrent encadrent, @PathVariable Long id) {
       return new ResponseEntity<>(encadrentservice.UpdateEncadrent(encadrent,id), HttpStatus.OK);}
}