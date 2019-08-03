package model.principal;

import java.util.List;

import model.dao.TipoDAO;
import model.domain.Tipo;

public class TipoModel {
	public List<Tipo> procuraTipo() {
		TipoDAO tipos = new TipoDAO();
		return tipos.procuraTipos();
	}
}
