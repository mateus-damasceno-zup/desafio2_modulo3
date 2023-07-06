package vendas.controller;

import vendas.bd.BDCliente;
import vendas.bd.BDVendas;
import vendas.Model.Cliente;
import vendas.Model.Vendas;
import vendas.Model.Vendedor;
import vendas.bd.BDVendedor;

import java.util.ArrayList;
import java.util.List;

public class VendasController {
    BDCliente bdCliente = new BDCliente();
    List<Cliente> listaDeClientes = bdCliente.listaDeClientes();
    BDVendedor bdVendedor = new BDVendedor();
    List<Vendedor> listaDeVendedores =bdVendedor.listaDeVendedores();

    BDVendas bdVendas = new BDVendas(listaDeClientes,listaDeVendedores);


    public void cadastrarVendas(Vendas vendas) {
        if (bdVendas.listaDeVendaJaExistente(String.valueOf(vendas))) {
            throw new IllegalArgumentException("lista de vendas ja Existente");
        }
        bdVendas.adicionarVenda(vendas);
    }

    public void listaDeVendas() {
        System.out.println(bdVendas.listaDeVendas());


    }

    public void excluirListaDeVendas(int vendaAExcluir) {

        for (Vendas p : bdVendas.listaDeVendas()) {
            if (p.getId() == vendaAExcluir) {
                bdVendas.excluirVenda(p);

            }

        }

    }


    public List<Vendas> buscaVendaCliente(String cpfCliente) {
        List<Vendas> vendas = new ArrayList<>();
        for (Vendas v: bdVendas.listaDeVendas()) {
            if ((v.getCliente().getCpf()).equalsIgnoreCase(cpfCliente)){
                vendas.add(v);

            }
        }
       return vendas;

    }

    public List<Vendas> buscaVendaVendedor(String emailVendedor) {
        List<Vendas> vendas = new ArrayList<>();
        for (Vendas v: bdVendas.listaDeVendas()) {
            if ((v.getVendedor().getEmail().equalsIgnoreCase(emailVendedor))){
                vendas.add(v);

            }
        }
        return vendas;

    }



    public String validaCPFCliente(String cpf){
        if(bdCliente.listaDeClienteJaExistente(cpf)) {
            throw new IllegalArgumentException("cliente ja existente");
        }
        return cpf;
    }





}


