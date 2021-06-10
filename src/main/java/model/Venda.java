package model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
public class Venda {

    @Id
    private String _id;
    private float qtdProdutoVenda;
    private Produto produto;
    private String formaPagamento;
    private Date date;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public float getQtdProdutoVenda() {
        return qtdProdutoVenda;
    }

    public void setQtdProdutoVenda(float qtdProdutoVenda) {
        this.qtdProdutoVenda = qtdProdutoVenda;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
