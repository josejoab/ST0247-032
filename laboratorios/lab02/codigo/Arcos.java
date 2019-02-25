package lab2;



/**
 *
 * @author Joab and Kevin
 */
public class Arcos {
    long idpart;
    long idllegada;
    double distancia;
    String nombre;
    
    public Arcos(long idpart, long idlleg, double distance, String name){
        this.idpart=idpart;
        this.idllegada=idlleg;
        this.distancia=distance;
        this.nombre=name;
        
    }

    public long getIdpart(){
        return this.idpart;
    }

    public long getIdllegada(){
        return this.idllegada;
    }

    public double getDistancia(){
        return this.distancia;
    }

    public String getNombre() {
        return this.nombre;
    }
}