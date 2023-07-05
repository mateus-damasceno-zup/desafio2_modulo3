package vendas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BDVendas {


    private List<Vendas> vendas = new ArrayList<>();
    private List<Cliente> listaCliente = new ArrayList<>();

    private List<Vendedor> listaVendedor = new ArrayList<>();

    public BDVendas(){
        iniciarBancoVendas();
    }

    public void iniciarBancoVendas(){
        Cliente cliente = new Cliente("mateus","911","mateus@mateus.com");
        Cliente cliente1 = new Cliente("karla","026","karla@gmail.com");
        Cliente cliente2 = new Cliente("kiwi","320","cutucadinha@dr.com");
        Cliente cliente3 = new Cliente("jujuba","566","potota@email.com");
        Cliente cliente4 = new Cliente("astolfo","171","astolfo@email.com");
        adicionarCliente(cliente);
        adicionarCliente(cliente1);
        adicionarCliente(cliente2);
        adicionarCliente(cliente3);
        adicionarCliente(cliente4);

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

        adicionarVenda(new Vendas(cliente,vendedor,400.00,"03/07/2023"));
        adicionarVenda(new Vendas(cliente1,vendedor1,300.00,"21/07/2023"));
        adicionarVenda(new Vendas(cliente2,vendedor2,2222.22,"11/06/2023"));
        adicionarVenda(new Vendas(cliente3,vendedor3,53.23,"12/06/2023"));
        adicionarVenda(new Vendas(cliente4,vendedor4,2342.43,"05/12/2013"));


    }

    public void adicionarVenda(Vendas listaDeVendas){
        this.vendas.add(listaDeVendas);
        System.out.println("venda adicionada");
    }
    public void adicionarVendedor(Vendedor listaDeVendedor){
        this.listaVendedor.add(listaDeVendedor);
        System.out.println("Vendedor adicionado");
    }
    public void adicionarCliente(Cliente listaDeClientes){
        this.listaCliente.add(listaDeClientes);
        System.out.println("Cliente adicionado");
    }

    public boolean listaDeVendaJaExistente(String listaDeVenda){
        for (Vendas vendas : this.vendas) {
            if(listaDeVenda.contains(List.of(vendas.getId()).toString())){
                return true;
            }
        }
        return false;
    }

    public List<Vendas> listaDeVendas(){
        List<Vendas> listaDeVendas = new ArrayList<>(this.vendas);
        System.out.println(listaDeVendas);
        return listaDeVendas;
    }

    public List<Cliente> listaDeClientes(){
        List<Cliente> listaDeClientes = new ArrayList<>(this.listaCliente);
        System.out.println(listaDeClientes);
        return listaDeClientes;
    }
    public boolean listaDeClienteJaExistente(String listaDeCliente){
        for (Cliente cliente : this.listaCliente) {
            if(listaDeCliente.contains(cliente.getCpf())){
                return true;
            }
        }
        return false;
    }
    public List<Vendedor> listaDeVendedores(){
        List<Vendedor> listaDeVendedor = new ArrayList<>(this.listaVendedor);
        System.out.println(listaDeVendedor);
        return  listaDeVendedor;
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

    public Cliente retornarCliente(String listaDeClientes){

        for (Cliente c : this.listaCliente) {
            if(listaDeClientes.equalsIgnoreCase(c.getCpf())){
                String cpf = c.getCpf();
                String nome = c.getNome();
                String email= c.getEmail();
                //como pegar o cliente e ...
                Cliente cliente = new Cliente();
                cliente.setCpf(cpf);
                cliente.setNome(nome);
                cliente.setEmail(email);
                return cliente;
            }
        }
        return null;
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
}
