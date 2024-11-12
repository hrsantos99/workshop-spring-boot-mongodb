package com.nogmo.workshopmongo.config;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.nogmo.workshopmongo.domain.Post;
import com.nogmo.workshopmongo.domain.User;
import com.nogmo.workshopmongo.dto.AuthorDTO;
import com.nogmo.workshopmongo.dto.CommentDTO;
import com.nogmo.workshopmongo.repository.PostRepository;
import com.nogmo.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		DateTimeFormatter sdf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		
		Post post1 = new Post(null, LocalDate.parse("21/03/2024", sdf), "Vacation!", "I will travel to São Paulo.", new AuthorDTO(maria));
		Post post2 = new Post(null, LocalDate.parse("23/03/2024", sdf), "Good morning", "I woke up happy today!", new AuthorDTO(maria));
		
		CommentDTO c1 = new CommentDTO("Good trip brow!", LocalDate.parse("21/03/2024", sdf), new AuthorDTO(alex));
		CommentDTO c2 = new CommentDTO("Enjoy", LocalDate.parse("22/03/2024", sdf), new AuthorDTO(bob));
		CommentDTO c3 = new CommentDTO("Have a great day!!", LocalDate.parse("23/03/2024", sdf), new AuthorDTO(alex));
		
		post1.getComments().addAll(Arrays.asList(c1, c2));
		post2.getComments().addAll(Arrays.asList(c3));
		
		postRepository.saveAll(Arrays.asList(post1, post2));
		
		maria.getPosts().addAll(Arrays.asList(post1, post2));
		userRepository.save(maria);
	}

}
