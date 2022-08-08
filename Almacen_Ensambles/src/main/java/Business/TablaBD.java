package Business;

public class TablaBD {
    private String nomTabla;
    private Object[] tablaCont;
    
    public TablaBD(String nomTabla, Object[] tablaCont){
        this.nomTabla = nomTabla;
        this.tablaCont = tablaCont;
    }
    
    public TablaBD(){
        this.nomTabla = "";
        this.tablaCont = null;
    }
    
    public String getNomTabla() {
        return nomTabla;
    }

    public void setNomTabla(String nomTabla) {
        this.nomTabla = nomTabla;
    }

    public Object[] getTablaCont() {
        return tablaCont;
    }

    public void setTablaCont(Object[] tablaCont) {
        this.tablaCont = tablaCont;
    }
    
}
