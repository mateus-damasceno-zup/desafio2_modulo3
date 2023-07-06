package vendas.controller;

import vendas.Model.Vendedor;
import vendas.bd.BDVendedor;

public class VendedorController {

    BDVendedor bdVendedor = new BDVendedor();
    public void listaDeVendedores() {
        System.out.println(bdVendedor.listaDeVendedores());

    }
    public void cadastrarVendedor(Vendedor vendedor) {
        if (bdVendedor.listaDeVendedoresJaExistente(String.valueOf(vendedor))) {
            throw new IllegalArgumentException("Vendedor ja Existente");
        }
        bdVendedor.adicionarVendedor(vendedor);
    }

    public String validaCPFVendedor(String cpf){
        if(bdVendedor.listaDeVendedoresJaExistente(cpf)) {
            throw new IllegalArgumentException("vendedor ja existente");
        }
        return cpf;
    }
    public Vendedor buscaVendedor(String cpfVendedor) {
        if (bdVendedor.listaDeVendedoresJaExistente(cpfVendedor)) {
            return bdVendedor.retornarVendedor(cpfVendedor);

        }
        throw new IllegalArgumentException("vendedor nao encontrado");

    }
    public String validaEmailVendedor(String emailVendedor) {
        if (emailVendedor.contains("@")) {
            for (Vendedor v : bdVendedor.listaDeVendedores()) {
                if (!v.getEmail().equalsIgnoreCase(emailVendedor)) {
                    return emailVendedor;
                }

            }

        }
        throw new IllegalArgumentException("necessario um email valido ou nao repetido");
    }


}
