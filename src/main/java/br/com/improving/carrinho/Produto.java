package br.com.improving.carrinho;

import java.math.BigDecimal;

/**
 * Classe que representa um produto que pode ser adicionado
 * como item ao carrinho de compras.
 *
 * Importante: Dois produtos são considerados iguais quando ambos possuem o
 * mesmo código.
 */
public class Produto {

    private Long codigo;
    private String descricao;
  
    /**
     * Construtor da classe Produto.
     *
     * @param codigo
     * @param descricao
     */
    public Produto(Long codigo, String descricao) {
    	this.codigo = codigo;
    	this.descricao = descricao;
    }
    
    /**
     * Retorna o código da produto.
     *
     * @return Long
     */
  
    public Long getCodigo() {
    	return codigo;
    }
    public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
    
    /**
     * Retorna a descrição do produto.
     *
     * @return String
     */

    public String getDescricao() {
    	return descricao;
    }
    public void setDescricao(String descricao) {
		this.descricao= descricao;
	}
    //
}