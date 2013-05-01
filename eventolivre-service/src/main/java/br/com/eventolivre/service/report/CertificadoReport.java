package br.com.eventolivre.service.report;

import br.com.eventolivre.model.Participante;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 *Classe que gera os certificados para o usuário
 * @author otaviojava
 */
@RequestScoped
public class CertificadoReport extends  AbstractReport{
        private static final String NOME_CERTIFICADO="certificado.jasper";
    
        public File gerarCeritificado(Participante participante){
        String relatoriopdf = System.currentTimeMillis()+".pdf";
        File file=new File(getDiretorio(),relatoriopdf);
            try {
                FileOutputStream out = new FileOutputStream(file);
                out.write(gerarConteudo(participante));
                out.close();
            } catch (IOException ex) {
                Logger.getLogger(CertificadoReport.class.getName()).log(Level.SEVERE, "Ocorreu um erro ao gerar o certificado do participante "+participante.getNome(), ex);
            }

        return file;
        }
        
        /**
         * responsável por gerar o conteudo do certificado
         * @param participante - pessoa que receberá o certificado
         * @return o conteudo do certificado a partir das informações do participante
         */
	private byte[] gerarConteudo(Participante participante){
		Map<String, Object> parametros=new HashMap<String, Object>();	
                List<Participante> participantes=new LinkedList<Participante>();
                participantes.add(participante);
		JRBeanCollectionDataSource dataSource=new JRBeanCollectionDataSource(participantes);
		return gerarRelatorio(parametros, NOME_CERTIFICADO, dataSource);
	}
	
}
