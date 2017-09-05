package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import pl.coderslab.Dao.PersonDao;
import pl.coderslab.Entity.Person;
import pl.coderslab.Entity.PersonDetails;

@Controller
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private PersonDao personDao;
    @Autowired
    public void setPersonDao(PersonDao personDao) {
        this.personDao = personDao;
    }

    @GetMapping("")
    public String publishers() {
        return "persons";
    }


    @GetMapping("/find/{id}")
    @ResponseBody
    public String find (@PathVariable long id) {
        return personDao.findById(id).toString();
    }

    @GetMapping("/add")
    public String add(){
        Person person = new Person("mar", "pass", "mariusz@gmail.com");
        person.setPersonDetails(new PersonDetails("Mariusz", "Dobrogosz", "62", "Piwna", "Konotopa", person));
        personDao.save(person);
        return "persons";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable long id) {
        Person person = personDao.findById(id);
        personDao.delete(person);
        return "persons";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable long id) {
        Person person = new Person("nowy", "nowy", "nowy");
        person.setPersonDetails(new PersonDetails("nowy", "nowy", "nowy", "nowy", "nowy", person));
        person.setId(id);
        personDao.update(person);
        return "persons";
    }
    @GetMapping("/form")
        public String formPerson(){
        return "person";
    }
    @PostMapping("/form")
    @ResponseBody
    public String postForm(@RequestParam String login,
                           @RequestParam String password,
                           @RequestParam String email)
    {
            Person entity = new Person(login,password,email);
            this.personDao.save(entity);
        return entity.toString();
    }
    @GetMapping("/personBind")
    public String formPersonBind(Model model){
            Person p = new Person("login1", "password2", "3@gmail.com");
            model.addAttribute("person", p);

        return "personBind";
    }
    @PostMapping("/personBind")
    @ResponseBody
    public String postPersonBind(@ModelAttribute Person person)
    {

        this.personDao.save(person);
        return person.toString();
    }
}