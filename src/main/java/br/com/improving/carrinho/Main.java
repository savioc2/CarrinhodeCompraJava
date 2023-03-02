package br.com.improving.carrinho;

import java.math.BigDecimal;

public class Main {
	public static void main(String[] args) {
		
		  Produto produto1 = new Produto(1L, "Celular"); Produto produto2 = new Produto(2L,
		  "Notebook");
		  
		  System.out.println("Código do produto 1: " + produto1.getCodigo());
		  System.out.println("Descrição do produto 1: " + produto1.getDescricao());
		  System.out.println("Código do produto 2: " + produto2.getCodigo());
		  System.out.println("Descrição do produto 2: " + produto2.getDescricao());
		 
		
		  Produto celular = new Produto(1L, "Celular"); BigDecimal valorUnitario = new
		  BigDecimal("1000.00"); int quantidade = 2;
		  
		  Item item = new Item(celular, valorUnitario, quantidade);
		  
		  System.out.println("Produto: " + item.getProduto().getDescricao());
		  System.out.println("Valor unitário: " + item.getValorUnitario());
		  System.out.println("Quantidade: " + item.getQuantidade());
		  System.out.println("Valor total: " + item.getValorTotal()); System.out.println("Item: " +
		  item.toString());
		 

		
		  CarrinhoCompras carrinho = new CarrinhoCompras();
		  
		  Produto produto1 = new Produto(1L, "Coca-cola"); BigDecimal valor1 = new
		  BigDecimal("5.00"); carrinho.adicionarItem(produto1, valor1, 2); Produto produto2 = new
		  Produto(2L, "Pepsi"); BigDecimal valor2 = new BigDecimal("4.50");
		  carrinho.adicionarItem(produto2, valor2, 1);
		  
		  Produto produto3 = new Produto(3L, "Doritos"); BigDecimal valor3 = new
		  BigDecimal("8.00"); carrinho.adicionarItem(produto3, valor3, 3);
		  
		  carrinho.removerItem(1);
		  
		  System.out.println("Valor total do carrinho: " + carrinho.getValorTotal());
		 
		
		CarrinhoComprasFactory factory = new CarrinhoComprasFactory();

		// Criando carrinho de compras para o cliente A
		CarrinhoCompras carrinhoA = factory.criar("A");

		// Adicionando produtos ao carrinho A
		Produto produto1 = new Produto(1L, "Coca-cola"); 
		BigDecimal valor1 = new BigDecimal("5.00");
		carrinhoA.adicionarItem(produto1, valor1, 2); 
		Produto produto2 = new Produto(2L, "Pepsi"); 
		BigDecimal valor2 = new BigDecimal("4.50");
		carrinhoA.adicionarItem(produto2, valor2, 1);
		// Criando carrinho de compras para o cliente B
		CarrinhoCompras carrinhoB = factory.criar("B");

		Produto produto3 = new Produto(1L, "Coca"); 
		BigDecimal valor3 = new BigDecimal("5.00");
		carrinhoB.adicionarItem(produto3, valor3, 2); 
		Produto produto4 = new Produto(2L, "Pepsigrande"); 
		BigDecimal valor4 = new BigDecimal("4.50");
		carrinhoB.adicionarItem(produto4, valor4, 1);

		// Imprimindo valor total dos carrinhos de compras
		System.out.println("Valor total do carrinho A: " + carrinhoA.getValorTotal());
		System.out.println("Valor total do carrinho B: " + carrinhoB.getValorTotal());

		// Imprimindo valor médio dos carrinhos de compras
		System.out.println("Valor médio dos carrinhos de compras: " + factory.getValorTicketMedio());

		// Invalidando o carrinho de compras do cliente A
		boolean carrinhoInvalidado = factory.invalidar("A");
		if (carrinhoInvalidado) {
			System.out.println("Carrinho de compras do cliente A foi invalidado.");
		} else {
			System.out.println("Não foi possível invalidar o carrinho de compras do cliente A.");
		}

	}

}
