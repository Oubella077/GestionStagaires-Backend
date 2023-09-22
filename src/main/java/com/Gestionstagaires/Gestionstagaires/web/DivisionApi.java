package com.Gestionstagaires.Gestionstagaires.web;

import com.Gestionstagaires.Gestionstagaires.Entities.Division;
import com.Gestionstagaires.Gestionstagaires.Entities.Stage;
import com.Gestionstagaires.Gestionstagaires.Services.Divisionservice;
import com.Gestionstagaires.Gestionstagaires.Services.Stageservice;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Division")
@AllArgsConstructor
@CrossOrigin("*")
public class DivisionApi {
 Divisionservice divisionservice;
 @GetMapping("/Liste")
    public ResponseEntity<List<Division>> GetDivisions() {
        return new  ResponseEntity<>(divisionservice.getdivision(), HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<Division> Addstagiaire(@RequestBody Division DV) {
        return new ResponseEntity<>(divisionservice.Adddivision(DV), HttpStatus.OK);}
    @DeleteMapping("/delete/{id}")
    public void deletedivision(@PathVariable Long id) {
        divisionservice.Deletedivision(id);}
    @PutMapping("/update/{id}")
    public ResponseEntity<Division> Adddivision(@RequestBody Division DV, @PathVariable Long id) {
        return new ResponseEntity<>(divisionservice.Updatedivision(DV,id),HttpStatus.OK);}
}