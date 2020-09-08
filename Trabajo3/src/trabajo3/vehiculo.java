package trabajo3;

public class vehiculo {

    private int Codigo;
    private String Cliente;
    private String TipoDeVehiculo;
    private int NumHoras;

    public int getCodigo() {
        return Codigo;
    }

    public void setCodigo(int codigo) {
        this.Codigo = codigo;
    }

    public String getCliente() {
        return Cliente;
    }

    public void setCliente(String cliente) {
        this.Cliente = cliente;
    }

    public String getTipoVehiculo() {
        return TipoDeVehiculo;
    }

    public void setTipovehiculo(String tipovehiculo) {
        this.TipoDeVehiculo = tipovehiculo;
    }

    public int getHora() {
        return NumHoras;
    }

    public void setNumHora(int hora) {
        this.NumHoras = hora;
    }

    public float getValor() {
        float vlr;
        if (TipoDeVehiculo.equals("Auto")) {
            vlr = 3700;
        } else if (TipoDeVehiculo.equals("Camioneta")) {
            vlr = 4500;
        } else {
            vlr = 5200;
        }
        return NumHoras *vlr;
    }

}
