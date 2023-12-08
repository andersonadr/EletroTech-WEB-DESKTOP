/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import eletro.teck.ConnectionDataBase;
import eletro.teck.telaOS1;
import eletro.teck.telaOS2;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ander
 */
public class AgendamentoDAO extends ConnectionDataBase {

    private ConnectionDataBase ConnectionDataBase;
    private Connection conn;

    public AgendamentoDAO() {
        this.ConnectionDataBase = new ConnectionDataBase();
        this.conn = ConnectionDataBase.getConnection();
    }
    
    public List<Agendamento> ListarUsers() {
        
        String sql = "SELECT idagendamento, nome, telefone, endereco, nomeTecnico, dia, escolha, pagamento, descricao FROM agendamento";
        
        List<Agendamento> agendamentos = new ArrayList<Agendamento>();
        
        Connection conn = null;
        PreparedStatement pstm = null;
        
        // Classe para recuperar os dados do banco ** SELECT ** 
        ResultSet rset = null;
        
        try {
            
            // Criando conexao com o banco de dados 
            conn = ConnectionDataBase.getConnection();
            
            // Executando a conexao juntamente com a query
            pstm = (PreparedStatement) conn.prepareStatement(sql);
            
            rset = pstm.executeQuery();
            
            while (rset.next()) {                
                 
                Agendamento agendas = new Agendamento();
                
                agendas.setIdagendamento(rset.getInt("idagendamento"));
                agendas.setNome(rset.getString("nome"));
                agendas.setTelefone(rset.getString("telefone"));
                agendas.setEndereco(rset.getString("endereco"));
                agendas.setNomeTecnico(rset.getString("nomeTecnico"));
                agendas.setDia(rset.getString("dia"));
                agendas.setEscolha(rset.getString("escolha"));
                agendas.setPagamento(rset.getString("pagamento"));
                agendas.setDescricao(rset.getString("descricao"));
                
                agendamentos.add(agendas);
                
            }
            
        } catch (Exception e) {
            
            e.printStackTrace();
            System.out.println("Error ao listar Usuários!!");
              
        }  finally {
            
            try {
                
                if (pstm != null) {
                    pstm.close(); 
                }
                if (conn != null) {
                    conn.close();
                }
                
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        }
        
        return agendamentos;
        
    }
    
        public void ListUsuarios(telaOS1 tos) {
        DefaultTableModel model = (DefaultTableModel) tos.jTable1.getModel();

        AgendamentoDAO agendamentodao = new AgendamentoDAO();
        for (Agendamento agendamento : agendamentodao.ListarUsers()) {
            Object[] row = {
                agendamento.getIdagendamento(),
                agendamento.getNome(),
                agendamento.getTelefone(),
                agendamento.getEndereco(),
                agendamento.getNomeTecnico(),
                agendamento.getDia(),
                agendamento.getEscolha(),
                agendamento.getPagamento(),
                agendamento.getDescricao()
            };
            model.addRow(row);
        }
    }
        
                public void ListUsuariosOS2(telaOS2 tos) {
        DefaultTableModel model = (DefaultTableModel) tos.jTable1.getModel();

        AgendamentoDAO agendamentodao = new AgendamentoDAO();
        for (Agendamento agendamento : agendamentodao.ListarUsers()) {
            Object[] row = {
                agendamento.getIdagendamento(),
                agendamento.getNome(),
                agendamento.getTelefone(),
                agendamento.getEndereco(),
                agendamento.getNomeTecnico(),
                agendamento.getDia(),
                agendamento.getEscolha(),
                agendamento.getPagamento(),
                agendamento.getDescricao()
            };
            model.addRow(row);
        }
    }

    public void atualizar(Agendamento agendamento) {
        String sql = "UPDATE agendamento SET nome = ?, telefone = ?, endereco = ?, nomeTecnico = ?, dia = ?, escolha = ?, pagamento = ?, descricao = ? WHERE idagendamento = ?";

        try (Connection conn = ConnectionDataBase.getConnection();
             PreparedStatement pstm = conn.prepareStatement(sql)) {

            pstm.setString(1, agendamento.getNome());
            pstm.setString(2, agendamento.getTelefone());
            pstm.setString(3, agendamento.getEndereco());
            pstm.setString(4, agendamento.getNomeTecnico());
            pstm.setString(5, agendamento.getDia());
            pstm.setString(6, agendamento.getEscolha());
            pstm.setString(7, agendamento.getPagamento());
            pstm.setString(8, agendamento.getDescricao());
            pstm.setInt(9, agendamento.getIdagendamento());

            pstm.execute();

            JOptionPane.showMessageDialog(null, "Ordem de serviço atualizado com sucesso!", "Confirmação", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao tentar atualizar o serviço!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void excluir(int id) {
        String sql = "DELETE FROM agendamento WHERE idagendamento = ?";

        try (Connection conn = ConnectionDataBase.getConnection();
             PreparedStatement pstm = conn.prepareStatement(sql)) {

            pstm.setInt(1, id);
            pstm.execute();

            JOptionPane.showMessageDialog(null, "Ordem de serviço excluído com sucesso!", "Confirmação", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao tentar excluir a ordem de serviço!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
