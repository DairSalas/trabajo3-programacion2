package javaapplication35;

public class Vehiculo {

    private int cod;
    private String cli;
    private String tv;
    private int h;
    private float v;

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getCli() {
        return cli;
    }

    public void setCli(String cli) {
        this.cli = cli;
    }

    public String getTv() {
        return tv;
    }

    public void setTv(String tv) {
        this.tv = tv;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public float getV() {
        return v;
    }

    public void setV(float v) {
        this.v = v;
    }

    

    private int valorHora() {
        int valor = 0;
        switch (getTv()) {
            case "Auto":
                valor = 3700;
                break;
            case "Camioneta":
                valor = 4500;
                break;
            case "Bus":
                valor = 5200;
                break;
        }
        return valor;
    }

    public float precioTotal() {
        return (getH() * valorHora());
    }
    
}
