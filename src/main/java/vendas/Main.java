package vendas;


import vendas.Model.Cliente;
import vendas.Model.Vendas;
import vendas.Model.Vendedor;
import vendas.controller.ClienteController;
import vendas.controller.VendasController;
import vendas.controller.VendedorController;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ClienteController clienteController = new ClienteController();
        VendasController vendasController = new VendasController();
        VendedorController vendedorController = new VendedorController();
        Cliente cliente;
        Vendedor vendedor;
        Scanner sc = new Scanner(System.in);
        int opcao;
        do {
            System.out.println("""
                    digite uma das opçoes abaixo
                    1- adicionar uma venda ao banco
                    2- listar vendas
                    3- excluir venda
                    4- listar clientes
                    5- cadastrar clientes
                    6- listar Vendedores
                    7- cadastrar Vendedores
                    8- lista vendas do cliente
                    9- lista vendas por vendedor
                    -1 para sair""");




            opcao = sc.nextInt();
            switch (opcao) {
                case 1 -> {
                    sc.nextLine();
                    System.out.println("=======Cadastro de vendas===============");
                    System.out.println("digite o cpf do cliente");
                    String cpfCliente = sc.nextLine();
                    Cliente clienteEncontrado = clienteController.buscaCliente(cpfCliente);
                    System.out.println("digite o cpf do vendedor");
                    String cpfVendedor = sc.nextLine();
                    Vendedor vendedorEncontrado = vendedorController.buscaVendedor(cpfVendedor);
                    System.out.println("digite o valor da compra");
                    double valor = sc.nextDouble();
                    sc.nextLine();
                    System.out.println("digite a data da compra");
                    String data = sc.nextLine();
                    Vendas vendas = new Vendas(clienteEncontrado, vendedorEncontrado, valor, data);
                    vendasController.cadastrarVendas(vendas);
                }
                case 2 -> {
                    System.out.println("====HISTORICO DE VENDAS===========");
                    vendasController.listaDeVendas();
                }
                case 3 -> {
                    System.out.println("========Excluir uma venda=========");
                    System.out.println("digite o id da lista para excluir");
                    int idVenda = sc.nextInt();
                    vendasController.excluirListaDeVendas(idVenda);
                }
                case 4 -> {
                    System.out.println("========lista de clientes=========");
                    clienteController.listaClientes();
                }
                case 5 -> {
                    sc.nextLine();
                    System.out.println("=======cadastro de cliente=======");
                    System.out.println("digite o nome do cliente");
                    String nomeCliente = sc.nextLine();
                    System.out.println("digite o cpf do cliente");
                    String cpfCliente = sc.nextLine();
                    String cpfClienteVerificado = vendasController.validaCPFCliente(cpfCliente);
                    System.out.println("digite o email do cliente");
                    String emailCliente = sc.nextLine();
                    String emailClienteVerificado = clienteController.validaEmailCliente(emailCliente);
                    cliente = new Cliente(nomeCliente, cpfClienteVerificado, emailClienteVerificado);
                    clienteController.cadastrarCliente(cliente);
                }
                case 6 -> {
                    System.out.println("=======lista de vendedores======");
                    vendedorController.listaDeVendedores();
                }
                case 7 -> {
                    sc.nextLine();
                    System.out.println("=======cadastro de vendedores=======");
                    System.out.println("digite o nome do vendedor");
                    String nomeVendedor = sc.nextLine();
                    System.out.println("digite o cpf do vendedor");
                    String cpfVendedor = sc.nextLine();
                    String cpfVendedorValidado = vendedorController.validaCPFVendedor(cpfVendedor);
                    System.out.println("digite o email do vendedor");
                    String emailVendedor = sc.nextLine();
                    String emailVendedorValidado = vendedorController.validaEmailVendedor(emailVendedor);
                    vendedor = new Vendedor(nomeVendedor, cpfVendedorValidado, emailVendedorValidado);
                    vendedorController.cadastrarVendedor(vendedor);
                }
                case 8 -> {
                    sc.nextLine();
                    System.out.println("====busca venda por cpf======");
                    System.out.println("digite o cpf do cliente");
                    String cpfCliente = sc.nextLine();
                    System.out.println(vendasController.buscaVendaCliente(cpfCliente));
                }
                case 9 -> {
                    sc.nextLine();
                    System.out.println("====busca vendas por email do vendedor======");
                    System.out.println("digite o email do vendedor");
                    String emailVendedor = sc.nextLine();
                    System.out.println(vendasController.buscaVendaVendedor(emailVendedor));
                }
                default -> System.out.println("digite um valor valido");
            }
        } while (opcao != -1);
    }
}


