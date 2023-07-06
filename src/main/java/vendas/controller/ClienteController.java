package vendas.controller;

import vendas.bd.BDCliente;
import vendas.Model.Cliente;

public class ClienteController {
    BDCliente bdCliente = new BDCliente();

    public void cadastrarCliente(Cliente cliente) {
        if (bdCliente.listaDeClienteJaExistente(String.valueOf(cliente))) {
            throw new IllegalArgumentException("Cliente ja Existente");
        }
        bdCliente.adicionarCliente(cliente);
    }

    public void listaClientes() {
        System.out.println(bdCliente.listaDeClientes());

    }

    public Cliente buscaCliente(String cpfCliente) {

        if (bdCliente.listaDeClienteJaExistente(cpfCliente)) {
            return bdCliente.retornarCliente(cpfCliente);

        }
        throw new IllegalArgumentException("Cliente nao encontrado");


    }
    public String validaEmailCliente(String emailCliente) {
        if (emailCliente.contains("@")) {
            for (Cliente c : bdCliente.listaDeClientes()) {
                if (!c.getEmail().equalsIgnoreCase(emailCliente)) {
                    return emailCliente;
                }

            }

        }
        throw new IllegalArgumentException("necessario um email valido ou um novo email");

    }
}
