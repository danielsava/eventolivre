package br.com.eventolivre.service.email;

import br.com.eventolivre.model.vo.CertificadoVO;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;

/**
 *
 * @author otaviojava
 */
public class GerarCertificadoMensagem implements  GerarMensagem{

    private CertificadoVO certificadoVO;
    @Override
    public Message criarMensagem(Session session) throws UnsupportedEncodingException, MessagingException {
        Message message = new MimeMessage(session);
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(certificadoVO.getEmail()));
        message.setSubject(certificadoVO.getAssunto());
        message.setSentDate(new Date());
        
        MimeBodyPart menssagemParte = new MimeBodyPart();
        menssagemParte.setText(certificadoVO.getMensagem());
        
        MimeBodyPart anexoParte = new MimeBodyPart();
        DataSource fileDataSource = new ByteArrayDataSource(certificadoVO.getCertificado(), "application/pdf");
        anexoParte.setDataHandler(new DataHandler(fileDataSource));
        anexoParte.setFileName("certificado.pdf");

        
        Multipart conteudo = new MimeMultipart();
        conteudo.addBodyPart(menssagemParte);
        conteudo.addBodyPart(anexoParte);
        
        message.setContent(conteudo);
        return message;
    }

    public GerarCertificadoMensagem(CertificadoVO certificadoVO) {
        this.certificadoVO = certificadoVO;
    }
    
    
}
