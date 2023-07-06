package vendas.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import vendas.Model.Cliente;

class ClienteControllerTest {

    @Test
    void cadastrarCliente() {
        var clienteController = new ClienteController();
        var cliente = new Cliente("Carlos", "123", "ca@ca.com");

        clienteController.cadastrarCliente(cliente);

        var cliente1 = clienteController.buscaCliente(cliente.getCpf());

        Assertions.assertEquals(cliente, cliente1);
    }
    @Test
    void cadastrarClienteJaExistente() {
        var clienteController = new ClienteController();
        var cliente = new Cliente("Carlos", "123", "ca@ca.com");
        clienteController.cadastrarCliente(cliente);

        try {
            clienteController.cadastrarCliente(cliente);
            Assertions.fail();
        } catch (Exception ex){
            Assertions.assertNotNull(ex);
        }


    }

    @Test
    void listaClientes() {
    }

    @Test
    void buscaCliente() {
    }
}