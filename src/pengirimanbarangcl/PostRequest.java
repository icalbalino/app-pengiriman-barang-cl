/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pengirimanbarangcl;

import java.io.Serializable;

/**
 *
 * @author user
 */
public class PostRequest implements Serializable {
    
    private String nama_penerima;
    private String alamat;

    public PostRequest() {
    }

    public PostRequest(String nama_penerima, String alamat) {
        this.nama_penerima = nama_penerima;
        this.alamat = alamat;
    }

    public String getNama_penerima() {
        return nama_penerima;
    }

    public void setNama_penerima(String nama_penerima) {
        this.nama_penerima = nama_penerima;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
    
}
