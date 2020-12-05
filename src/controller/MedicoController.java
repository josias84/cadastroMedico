package controller;

import dao.MedicoDao;
import model.Medico;

public class MedicoController {
	
	public int cadastrar(int crm, String nome, String cpf, int especialidade) {
		
		Medico m = new Medico(crm, nome, cpf, especialidade);
		MedicoDao mDao = new MedicoDao();
		return (mDao.create(m));
	}
	//criar um objeto de produto
	//método cadastrar
	//método consultar

}
