package br.pucminas.orderingmicroservice.api.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import br.pucminas.orderingmicroservice.api.dtos.BookDTO;

@Entity
public class Book 
{
	private Long id;
	private String title;
	private String language;
	private String ISBN10Code;
	private String ISBN13Code;
	private List<Author> authors;
	private Publisher publisher;
	private String edition;
	private String productDimensions;
	private Double shippingWeight;
	private String unitMeasure;
	private Integer averageCustomerReview;
	private Double bestSellerRank;
	private Double price; 
	private List<BookReview> bookReviews;
	
	public Book() {	}
	
	public Book(Long id, String title, String language, String ISBN10Code, String ISBN13Code,
			List<Author> authors, Publisher publisher, String edition, String productDimensions, Double shippingWeight,
			String unitMeasure, Integer averageCustomerReview, Double bestSellerRank, Double price, List<BookReview> bookReviews) {
		this.id = id;
		this.title = title;
		this.language = language;
		this.ISBN10Code = ISBN10Code;
		this.ISBN13Code = ISBN13Code;
		this.authors = authors;
		this.publisher = publisher;
		this.edition = edition;
		this.productDimensions = productDimensions;
		this.shippingWeight = shippingWeight;
		this.unitMeasure = unitMeasure;
		this.averageCustomerReview = averageCustomerReview;
		this.bestSellerRank = bestSellerRank;
		this.price = price;
		this.bookReviews = bookReviews;
	}
	
	
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}


	@Column(name = "title", nullable = false)
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "language", nullable = false)
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}

	@Column(name = "ISBN10", nullable = false)
	public String getISBN10Code() {
		return ISBN10Code;
	}
	public void setISBN10Code(String iSBN10Code) {
		ISBN10Code = iSBN10Code;
	}

	@Column(name = "ISBN13", nullable = false)
	public String getISBN13Code() {
		return ISBN13Code;
	}
	public void setISBN13Code(String iSBN13Code) {
		ISBN13Code = iSBN13Code;
	}

	@ManyToMany(mappedBy = "books")
	public List<Author> getAuthors() {
		return authors;
	}
	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "publisher_id", nullable = false)
	public Publisher getPublisher() {
		return publisher;
	}
	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	@Column(name = "edition", nullable = false)
	public String getEdition() {
		return edition;
	}
	public void setEdition(String edition) {
		this.edition = edition;
	}


	@Column(name = "dimensions", nullable = false)
	public String getProductDimensions() {
		return productDimensions;
	}
	public void setProductDimensions(String productDimensions) {
		this.productDimensions = productDimensions;
	}

	@Column(name = "weight", nullable = false)
	public Double getShippingWeight() {
		return shippingWeight;
	}
	public void setShippingWeight(Double shippingWeight) {
		this.shippingWeight = shippingWeight;
	}
	
	@Column(name = "unit", nullable = false)
	public String getUnitMeasure() {
		return unitMeasure;
	}
	public void setUnitMeasure(String unitMeasure) {
		this.unitMeasure = unitMeasure;
	}

	@Column(name = "averageCustomerReview", nullable = true)
	public Integer getAverageCustomerReview() {
		return averageCustomerReview;
	}
	public void setAverageCustomerReview(Integer averageCustomerReview) {
		this.averageCustomerReview = averageCustomerReview;
	}

	@Column(name = "bestSellerRank", nullable = true)
	public Double getBestSellerRank() {
		return bestSellerRank;
	}
	public void setBestSellerRank(Double bestSellerRank) {
		this.bestSellerRank = bestSellerRank;
	}


	@Column(name = "price", nullable = false)
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}

	@OneToMany
	public List<BookReview> getBookReviews() {
		return bookReviews;
	}
	public void setBookReviews(List<BookReview> bookReviews) {
		this.bookReviews = bookReviews;
	}
	
	@Transient
	public static List<BookDTO> convertToDTO(List<Book> books) 
	{
		List<BookDTO> retorno = new ArrayList<BookDTO>();
		for (Book book : books) {
			
			BookDTO bookDTO = new BookDTO();
			bookDTO.setId(book.getId());
			bookDTO.setTitle(book.getTitle());
			bookDTO.setLanguage(book.getLanguage());
			bookDTO.setISBN10Code(book.getISBN10Code());
			bookDTO.setISBN13Code(book.getISBN13Code());
			bookDTO.setAuthors(getAuthorsToString(book.getAuthors()));
			bookDTO.setPublisher(book.getPublisher().getName());
			bookDTO.setEdition(book.getEdition());
			bookDTO.setProductDimensions(book.getProductDimensions());
			bookDTO.setShippingWeight(book.getShippingWeight());
			bookDTO.setUnitMeasure(book.getUnitMeasure());
			bookDTO.setAverageCustomerReview(book.getAverageCustomerReview());
			bookDTO.setBestSellerRank(book.getBestSellerRank());
			bookDTO.setPrice(book.getPrice());
			
			retorno.add(bookDTO);
		}
		return retorno;
	}

	@Transient
	private static String getAuthorsToString(List<Author> authors)
	{
		String retorno = "";
		for (Author author : authors) {
			retorno += retorno.length() == 0 ? author.getName(): ";" + author.getName();
		}
		
		return retorno;
	}

}
