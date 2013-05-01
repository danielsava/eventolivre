package br.com.eventolivre.service.report;

import java.io.File;
import java.io.InputStream;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;


/**
 * Classe base para os geradores de relatorio
 * @author otavio
 *
 */
 class AbstractReport {
public  static final String  DIRETORIO_RELATORIO="/reports/";
public  static final String  DIRETORIO_IMAGEM="/imagens/";


/**
 *  metodo para gerar o relatorio
 * @param parametros - valor para serem passados ao relatorio
 * @param file - arquivo 
 * @param dataSource - as informacoes que estarao no relatorio
 * @return o relatorio em forma de array de byte
 */
protected byte[] gerarRelatorio(Map<String, Object> parametros, String file,JRBeanCollectionDataSource dataSource) {

        try {
//            parametros.put("IMG_HEADER", getLogo());
            JasperPrint jasperPrint = JasperFillManager.fillReport(AbstractReport.class.getResourceAsStream(DIRETORIO_RELATORIO + file), parametros, dataSource);
            return JasperExportManager.exportReportToPdf(jasperPrint);
        } catch (JRException exception) {
            Logger.getLogger(AbstractReport.class.getName()).log(Level.SEVERE, "Ocorreu um erro durante a geração do relatório", exception);
            
            
            
     
        }
        return new byte[0];
}
	/**
	 * metodo que retorna a logo
	 * @return a logo em stream
	 */
     private InputStream getLogo() {
         String imagem = DIRETORIO_IMAGEM + "prefeituraSalvador.png";
         return AbstractReport.class.getResourceAsStream(imagem);
     }

protected File getDiretorio(){
    File diretorio=new File("/home/otaviojava/temp/");
    return diretorio;
}	
	

}