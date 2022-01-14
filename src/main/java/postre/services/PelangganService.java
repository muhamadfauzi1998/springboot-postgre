package postre.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.web.bind.annotation.PathVariable;
import postre.models.entities.Pelanggan;
import postre.models.repos.PelangganRepo;

@Service
@Transactional
public class PelangganService {
    
    @Autowired
    private PelangganRepo pelangganRepo;


    public Pelanggan save(Pelanggan pelanggan){
        return pelangganRepo.save(pelanggan);
    }

    public List<Pelanggan>findOne(Integer id){
        
        return pelangganRepo.findById(id);
    }

    public Iterable<Pelanggan> findAll(){
        return pelangganRepo.findAll();
    }

    public void removeOne(Integer id){

        //if(pelangganRepo.findById(id).isEmpty()){
            List<Pelanggan> lsPelanggan =pelangganRepo.findById(id);
                pelangganRepo.deleteAll(lsPelanggan);
        //}
    }

    public List<Pelanggan> findByNama(String nama){
        return pelangganRepo.findByNama(nama);
    }
    public void update(Integer id, Pelanggan pelanggan){
        if(pelangganRepo.findById(id).isEmpty()){
            try {
                List<Pelanggan> lsUpdatePelanggan = pelangganRepo.findById(id);
                    for(Pelanggan update : lsUpdatePelanggan){
                        update.setNo_hp(pelanggan.getNo_hp());
                        update.setId(id);
                        update.setAlamat(pelanggan.getAlamat());
                        update.setNama(pelanggan.getNama());
                        lsUpdatePelanggan.add(update);
                    }
              pelangganRepo.saveAll(lsUpdatePelanggan);



            }catch (Exception e){
                e.printStackTrace();
            }
        }
        pelangganRepo.save(pelanggan);
    }
}
