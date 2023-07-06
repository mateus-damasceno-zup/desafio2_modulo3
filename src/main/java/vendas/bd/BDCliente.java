package vendas.bd;

import vendas.Cliente;


import java.util.ArrayList;
import java.util.List;

public class BDCliente {

    private List<Cliente> listaCliente = new ArrayList<>();

    public BDCliente(){
        iniciarBancoCliente();
    }

    public void iniciarBancoCliente(){
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

    }

    public void adicionarCliente(Cliente listaDeClientes){
        this.listaCliente.add(listaDeClientes);
        System.out.println("Cliente adicionado");
    }

    public List<Cliente> listaDeClientes(){

        return new ArrayList<>(this.listaCliente);
    }

    public boolean listaDeClienteJaExistente(String listaDeCliente){
        for (Cliente cliente : this.listaCliente) {
            if(listaDeCliente.contains(cliente.getCpf())){
                return true;
            }
        }
        return false;
    }

    public Cliente retornarCliente(String listaDeClientes){

        for (Cliente c : this.listaCliente) {
            if(listaDeClientes.equalsIgnoreCase(c.getCpf())){
                String cpf = c.getCpf();
                String nome = c.getNome();
                String email= c.getEmail();
                Cliente cliente = new Cliente();
                cliente.setCpf(cpf);
                cliente.setNome(nome);
                cliente.setEmail(email);
                return cliente;
            }
        }
        return null;
    }



}
