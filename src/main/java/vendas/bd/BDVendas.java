package vendas.bd;

import vendas.Cliente;
import vendas.Vendas;
import vendas.Vendedor;

import java.util.ArrayList;
import java.util.List;

public class BDVendas {


    private List<Vendas> vendas = new ArrayList<>();


    private List<Vendedor> listaVendedor = new ArrayList<>();

    public BDVendas(List<Cliente> clientes){
        iniciarBancoVendas(clientes);
    }

    public void iniciarBancoVendas(List<Cliente> clientes){
        Vendedor vendedor = new Vendedor("gilberto","191","gilberto@email.com");
        Vendedor vendedor1 = new Vendedor("robalo","147","robalo@vendas.com");
        Vendedor vendedor2 = new Vendedor("Dulcato","910","dulcato@gema.com");
        Vendedor vendedor3 = new Vendedor("Claudio","777","cleber@bmail.com");
        Vendedor vendedor4 = new Vendedor("Hermes","666","hermes@hmail.com");
        adicionarVendedor(vendedor);
        adicionarVendedor(vendedor1);
        adicionarVendedor(vendedor2);
        adicionarVendedor(vendedor3);
        adicionarVendedor(vendedor4);

        adicionarVenda(new Vendas(clientes.get(0),vendedor,400.00,"03/07/2023"));
        adicionarVenda(new Vendas(clientes.get(1),vendedor1,300.00,"21/07/2023"));
        adicionarVenda(new Vendas(clientes.get(2),vendedor2,2222.22,"11/06/2023"));
        adicionarVenda(new Vendas(clientes.get(3),vendedor3,53.23,"12/06/2023"));
        adicionarVenda(new Vendas(clientes.get(4),vendedor4,2342.43,"05/12/2013"));


    }

    public void adicionarVenda(Vendas listaDeVendas){
        this.vendas.add(listaDeVendas);
        System.out.println("venda adicionada");
    }
    public void adicionarVendedor(Vendedor listaDeVendedor){
        this.listaVendedor.add(listaDeVendedor);
        System.out.println("Vendedor adicionado");
    }


    public boolean listaDeVendaJaExistente(String listaDeVenda){
        for (Vendas venda : this.vendas) {
            if(listaDeVenda.contains(List.of(venda.getId()).toString())){
                return true;
            }
        }
        return false;
    }

    public List<Vendas> listaDeVendas(){

        return new ArrayList<>(this.vendas);
    }



    public List<Vendedor> listaDeVendedores(){

        return new ArrayList<>(this.listaVendedor);
    }
    public boolean listaDeVendedoresJaExistente(String listaDeVendedores){
        for (Vendedor vendedor : this.listaVendedor) {
            if(listaDeVendedores.contains(vendedor.getCpf())){
                return true;
            }
        }
        return false;
    }

    public void excluirVenda(Vendas vendaId){
        this.vendas.remove(vendaId);
        System.out.println("lista removida");
    }


    public Vendedor retornarVendedor(String cpfVendedor) {

        for (Vendedor v : this.listaVendedor) {
            if(cpfVendedor.equalsIgnoreCase(v.getCpf())){
                String cpf = v.getCpf();
                String nome = v.getNome();
                String email= v.getEmail();
                Vendedor vendedor = new Vendedor();
                vendedor.setCpf(cpf);
                vendedor.setNome(nome);
                vendedor.setEmail(email);
                return vendedor;
            }
        }
        return null;
    }

 
    public Vendas retornarVendas(String cpfCliente){
        for (Vendas venda : this.vendas) {
            if(cpfCliente.equalsIgnoreCase(venda.getCliente().getCpf())){
                Cliente cliente = venda.getCliente();
                Vendedor vendedor = venda.getVendedor();
                double valor= venda.getValor();
                String data = venda.getDataRegistro();
                Vendas vendas1 = new Vendas();
                vendas1.setCliente(cliente);
                vendas1.setVendedor(vendedor);
                vendas1.setValor(valor);
                vendas1.setDataRegistro(data);
                return vendas1;
            }
        }
        return null;
    }

}
