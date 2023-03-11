package com.example.workshopmongo.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.workshopmongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
	
	// Busca posts contendo um dado string no título
	List<Post> findByTitleContainingIgnoreCase(String text); 
	// Igonore Case para consulta nao ser case sensitive
}
