import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "serial")
    private long id;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name ="publication_year")
    private int publicationYear;

    @Column(name = "stock")
    private int stock;
    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinTable(
            name = "book2categories",
            joinColumns = {@JoinColumn(name = "book_id")},
            inverseJoinColumns = {@JoinColumn(name = "category_id")}
    )
    private List <Category> categoryList;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "author_id",referencedColumnName = "id")
    private Author author;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "publisher_id",referencedColumnName = "id")
    private Publisher publisher;

    @OneToMany(mappedBy = "book",cascade = CascadeType.ALL)
    private List<BookBorrowing> bookBorrowingList;

    public Book() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public List<BookBorrowing> getBookBorrowingList() {
        return bookBorrowingList;
    }

    public void setBookBorrowingList(List<BookBorrowing> bookBorrowingList) {
        this.bookBorrowingList = bookBorrowingList;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", publicationYear=" + publicationYear +
                ", stock=" + stock +
                ", categoryList=" + categoryList +
                ", author=" + author +
                ", publisher=" + publisher +
                '}';
    }
}
