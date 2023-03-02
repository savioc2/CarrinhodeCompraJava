package br.com.improving.carrinho;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Classe que representa o carrinho de compras de um cliente.
 */
public class CarrinhoCompras {
	private List<Item> itensList;
    /**
     * Permite a adição de um novo item no carrinho de compras.
     *
     * Caso o item já exista no carrinho para este mesmo produto, as seguintes regras deverão ser seguidas:
     * - A quantidade do item deverá ser a soma da quantidade atual com a quantidade passada como parâmetro.
     * - Se o valor unitário informado for diferente do valor unitário atual do item, o novo valor unitário do item deverá ser
     * o passado como parâmetro.
     *
     * Devem ser lançadas subclasses de RuntimeException caso não seja possível adicionar o item ao carrinho de compras.
     *
     * @param produto
     * @param valorUnitario
     * @param quantidade
     */
	
	//Permite a adição de um novo item no carrinho de compras.
	public void adicionarItem(Produto produto, BigDecimal valorUnitario, int quantidade) {
		int posicaoAdicionar = -1; // Variavel local para marcar a posicao do item na lista.
		Item itemTemporario, itemAtualizado, itemPosicao;
		for (int i = 0; i < getItens().size() && posicaoAdicionar < 0; i++) {
			itemTemporario = itensList.get(i);
			if (itemTemporario.getProduto().equals(produto)) {
				posicaoAdicionar = i;
			}
		}
		try {

			if (posicaoAdicionar < 0) {
				itemAtualizado = new Item(produto, valorUnitario, quantidade);
				itemAtualizado.setValorAux(itemAtualizado.getValorAux());
				getItens().add(itemAtualizado);
			} else {
				itemPosicao = itensList.get(posicaoAdicionar);
				int quantidadeAtualizada = itemPosicao.getQuantidade() + quantidade;
				BigDecimal valorUnitarioAtualizado =
						itemPosicao.getValorUnitario().equals(valorUnitario)
								? itemPosicao.getValorUnitario() : valorUnitario;
				Item novoItem = new Item(produto, valorUnitarioAtualizado, quantidadeAtualizada);
				novoItem.setValorAux(novoItem.getValorTotal());
				itensList.set(posicaoAdicionar, novoItem);
			}
		} catch (RuntimeException e) {
			e.printStackTrace(); //erros de leitura e gravação(caso lance a exception, mostrar no console)
		}
	}

    /**
     * Permite a remoção do item que representa este produto do carrinho de compras.
     *
     * @param produto
     * @return Retorna um boolean, tendo o valor true caso o produto exista no carrinho de compras e false
     * caso o produto não exista no carrinho.
     */
	public boolean removerItem(Produto produto) {
		int posicaoRemover = -1; // Variavel local para marcar a posicao do item na lista.
		Item itemTemporarioRemover;
		for (int i = 0; i < getItens().size() && posicaoRemover < 0; i++) {
			itemTemporarioRemover = itensList.get(i);

			if (itemTemporarioRemover.getProduto().equals(produto)) {
				posicaoRemover = i;
			}
		}
		if (posicaoRemover > -1) {
			getItens().remove(posicaoRemover);
			return true;
		} else {
			return false;
		}

	}

    /**
     * Permite a remoção do item de acordo com a posição.
     * Essa posição deve ser determinada pela ordem de inclusão do produto na 
     * coleção, em que zero representa o primeiro item.
     *
     * @param posicaoItem
     * @return Retorna um boolean, tendo o valor true caso o produto exista no carrinho de compras e false
     * caso o produto não exista no carrinho.
     */
	public boolean removerItem(int posicaoItem) {
		try {
			itensList.remove(posicaoItem);
			return true;
		} catch (IndexOutOfBoundsException e) { // A posição passada não existe na lista
			return false;
			/*
			 * } catch (UnsupportedOperationException e) { // A lista não suporta a operação de
			 * remoção return false;
			 */
		} catch (NullPointerException e) { // A lista é nula
			return false;
		}
		
	}

    /**
     * Retorna o valor total do carrinho de compras, que deve ser a soma dos valores totais
     * de todos os itens que compõem o carrinho.
     *
     * @return BigDecimal
     */
    public BigDecimal getValorTotal() {
    	 BigDecimal valorTotal = BigDecimal.ZERO;
    	    for (Item item : getItens()) {
    	        valorTotal = valorTotal.add(item.getValorTotal());
    	    }
    	    return valorTotal; 
    }

    /**
     * Retorna a lista de itens do carrinho de compras.
     *
     * @return itens
     */
    public Collection<Item> getItens() {
    	if(itensList == null) { //itensList.equals()
    		itensList = new ArrayList<>();
    	}
    		return itensList;
    	}
    }

	/*
	 * public List<Item> getItensList() { return itensList; }
	 * 
	 * public void setItensList(List<Item> itensList) { this.itensList = itensList; }
	 */