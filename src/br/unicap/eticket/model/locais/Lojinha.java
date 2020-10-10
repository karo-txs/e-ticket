package br.unicap.eticket.model.locais;

import java.util.ArrayList;
import java.util.List;

public class Lojinha {
     /* NÃO IMPLEMENTADO */
    //LocalId?
    List<Item> itens;
    
    public Lojinha(){
        itens = new ArrayList<>();
    }
    
    public Lojinha(Item... params){
        itens = new ArrayList<>();
        for(int i=0;i<params.length;i++){
            itens.add(params[i]);
        }
    }
    
    public void registrarVenda(Item i){
        
    }
    
    public void addItem(String nome, String descricao,double valor){
        itens.add(new Item(nome,descricao,valor));
    }
    
    public Item buscarItem(Item i){
        return itens.get(itens.indexOf(i));
    }
    
    public List<Item> getItens(){
        return this.itens;
    }
    
    public void alterarItem(Item antigo, Item novo){
        this.itens.get(itens.indexOf(antigo)).setNome(novo.getNome());
        this.itens.get(itens.indexOf(antigo)).setValor(novo.getValor());
        this.itens.get(itens.indexOf(antigo)).setDescricao(novo.getDescricao());
    }
    
    public void removerItem(Item i){
        itens.remove(i);
    }
    
    public class Item{
        private String nome;
        private String descricao;
        private double valor;

        public Item(String nome,String descricao, double valor) {
            this.nome = nome;
            this.descricao=descricao;
            this.valor = valor;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public double getValor() {
            return valor;
        }

        public void setValor(double valor) {
            this.valor = valor;
        }

        public String getDescricao() {
            return descricao;
        }

        public void setDescricao(String descricao) {
            this.descricao = descricao;
        }
    }
}
