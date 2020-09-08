package taller;

public class Vehiculo {

    private int codigo;
    private String cliente;
    private String tipoVehiculo;
    private int hora;
    private float valor;

    public Vehiculo() {
        codigo = 0;
        cliente = "";
        tipoVehiculo = "";
        hora = 0;
        valor = 0;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipovehiculo(String tipovehiculo) {
        this.tipoVehiculo = tipovehiculo;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    private int valorHora() {
        int valor = 0;
        switch (getTipoVehiculo()) {
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
        return (getHora() * valorHora());
    }
    
}
