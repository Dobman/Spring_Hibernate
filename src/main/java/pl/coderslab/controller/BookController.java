package pl.coderslab.controller;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.coderslab.Dao.BookDao;
import pl.coderslab.Entity.Author;
import pl.coderslab.Entity.Book;
import pl.coderslab.Entity.Publisher;

import javax.transaction.Transactional;

@Controller
@RequestMapping("/book")
public class BookController {

    private BookDao bookDao;

    @Autowired
    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @GetMapping("")
    public String books() {
        return "books";
    }

    @GetMapping("/find/{id}")
    @ResponseBody
    public String find (@PathVariable long id) {
        return bookDao.findById(id).toString();
    }

    @GetMapping("/all")
    @ResponseBody
    public String all() {
        List<Book> list = bookDao.all();
        StringBuilder sb = new StringBuilder();
        for(Book book : list) {
            Hibernate.initialize(book.getAuthor());
            sb.append(book.toString()).append("\n");
        }
        return sb.toString();
    }

    @GetMapping("/add")
    public String add(){
        List<Author> authors = new ArrayList<Author>();
        authors.add(new Author("name", "last name"));
        Book book = new Book("AAAA", authors, 5, new Publisher("wydawca"), "opis");
        bookDao.save(book);
        return "books";
    }

//	@PostMapping("/add")
//	public String add(@PathVariable("author") String author,
//			@PathVariable("rating") String rating, @PathVariable("publisher") String publisher,
//			@PathVariable("description") String description) {
//		Book book = new Book("aaa", author, Double.parseDouble(rating), publisher, description);
//		bookDao.save(book);
//		return "books";
//
//	}

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable long id) {
        Book book = bookDao.findById(id);
        bookDao.delete(book);
        return "books";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable long id) {
        List<Author> authors = new ArrayList<Author>();
        authors.add(new Author("nowy", "last nowy"));
        Book book = new Book("nowy", authors, 1.1, new Publisher("nowy"), "nowy");
        book.setId(id);
        bookDao.update(book);
        return "books";
    }
    @Transactional
    @GetMapping("/getAuthors")
    @ResponseBody
    public String getAuthors(){
        Book b = this.bookDao.findById(1);
        Hibernate.initialize(b);
        return b.getAuthor().toString();
    }


}