package com.example.workshopmongo.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.workshopmongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
	
	@Query("{ 'title': { $regex: ?0, $options: 'i' } }")
	List<Post> SearchTitle(String text);
	
	List<Post> findByTitleContainingIgnoreCase(String text); 
	
	/*
	 *  Buscar posts contendo um dado string em qualquer lugar (no título, corpo ou comentários) 
	 *  e em um dado intervalo de datas.
	 *  Utilizando os operadoradores: "e ($and)", "ou ($or)", "maior ou igual ($gte)", 
	 *  "menor ou igual ($lte)","posicao do paramentro (?posicao -> ex: ?0 (pos=0)),".
	 */
	@Query("{ $and: [ { date: {$gte: ?1} }, { date: { $lte: ?2} } , { $or: [ { 'title': { $regex: ?0, $options: 'i' } },"
			+ " { 'body': { $regex: ?0, $options: 'i' } }, { 'comments.text': { $regex: ?0, $options: 'i' } } ] } ] }")
	List<Post> fullSearch(String text, Date minDate, Date maxDate);
	
	
	
}
