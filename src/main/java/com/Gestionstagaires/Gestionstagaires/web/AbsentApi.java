package com.Gestionstagaires.Gestionstagaires.web;
import com.Gestionstagaires.Gestionstagaires.DTO.AbsentDto;
import com.Gestionstagaires.Gestionstagaires.Entities.Absent;
import com.Gestionstagaires.Gestionstagaires.Services.Absentservice;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/Absent")
@AllArgsConstructor
@Slf4j
@CrossOrigin("*")
public class AbsentApi {
 Absentservice absentservice;
 @GetMapping("/Liste")
    public ResponseEntity<List<Absent>> GetAbsents() {
        return new  ResponseEntity<>(absentservice.getabsent(), HttpStatus.OK);}
    @PostMapping("/create/{id}")
    public ResponseEntity<AbsentDto> Addabsent(@RequestBody AbsentDto DV,@PathVariable Long id) {

        return new ResponseEntity<>(absentservice.Addabsent(DV,id), HttpStatus.OK);}
    @PutMapping("/update/{id}")
    public ResponseEntity<Absent> Adddivision(@RequestBody Absent DV, @PathVariable Long id) {
        return new ResponseEntity<>(absentservice.Updateabsent(DV,id),HttpStatus.OK);}
    @DeleteMapping("/delete/{id}")
    public void Addstagiaire(@PathVariable Long id) {
        absentservice.deleteabsent(id);}
}