package postre.models.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_pelanggan")
public class Pelanggan implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nama_pelanggan", length = 100)
    private String nama;

    @Column(name = "alamat_pelanggan", length = 250)
    private String alamat;

    @Column(name = "no_hp", length = 50)
    private String no_hp;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNo_hp() {
        return no_hp;
    }

    public void setNo_hp(String no_hp) {
        this.no_hp = no_hp;
    }

    public Pelanggan(){
    }

    public Pelanggan(Integer id, String nama, String alamat, String no_hp) {
        this.id = id;
        this.nama = nama;
        this.alamat = alamat;
        this.no_hp = no_hp;
    }
    
    
}
