package vendas;

public class Vendas {

    private static int sequence=0;
    private int id;
    private Cliente cliente;
    private Vendedor vendedor;
    private double valor;
    private String dataRegistro;

    public Vendas(Cliente cliente, Vendedor vendedor, double valor, String dataRegistro) {
        this.id = sequence++;
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.valor = valor;
        this.dataRegistro = dataRegistro;
    }
    public Vendas(){

    }
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(String dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Vendas{" +
                "id=" + id +
                ", cliente= " + cliente.getNome() +
                ", vendedor= " + vendedor.getCpf() +
                ", valor= " + valor +
                ", dataRegistro='" + dataRegistro + '\'' +
                '}'+"\n";
    }
}
