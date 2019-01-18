package br.pucminas.orderingmicroservice.api.services;

import br.pucminas.orderingmicroservice.api.entities.BookReview;

public interface BookReviewService {

	/**
	 * Insere na base de dados um comentário para um livro.
	 * 
	 * @param bookReview
	 * @return BookReview
	 */
	BookReview insert(BookReview bookReview);
}
