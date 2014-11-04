package br.com.buritech.curso.jee.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.buritech.curso.jee.model.bean.Empresa;
import br.com.buritech.curso.jee.model.connection.ConnectionFactory;

public class EmpresaDAO {

	/**
	 * Estabelece conexão com o banco
	 * 
	 * @return connect
	 */
	public Connection connectBD() {
		return ConnectionFactory.getConnection();
	}

	/**
	 * Insert a company in BD
	 * 
	 * @param empresa
	 */
	public void insertCompany(Empresa empresa) {
		// estabelecendo conexão com o BD
		Connection connect = connectBD();

		// instrução sql para inserir registro
		String sql = "Insert into empresa ("
				+ "cnpj, razaosocial, endereco, telefone, site, email, dtcriacao) "
				+ "values (?, ?, ?, ?, ?, ?, ?)";

		// criando o objeto de execução de comando do SQL
		PreparedStatement preparation = null;

		try {
			preparation = connect.prepareStatement(sql);

			// passando os parametros para a sql
			preparation.setString(1, empresa.getCnpj());
			preparation.setString(2, empresa.getRazaoSocial());
			preparation.setString(3, empresa.getEndereco());
			preparation.setString(4, empresa.getTelefone());
			preparation.setString(5, empresa.getSite());
			preparation.setString(6, empresa.getEmail());
			preparation.setDate(7, new Date(empresa.getDataCriacao()
					.getTimeInMillis()));

			// executando o comando SQL
			preparation.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// Fechando a conexão
			closeConnection(connect, preparation);
		}
	}

	public List<Empresa> listAllCompany() {
		// crinando a coleção de empresas
		List<Empresa> listEmpresas = new ArrayList<Empresa>();

		// criando a conexão com o banco
		Connection connect = connectBD();

		// criando a instrução sql
		String sql = "select * from empresa";

		// criando objeto de execução de comando SQL
		PreparedStatement preparation = null;

		// criando o objeto que recebe o resultado da execução da SQL
		ResultSet result = null;

		try {
			preparation = connect.prepareStatement(sql);

			result = preparation.executeQuery();

			while (result.next()) {
				Empresa empresa = new Empresa();

				// set o objeto empresa
				empresa.setId(result.getLong("id"));
				empresa.setCnpj(result.getString("cnpj"));
				empresa.setRazaoSocial(result.getString("razaosocial"));
				empresa.setEndereco(result.getString("endereco"));
				empresa.setTelefone(result.getString("telefone"));
				empresa.setSite(result.getString("site"));
				empresa.setEmail(result.getString("email"));

				Calendar dataCriacao = Calendar.getInstance();
				dataCriacao.setTime(result.getDate("dtcriacao"));
				empresa.setDataCriacao(dataCriacao);

				// adicionando a empresa na lista de empresas
				listEmpresas.add(empresa);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// Fechando a conexão
			closeConnection(connect, preparation);
		}

		return listEmpresas;
	}

	public Empresa searchCompany(Long idEmpresa) {
		// criando a conexão com o banco
		Connection connect = connectBD();

		// criando a instrução sql
		String sql = "select * from empresa where id = ?";

		// criando objeto de execução de comando SQL
		PreparedStatement preparation = null;

		// criando o objeto que recebe o resultado da execução da SQL
		ResultSet result = null;

		// Cria objeto empresa
		Empresa empresa = new Empresa();

		try {
			preparation = connect.prepareStatement(sql);
			preparation.setLong(1, idEmpresa);

			result = preparation.executeQuery();
			result.next();

			// set o objeto empresa
			empresa.setId(result.getLong("id"));
			empresa.setCnpj(result.getString("cnpj"));
			empresa.setRazaoSocial(result.getString("razaosocial"));
			empresa.setEndereco(result.getString("endereco"));
			empresa.setTelefone(result.getString("telefone"));
			empresa.setSite(result.getString("site"));
			empresa.setEmail(result.getString("email"));

			Calendar dataCriacao = Calendar.getInstance();
			dataCriacao.setTime(result.getDate("dtcriacao"));
			empresa.setDataCriacao(dataCriacao);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// Fechando a conexão
			closeConnection(connect, preparation);
		}

		return empresa;
	}

	private void closeConnection(Connection connect,
			PreparedStatement preparation) {
		try {
			preparation.close();

			connect.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void updateCompany(Empresa empresa) {
		// conectando ao banco
		Connection connect = connectBD();

		// instrução sql
		String sql = "update empresa set cnpj = ?, razaosocial = ?, endereco = ?, "
				+ "telefone = ?, site = ?, email = ?, dtcriacao = ? "
				+ "where id = ?";

		// criando objeto de execução de comando SQL
		PreparedStatement preparation = null;

		try {
			preparation = connect.prepareStatement(sql);

			// passando os parametros para a sql
			preparation.setString(1, empresa.getCnpj());
			preparation.setString(2, empresa.getRazaoSocial());
			preparation.setString(3, empresa.getEndereco());
			preparation.setString(4, empresa.getTelefone());
			preparation.setString(5, empresa.getSite());
			preparation.setString(6, empresa.getEmail());
			preparation.setDate(7, new Date(empresa.getDataCriacao()
					.getTimeInMillis()));
			preparation.setLong(8, empresa.getId());

			// executando o comando SQL
			preparation.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// Fechando a conexão
			closeConnection(connect, preparation);
		}
	}

	public void deleteCompany(Empresa empresa) {
		// conectando ao banco
		Connection connect = connectBD();

		// instrução sql
		String sql = "DELETE FROM empresa WHERE id = ?";

		// criando objeto de execução de comando SQL
		PreparedStatement preparation = null;

		try {
			preparation = connect.prepareStatement(sql);

			// passando os parametros para a sql
			preparation.setLong(1, empresa.getId());

			// executando o comando SQL
			preparation.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// Fechando a conexão
			closeConnection(connect, preparation);
		}

	}
}
