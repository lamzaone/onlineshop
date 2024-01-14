/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package magazinonline;

import java.io.Serializable;

/**
 *
 * @author denis
 */
public class CosDeCumparaturi implements Serializable {
    private static final long serialVersionUID = 1L;
    
    int id;
    String Nume;
    double pret;
    int qty;
    double totalpret;

    public CosDeCumparaturi(int id, String Nume, double pret, int qty, double totalpret) {
        this.id = id;
        this.Nume = Nume;
        this.pret = pret;
        this.qty = qty;
        this.totalpret = totalpret;
    }

    public String getNume() {
        return Nume;
    }

    public double getPret() {
        return pret;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getQty() {
        return qty;
    }

    public double getTotalpret() {
        return totalpret;
    }

    public void setNume(String Nume) {
        this.Nume = Nume;
    }

    public void setPret(double pret) {
        this.pret = pret;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public void setTotalpret(double totalpret) {
        this.totalpret = totalpret;
    }

    @Override
    public String toString() {
        return "CosDeCumparaturi{" + "Nume=" + Nume + ", id=" + id + ", pret=" + pret + ", qty=" + qty + ", totalpret=" + totalpret + '}';
    }


    
}
