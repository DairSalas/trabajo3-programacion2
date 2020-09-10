package interfazdepetita;

public class Factura {

    private final float VALOR_AUTO = 3400;
    private final float VALOR_CAMIONETA = 5600;
    private final float VALOR_BUS = 8500;

    private int codigo;
    private String cliente;
    private String tipoVehiculo;
    private int numero;

    public Factura() {
    }

    public Factura(int codigo, String cliente, String tipoVehiculo, int numero) {
        this.codigo = codigo;
        this.cliente = cliente;
        this.tipoVehiculo = tipoVehiculo;
        this.numero = numero;
    }

    /**
     * @return the codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the cliente
     */
    public String getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    /**
     * @return the tipoVehiculo
     */
    public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    /**
     * @param tipoVehiculo the tipoVehiculo to set
     */
    public void setTipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    /**
     * @return the numero
     */
    public int getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * @return the valor
     */
    public float getValor() {
        float val = 0;
        if (tipoVehiculo.equals("Auto")) {
            val = VALOR_AUTO;
        } else if (tipoVehiculo.equals("Camioneta")) {
            val = VALOR_CAMIONETA;
        } else {
            val = VALOR_BUS;
        }

        return val * numero;
    }

    @Override
    public String toString() {
        String salida = "Codigo: " + getCodigo() + "\nCliente: " + getCliente() + "\nTipo de vehículo: "
                + getTipoVehiculo() + "\nNúmero de horas: " + getNumero() + "\nValor: " + getValor();
        return salida;
    }

}
