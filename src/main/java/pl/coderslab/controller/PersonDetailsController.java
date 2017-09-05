package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.coderslab.Dao.PersonDetailsDao;
import pl.coderslab.Entity.Person;
import pl.coderslab.Entity.PersonDetails;

@Controller
@RequestMapping("/persondetails")
public class PersonDetailsController {
    private PersonDetailsDao personDetailsDao;
    @Autowired
    public void setPersonDetailsDao(PersonDetailsDao personDetailsDao) {
        this.personDetailsDao = personDetailsDao;
    }

    @GetMapping("")
    public String publishers() {
        return "personDetails";
    }


    @GetMapping("/find/{id}")
    @ResponseBody
    public String find (@PathVariable long id) {
        return personDetailsDao.findById(id).toString();
    }

    @GetMapping("/add")
    public String add(){
        PersonDetails personDetails = new PersonDetails("Kamil", "Chojnowski", "37/39", "Wilenska", "Warszawa");
        personDetails.setPerson(new Person("kam", "pass", "kamil@gmail.com"));
        personDetailsDao.save(personDetails);
        return "personDetails";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable long id) {
        PersonDetails personDetails = personDetailsDao.findById(id);
        personDetailsDao.delete(personDetails);
        return "personDetails";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable long id) {
        PersonDetails personDetails = new PersonDetails("nowy", "nowy", "nowy", "nowy", "nowy");
        personDetails.setPerson(personDetails.getPerson());
        personDetails.setId(id);
        personDetailsDao.update(personDetails);
        return "personDetails";
    }


}