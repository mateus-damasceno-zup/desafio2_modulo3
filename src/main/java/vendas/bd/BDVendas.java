package vendas.bd;

import vendas.Model.Cliente;
import vendas.Model.Vendas;
import vendas.Model.Vendedor;

import java.util.ArrayList;
import java.util.List;

public class BDVendas {


    private List<Vendas> vendas = new ArrayList<>();



    public BDVendas(List<Cliente> clientes,List<Vendedor> vendedores){
        iniciarBancoVendas(clientes,vendedores);
    }

    public void iniciarBancoVendas(List<Cliente> clientes, List<Vendedor> vendedor){


        adicionarVenda(new Vendas(clientes.get(0),vendedor.get(0),400.00,"03/07/2023"));
        adicionarVenda(new Vendas(clientes.get(1),vendedor.get(1),300.00,"21/07/2023"));
        adicionarVenda(new Vendas(clientes.get(2),vendedor.get(2),2222.22,"11/06/2023"));
        adicionarVenda(new Vendas(clientes.get(3),vendedor.get(3),53.23,"12/06/2023"));
        adicionarVenda(new Vendas(clientes.get(4),vendedor.get(4),2342.43,"05/12/2013"));


    }

    public void adicionarVenda(Vendas listaDeVendas){
        this.vendas.add(listaDeVendas);
        System.out.println("venda adicionada");
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





    public void excluirVenda(Vendas vendaId){
        this.vendas.remove(vendaId);
        System.out.println("lista removida");
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
