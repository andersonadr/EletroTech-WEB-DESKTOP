/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

/**
 *
 * @author ander
 */
public class Agendamento {
    
    private int idagendamento;
    private String nome;
    private String telefone;
    private String endereco;
    private String nomeTecnico;
    private String dia;
    private String escolha;
    private String pagamento;
    private String descricao;

    public Agendamento(){
        
    }
    
    public Agendamento(int idagendamento,String nome,String telefone,String endereco,String nomeTecnico,String dia,String escolha,String pagamento,String descricao){
        this.idagendamento = idagendamento;
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.nomeTecnico =nomeTecnico;
        this.dia = dia;
        this.escolha = escolha;
        this.pagamento = pagamento;
        this.descricao = descricao;
    }

    public int getIdagendamento() {
        return idagendamento;
    }

    public void setIdagendamento(int idagendamento) {
        this.idagendamento = idagendamento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNomeTecnico() {
        return nomeTecnico;
    }

    public void setNomeTecnico(String nomeTecnico) {
        this.nomeTecnico = nomeTecnico;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getEscolha() {
        return escolha;
    }

    public void setEscolha(String escolha) {
        this.escolha = escolha;
    }

    public String getPagamento() {
        return pagamento;
    }

    public void setPagamento(String pagamento) {
        this.pagamento = pagamento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
