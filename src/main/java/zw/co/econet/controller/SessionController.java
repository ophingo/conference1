package zw.co.econet.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import zw.co.econet.model.Session;
import zw.co.econet.repositories.Sessionrepository;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sessions")
public class SessionController {

    @Autowired
    private Sessionrepository sessionrepository;

    @GetMapping
    public List<Session> list(){
        return sessionrepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Session get(@PathVariable long id){
        return sessionrepository.getOne(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Session create(@RequestBody final Session session){
        return sessionrepository.saveAndFlush(session);
    }

    @RequestMapping(value="{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id){
        sessionrepository.deleteById(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public void update(@PathVariable Long id, @RequestBody Session session){
        Session existingSession = sessionrepository.getOne(id);
        BeanUtils.copyProperties(session, existingSession, "session_id");
        sessionrepository.saveAndFlush(existingSession);
    }
}
