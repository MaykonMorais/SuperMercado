package model.principal;

import java.util.List;

import beans.Tipo;
import dao.TipoDAO;

public class TipoModel {
	public List<Tipo> procuraTipo() {
		TipoDAO tipos = new TipoDAO();
		return tipos.procuraTipos();
	}
}
