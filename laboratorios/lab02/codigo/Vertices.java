/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2;


/**
 *
 * @author Joab and Kevin
 */
public class Vertices {
    
    long id;
    double coordenadaX;
    double coordenadasY;
    public Vertices(long id, double coordx, double coordy) {
        this.id = id;
        this.coordenadaX = coordx;
        this.coordenadasY = coordy;
    }

    public long getId(){
        return this.id;
    }

    public double getCoordenadaX(){
        return this.coordenadaX;
    }

    public double getCoordenadasY(){
        return this.coordenadasY;
    }

}