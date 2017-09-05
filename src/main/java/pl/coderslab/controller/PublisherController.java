package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.coderslab.Dao.PublisherDao;
import pl.coderslab.Entity.Publisher;

@Controller
@RequestMapping("/publisher")
public class PublisherController {
    private PublisherDao publisherDao;
    @Autowired
    public void setPublisherDao(PublisherDao publisherDao) {
        this.publisherDao = publisherDao;
    }

    @GetMapping("")
    public String publishers() {
        return "publishers";
    }

    @GetMapping("/find/{id}")
    @ResponseBody
    public String find (@PathVariable long id) {
        return publisherDao.findById(id).toString();
    }

    @GetMapping("/add")
    public String add(){
        Publisher publisher = new Publisher("publisher");
        publisherDao.save(publisher);
        return "publishers";
    }

    @GetMapping("/delete/{1}")
    public String delete(@PathVariable long id) {
        Publisher publisher = publisherDao.findById(id);
        publisherDao.delete(publisher);
        return "publishers";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable long id) {
        Publisher publisher = new Publisher("nowy");
        publisher.setId(id);
        publisherDao.update(publisher);
        return "publishers";
    }

}