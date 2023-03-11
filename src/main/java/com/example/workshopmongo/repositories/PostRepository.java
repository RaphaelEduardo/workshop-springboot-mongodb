package com.example.workshopmongo.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.workshopmongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
	
	/* 
	 * Modelo de consulta alternativa (https://www.mongodb.com/docs/manual/reference/operator/query/regex/)
	 *  'title' (campo pelo qual quer efetuar a busca).
	 *  ?0 (primeiro parametro que vem no metodo).
	 *  'i' (ignora o case sensitive).
	 */
	@Query("{ 'title': { $regex: ?0, $options: 'i' } }")
	List<Post> SearchTitle(String text);
	
	List<Post> findByTitleContainingIgnoreCase(String text); 
	
	
	
}
