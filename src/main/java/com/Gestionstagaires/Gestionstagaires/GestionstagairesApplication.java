package com.Gestionstagaires.Gestionstagaires;

import com.Gestionstagaires.Gestionstagaires.DTO.AbsentDto;
import com.Gestionstagaires.Gestionstagaires.DTO.stagiaireDto;
import com.Gestionstagaires.Gestionstagaires.Entities.*;
import com.Gestionstagaires.Gestionstagaires.Repository.AbsentRepo;
import com.Gestionstagaires.Gestionstagaires.Repository.EncadrentRepo;
import com.Gestionstagaires.Gestionstagaires.Repository.StagiaireRepo;
import com.Gestionstagaires.Gestionstagaires.Services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

import java.time.Instant;
import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class GestionstagairesApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionstagairesApplication.class, args);
	}
	@Bean
	CommandLineRunner commandLineRunner(StagiaireRepo stagiaireservice, Stageservice stageservice,
										EncadrentRepo encadrentservice, Divisionservice divisionservice,
										AbsentRepo absentservice) {

		return args -> {
			Stream.of("amine", "juice", "mohammed","Ayoub").forEach(
					name -> {
						//create  a stagiaire field
						Stagiaire stagiaire = new Stagiaire();
						stagiaire.setNom(name);
						stagiaire.setCin("55" + name);
						stagiaire.setPrenom(name);
						stagiaire.setEtablissment("university Y");
						Date date=new Date();
						stagiaire.setDate_Naissance(date);
						stagiaire.setTel(0677223344L);
						stagiaire.setEmail(name+"@gmail.com");;
						Stage DTO = new Stage();
						//create  a stage field
						DTO.setSujet("Classification des Donnees");
						DTO.setDate_debut(Date.from(Instant.now()));

						stageservice.Addstage(DTO);
						//create  encadrent field
						Encadrent encadrent=new Encadrent();
						encadrent.setNom(name);
						encadrent.setEmail(name+"@gmail.com");
						encadrent.setCin("M6666");

						//create  Division field
						Division division=new Division();
						division.setNom_Div("info departement");
						encadrent.setDivision(divisionservice.Adddivision(division));
						encadrentservice.save(encadrent);
						Absent absent=new Absent();
						absent.setJustification("malade");
						absent.setDate_debut(Date.from(Instant.now()));
						absentservice.save(absent);
						 stagiaireservice.save(stagiaire);

					});
	};
	}

	//@Bean
	CommandLineRunner commandLineRunner1(JdbcUserDetailsManager jdbcUserDetailsManager){
		PasswordEncoder passwordEncoder =passwordEncoder();
		return args -> {
			jdbcUserDetailsManager.createUser(User.withUsername("USER1")
					.password(passwordEncoder.encode("12345")).authorities("USER").build());
			jdbcUserDetailsManager.createUser(User.withUsername("USER2").
					password(passwordEncoder.encode("12345")).authorities("ADMIN").build());
	};
}
	//@Bean
	public PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}


}