package br.com.eventolivre.service.report;

import br.com.eventolivre.model.Participante;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 *Classe que gera os certificados para o usuário
 * @author otaviojava
 */
@Stateless
public class CertificadoReport extends  AbstractReport{
        private static final String NOME_CERTIFICADO="certificado.jasper";
    
        
        
        /**
         * responsável por gerar o conteudo do certificado
         * @param participante - pessoa que receberá o certificado
         * @return o conteudo do certificado a partir das informações do participante
         */
	public byte[] gerarCertificado(Participante participante){
		Map<String, Object> parametros=new HashMap<String, Object>();	
                List<Participante> participantes=new LinkedList<Participante>();
                participantes.add(participante);
		JRBeanCollectionDataSource dataSource=new JRBeanCollectionDataSource(participantes);
		return gerarRelatorio(parametros, NOME_CERTIFICADO, dataSource);
	}
	
}
