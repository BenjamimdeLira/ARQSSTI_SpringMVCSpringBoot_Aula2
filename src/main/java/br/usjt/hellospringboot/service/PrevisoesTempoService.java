package br.usjt.hellospringboot.service;
import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.usjt.hellospringboot.model.PrevisaoTempo;
import br.usjt.hellospringboot.repository.PrevisaoTempoRepository;


@Service
public class PrevisoesTempoService {
	
	
	@Autowired
	private PrevisaoTempoRepository previsoesTempoRepo;
	public void salvar (PrevisaoTempo previsaoTempo) {
		previsoesTempoRepo.save(previsaoTempo);
		}
	
	public List listarTodos (){
		return (List) previsoesTempoRepo.findAll();		
		}
	
	
}
