package postre.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import postre.models.entities.Pelanggan;
import postre.services.PelangganService;

import java.util.List;

@RestController
@RequestMapping("/api/pelanggan")
public class PelangganController {
    
    @Autowired
    private PelangganService pelangganService;

    @PostMapping(value = "/insert")
    public Pelanggan create(@RequestBody Pelanggan pelanggan){

        return pelangganService.save(pelanggan);
    }

    @GetMapping(value = "/all")
    public Iterable<Pelanggan> findAll(){
        return pelangganService.findAll();
    }

    @GetMapping(value = "/v1/pelanggan/{id}")
    public List<Pelanggan> findOne(@PathVariable("id") Integer id){
        return pelangganService.findOne(id);
    }

    @DeleteMapping(value = "/v1/pelanggan/{id}")
    public Pelanggan removeOne(@PathVariable("id") Integer id){
        pelangganService.removeOne(id);
        return null;
    }

    @PutMapping(value = "/ubah/{id}")
    public void update(@PathVariable ("id") Integer id, @RequestBody Pelanggan pelanggan){
        try {

            pelangganService.update(id, pelanggan);

        } catch (Exception e){
            e.printStackTrace();
        }

    }


}
