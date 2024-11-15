package com.nogmo.workshopmongo.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nogmo.workshopmongo.domain.Post;
import com.nogmo.workshopmongo.repository.PostRepository;
import com.nogmo.workshopmongo.services.exceptions.ObjectsNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repo;
	
	public Post findById(String id) {
	    Optional<Post> user = repo.findById(id);
	    return user.orElseThrow(() -> new ObjectsNotFoundException("Object not found."));
	}
	
	public List<Post> findByTitle(String text) {
		return repo.searchTitle(text);
	}
	
	public List<Post> fullSearch(String text, LocalDate minDate, LocalDate maxDate) {
		return repo.fullSearch(text, minDate, maxDate);
	}
	
}
