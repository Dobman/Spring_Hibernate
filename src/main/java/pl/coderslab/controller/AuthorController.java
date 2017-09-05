package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.coderslab.Dao.AuthorDao;

import pl.coderslab.Entity.Author;

@Controller
@RequestMapping("/author")
public class AuthorController {

    @Autowired
  private AuthorDao authorDao;
    @Autowired
    public void setAuthorDao(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    @GetMapping("")
    public String books() {
        return "authors";
    }

    @GetMapping("/find/{id}")
    @ResponseBody
    public String find (@PathVariable long id) {
        return authorDao.findById(id).toString();
    }

    @GetMapping("/add")
    public String add(){
        Author author = new Author("Author", "lastAuthor");
        authorDao.save(author);
        return "authors";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable long id) {
        Author author = authorDao.findById(id);
        authorDao.delete(author);
        return "authors";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable long id) {
        Author author = new Author("nowy", "lastNowy");
        author.setId(id);
        authorDao.update(author);
        return "authors";
    }




}