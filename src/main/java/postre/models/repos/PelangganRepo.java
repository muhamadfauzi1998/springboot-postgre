package postre.models.repos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import postre.models.entities.Pelanggan;

public interface PelangganRepo extends CrudRepository<Pelanggan, Long> {
    List<Pelanggan> findByNama(String nama);
    List<Pelanggan> findById(Integer id);
}
