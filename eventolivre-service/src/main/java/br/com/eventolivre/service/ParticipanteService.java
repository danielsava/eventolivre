
package br.com.eventolivre.service;

import br.com.eventolivre.commons.dao.AbstractDAO;
import br.com.eventolivre.commons.service.AbstractService;
import br.com.eventolivre.dao.ParticipanteDAO;
import br.com.eventolivre.model.Participante;
import br.com.eventolivre.model.vo.CertificadoVO;
import br.com.eventolivre.service.email.EnvioEmail;
import br.com.eventolivre.service.report.CertificadoReport;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author otaviojava
 */
@Stateless
public class ParticipanteService extends AbstractService<Participante>  {

    @Inject
    private ParticipanteDAO participanteDAO;
    
    @Inject
    private CertificadoReport certificadoReport;
    
    @Inject
    private EnvioEmail envioEmail;
    
    @Override
    public AbstractDAO<Participante> getAbstractDAO() {
       return participanteDAO;
    }
    
    public List<String> getInstituicoes(String instituicoes){
    return participanteDAO.getInstituicoes(instituicoes);
    }

    public List<Participante> buscarEvento(Long codigoEvento) {
        return participanteDAO.buscarEvento(codigoEvento);
    }

    public Participante marcarPresente(Long idParticipante){
         Participante participante=findById(idParticipante);
         participante.setPresente(!participante.getPresente());
         edit(participante);
         return participante;
    }
    
    public boolean gerarCertificados(Long codigoEvento){
    
   List<CertificadoVO> certificados=new LinkedList<CertificadoVO>();
    for(Participante participante:buscarEvento(codigoEvento)){
        CertificadoVO certificadoVO=new CertificadoVO(participante,certificadoReport.gerarCeritificado(participante));
        certificadoVO.setEmail("otagonsan@hotmail.com");
        envioEmail.enviarCertificado(certificadoVO);
        certificados.add(certificadoVO);      
        participante.setEnviado(Boolean.TRUE);
        edit(participante);
    }
    
    for(CertificadoVO certificadoVO:certificados){
        certificadoVO.getCertificado().delete();
    }
    return true;
    }

}
