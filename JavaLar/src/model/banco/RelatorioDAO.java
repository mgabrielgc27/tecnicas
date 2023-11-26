package model.banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import controller.Relatorio;

public class RelatorioDAO {
	
	public ArrayList<Relatorio> selecionarTodosDados(){
		ArrayList<Relatorio> relatorios = new ArrayList<Relatorio>();
		
		Connection conexao = new Conexao().getConexao();
		String query = "select * from javalar order by id asc";
		
		try {
			
			ResultSet dados = conexao.prepareStatement(query).executeQuery();
			while (dados.next()) {
				Relatorio r = new Relatorio();
				
				r.setId(dados.getInt("id"));
				r.setNome(dados.getString("nome"));
				r.setMatricula(dados.getInt("matricula"));
				r.setNome_arquivo(dados.getString("nome_arquivo"));
				r.getBugsPlanetas()[0] = dados.getInt("bug_python");
				r.getBugsPlanetas()[1] = dados.getInt("bug_javascript");
				r.getBugsPlanetas()[2] = dados.getInt("bug_ruby");
				r.getBugsPlanetas()[3] = dados.getInt("bug_php");
				r.getBugsPlanetas()[4] = dados.getInt("bug_csharp");
				r.getBugsPlanetas()[5] = dados.getInt("bug_cmais");
				r.getBugsPlanetas()[6] = dados.getInt("bug_c");
				r.getDevsPlanetas()[0] = dados.getInt("dev_python");
				r.getDevsPlanetas()[1] = dados.getInt("dev_javascript");
				r.getDevsPlanetas()[2] = dados.getInt("dev_ruby");
				r.getDevsPlanetas()[3] = dados.getInt("dev_php");
				r.getDevsPlanetas()[4] = dados.getInt("dev_csharp");
				r.getDevsPlanetas()[5] = dados.getInt("dev_cmais");
				r.getDevsPlanetas()[6] = dados.getInt("dev_c");
				r.getDevsPlanetas()[0] = dados.getInt("dev_python");
				r.getDevsPlanetas()[1] = dados.getInt("dev_javascript");
				r.getDevsPlanetas()[2] = dados.getInt("dev_ruby");
				r.getDevsPlanetas()[3] = dados.getInt("dev_php");
				r.getDevsPlanetas()[4] = dados.getInt("dev_csharp");
				r.getDevsPlanetas()[5] = dados.getInt("dev_cmais");
				r.getDevsPlanetas()[6] = dados.getInt("dev_c");
				r.getVeloPlanetas()[0] = dados.getInt("v_python");
				r.getVeloPlanetas()[1] = dados.getInt("v_javascript");
				r.getVeloPlanetas()[2] = dados.getInt("v_ruby");
				r.getVeloPlanetas()[3] = dados.getInt("v_php");
				r.getVeloPlanetas()[4] = dados.getInt("v_csharp");
				r.getVeloPlanetas()[5] = dados.getInt("v_cmais");
				r.getVeloPlanetas()[6] = dados.getInt("v_c");
				r.getDiasPlanetas()[0] = dados.getInt("d_python");
				r.getDiasPlanetas()[1] = dados.getInt("d_javascript");
				r.getDiasPlanetas()[2] = dados.getInt("d_ruby");
				r.getDiasPlanetas()[3] = dados.getInt("d_php");
				r.getDiasPlanetas()[4] = dados.getInt("d_csharp");
				r.getDiasPlanetas()[5] = dados.getInt("d_cmais");
				r.getDiasPlanetas()[6] = dados.getInt("d_c");
				r.getAnosPlanetas()[0] = dados.getInt("a_python");
				r.getAnosPlanetas()[1] = dados.getInt("a_javascript");
				r.getAnosPlanetas()[2] = dados.getInt("a_ruby");
				r.getAnosPlanetas()[3] = dados.getInt("a_php");
				r.getAnosPlanetas()[4] = dados.getInt("a_csharp");
				r.getAnosPlanetas()[5] = dados.getInt("a_cmais");
				r.getAnosPlanetas()[6] = dados.getInt("a_c");
				r.getBugsQuadrantes()[0] = dados.getInt("bug_q1");
				r.getBugsQuadrantes()[1] = dados.getInt("bug_q2");
				r.getBugsQuadrantes()[2] = dados.getInt("bug_q3");
				r.getBugsPlanetas()[3] = dados.getInt("bug_q4");
				r.getDevsQuadrantes()[0] = dados.getInt("dev_q1");
				r.getDevsQuadrantes()[1] = dados.getInt("dev_q2");
				r.getDevsQuadrantes()[2] = dados.getInt("dev_q3");
				r.getDevsQuadrantes()[3] = dados.getInt("dev_q4");
				
				relatorios.add(r);
			}
//			relatorios.add(new Relatorio().receberDados(dados));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(conexao != null)
				try {
					conexao.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		
		return relatorios;
	}
	
	public void inserirDados(Relatorio relatorio) {
		
		Connection conexao = new Conexao().getConexao();
		try {		
			
			PreparedStatement inserir = conexao.prepareStatement("insert into javalar (nome, matricula, nome_arquivo,"
					+ " bug_python, bug_javascript, bug_ruby, bug_php, bug_csharp, bug_cmais, bug_c,"
					+ " dev_python, dev_javascript, dev_ruby, dev_php, dev_csharp, dev_cmais, dev_c,"
					+ " v_python, v_javascript, v_ruby, v_php, v_csharp, v_cmais, v_c,"
					+ " d_python, d_javascript, d_ruby, d_php, d_csharp, d_cmais, d_c,"
					+ " a_python, a_javascript, a_ruby, a_php, a_csharp, a_cmais, a_c,"
					+ " bug_q1, bug_q2, bug_q3, bug_q4,"
					+ " dev_q1, dev_q2, dev_q3, dev_q4)"
					+ " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,"
					+ " ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			
			inserir.setString(1, relatorio.getNome());
			inserir.setInt(2, relatorio.getMatricula());
			inserir.setString(3, relatorio.getNome_arquivo());
			inserir.setInt(4, relatorio.getBugsPlanetas()[0]);
			inserir.setInt(5, relatorio.getBugsPlanetas()[1]);
			inserir.setInt(6, relatorio.getBugsPlanetas()[2]);
			inserir.setInt(7, relatorio.getBugsPlanetas()[3]);
			inserir.setInt(8, relatorio.getBugsPlanetas()[4]);
			inserir.setInt(9, relatorio.getBugsPlanetas()[5]);
			inserir.setInt(10, relatorio.getBugsPlanetas()[6]);
			inserir.setInt(11, relatorio.getDevsPlanetas()[0]);
			inserir.setInt(12, relatorio.getDevsPlanetas()[1]);
			inserir.setInt(13, relatorio.getDevsPlanetas()[2]);
			inserir.setInt(14, relatorio.getDevsPlanetas()[3]);
			inserir.setInt(15, relatorio.getDevsPlanetas()[4]);
			inserir.setInt(16, relatorio.getDevsPlanetas()[5]);
			inserir.setInt(17, relatorio.getDevsPlanetas()[6]);
			inserir.setInt(18, relatorio.getVeloPlanetas()[0]);
			inserir.setInt(19, relatorio.getVeloPlanetas()[1]);
			inserir.setInt(20, relatorio.getVeloPlanetas()[2]);
			inserir.setInt(21, relatorio.getVeloPlanetas()[3]);
			inserir.setInt(22, relatorio.getVeloPlanetas()[4]);
			inserir.setInt(23, relatorio.getVeloPlanetas()[5]);
			inserir.setInt(24, relatorio.getVeloPlanetas()[6]);
			inserir.setInt(25, relatorio.getDiasPlanetas()[0]);
			inserir.setInt(26, relatorio.getDiasPlanetas()[1]);
			inserir.setInt(27, relatorio.getDiasPlanetas()[2]);
			inserir.setInt(28, relatorio.getDiasPlanetas()[3]);
			inserir.setInt(29, relatorio.getDiasPlanetas()[4]);
			inserir.setInt(30, relatorio.getDiasPlanetas()[5]);
			inserir.setInt(31, relatorio.getDiasPlanetas()[6]);
			inserir.setInt(32, relatorio.getAnosPlanetas()[0]);
			inserir.setInt(33, relatorio.getAnosPlanetas()[1]);
			inserir.setInt(34, relatorio.getAnosPlanetas()[2]);
			inserir.setInt(35, relatorio.getAnosPlanetas()[3]);
			inserir.setInt(36, relatorio.getAnosPlanetas()[4]);
			inserir.setInt(37, relatorio.getAnosPlanetas()[5]);
			inserir.setInt(38, relatorio.getAnosPlanetas()[6]);
			inserir.setInt(39, relatorio.getBugsQuadrantes()[0]);
			inserir.setInt(40, relatorio.getBugsQuadrantes()[1]);
			inserir.setInt(41, relatorio.getBugsQuadrantes()[2]);
			inserir.setInt(42, relatorio.getBugsQuadrantes()[3]);
			inserir.setInt(43, relatorio.getDevsQuadrantes()[0]);
			inserir.setInt(44, relatorio.getDevsQuadrantes()[1]);
			inserir.setInt(45, relatorio.getDevsQuadrantes()[2]);
			inserir.setInt(46, relatorio.getDevsQuadrantes()[3]);
		
			inserir.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(conexao != null)
				try {
					conexao.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			
		}
		
	}
	
}
