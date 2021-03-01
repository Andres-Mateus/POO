
package Calculos;

public class Vector2D {
    private double x, y;
    
    public Vector2D(double x, double y){
        this.x=x;
        this.y=y;
    }
    
    public Vector2D(){
        this.x=0;
        this.y=0;
    }
    
    public double getPosicionX(){
        return this.x;
    }
    
    public double getPosicionY(){
        return this.y;
    }
    
    public void setPosicionX(double x){
        this.x=x;
    }
    
    public void setPosicionY(double y){
        this.y=y;
    }
    
    public Vector2D suma(Vector2D v){
        return new Vector2D(this.x+v.getPosicionX(), this.y+v.getPosicionY());
    }
    
    public Vector2D multiescalar(double valor){
        return new Vector2D(this.x*valor, this.y*valor);
    }
}
