package vendas;

public class VendasController {
    BDVendas bdVendas = new BDVendas();


    public void cadastrarVendas(Vendas vendas) {
        if (bdVendas.listaDeVendaJaExistente(String.valueOf(vendas))) {
            throw new IllegalArgumentException("lista de vendas ja Existente");
        }
        bdVendas.adicionarVenda(vendas);
    }

    public void listaDeVendas() {
        bdVendas.listaDeVendas();

    }

    public void cadastrarCliente(Cliente cliente) {
        if (bdVendas.listaDeClienteJaExistente(String.valueOf(cliente))) {
            throw new IllegalArgumentException("Cliente ja Existente");
        }
        bdVendas.adicionarCliente(cliente);
    }

    public void listaClientes() {
        bdVendas.listaDeClientes();
    }

    public void listaDeVendedores() {
        bdVendas.listaDeVendedores();
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
        throw new IllegalArgumentException("necessario um email valido");

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


