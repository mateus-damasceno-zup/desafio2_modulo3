package vendas;

import java.util.ArrayList;
import java.util.List;

public class VendasController {
    BDVendas bdVendas = new BDVendas();


    public void cadastrarVendas(Vendas vendas) {
        if (bdVendas.listaDeVendaJaExistente(String.valueOf(vendas))) {
            throw new IllegalArgumentException("lista de vendas ja Existente");
        }
        bdVendas.adicionarVenda(vendas);
    }

    public void listaDeVendas() {
        System.out.println(bdVendas.listaDeVendas());


    }

    public void cadastrarCliente(Cliente cliente) {
        if (bdVendas.listaDeClienteJaExistente(String.valueOf(cliente))) {
            throw new IllegalArgumentException("Cliente ja Existente");
        }
        bdVendas.adicionarCliente(cliente);
    }

    public void listaClientes() {
        System.out.println(bdVendas.listaDeClientes());

    }

    public void listaDeVendedores() {
        System.out.println(bdVendas.listaDeVendedores());

    }

    public void cadastrarVendedor(Vendedor vendedor) {
        if (bdVendas.listaDeVendedoresJaExistente(String.valueOf(vendedor))) {
            throw new IllegalArgumentException("Vendedor ja Existente");
        }
        bdVendas.adicionarVendedor(vendedor);
    }

    public void excluirListaDeVendas(int vendaAExcluir) {

        for (Vendas p : bdVendas.listaDeVendas()) {
            if (p.getId() == vendaAExcluir) {
                bdVendas.excluirVenda(p);

            }

        }

    }

    public Cliente buscaCliente(String cpfCliente) {

        if (bdVendas.listaDeClienteJaExistente(cpfCliente)) {
            return bdVendas.retornarCliente(cpfCliente);

        }
        throw new IllegalArgumentException("Cliente nao encontrado");


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

    public Vendedor buscaVendedor(String cpfVendedor) {
        if (bdVendas.listaDeVendedoresJaExistente(cpfVendedor)) {
            return bdVendas.retornarVendedor(cpfVendedor);

        }
        throw new IllegalArgumentException("vendedor nao encontrado");

    }

    public String validaCPFCliente(String cpf){
        if(bdVendas.listaDeClienteJaExistente(cpf)) {
            throw new IllegalArgumentException("cliente ja existente");
        }
        return cpf;
    }
    public String validaCPFVendedor(String cpf){
        if(bdVendas.listaDeVendedoresJaExistente(cpf)) {
            throw new IllegalArgumentException("vendedor ja existente");
        }
        return cpf;
    }


    public String validaEmailCliente(String emailCliente) {
        if (emailCliente.contains("@")) {
            for (Cliente c : bdVendas.listaDeClientes()) {
                if (!c.getEmail().equalsIgnoreCase(emailCliente)) {
                    return emailCliente;
                }

            }

        }
        throw new IllegalArgumentException("necessario um email valido ou um novo email");

    }

    public String validaEmailVendedor(String emailVendedor) {
        if (emailVendedor.contains("@")) {
            for (Vendedor v : bdVendas.listaDeVendedores()) {
                if (!v.getEmail().equalsIgnoreCase(emailVendedor)) {
                    return emailVendedor;
                }

            }

        }
        throw new IllegalArgumentException("necessario um email valido ou nao repetido");
    }


}


