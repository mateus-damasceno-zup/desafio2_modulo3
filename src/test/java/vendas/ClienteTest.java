package vendas;

import vendas.Model.Cliente;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ClienteTest {

    @Test
    public void createClienteTest(){
        var cliente = new Cliente("Jose", "123", "jose@mail.com");

        Assertions.assertNotNull(cliente);

        Assertions.assertEquals("Jose", cliente.getNome());
        Assertions.assertEquals("123", cliente.getCpf());
        Assertions.assertEquals("jose@mail.com", cliente.getEmail());




    }

    @Test
    public void createClienteConstrutorVazioTest(){
        var cliente = new Cliente();

        Assertions.assertNotNull(cliente);

        Assertions.assertNull( cliente.getNome());
        Assertions.assertNull(cliente.getCpf());
        Assertions.assertNull( cliente.getEmail());




    }


}