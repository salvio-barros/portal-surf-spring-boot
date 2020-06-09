package com.lacomania.api.utils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import com.lacomania.api.exception.FalhaEmailException;

public class EmailUtils {


	public static SimpleMailMessage gerarEmailParaEnvio(String msg,String mailTo) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setText(msg);
        message.setTo(mailTo);
        message.setFrom("teste-pedido@gmail.com");
        message.setSubject("Teste Solicitação");
       
        return message;
    }
	
	public static MimeMessage gerarEmailMimeMessage(JavaMailSender mailSender, String msg,String mailTo) throws FalhaEmailException {
      
		MimeMessage mail = mailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper( mail );
        try {
			helper.setTo(mailTo);
			helper.setSubject( "Teste Envio de e-mail mime type" );
		    helper.setText("<p>Hello from Spring Boot Application</x><p>"+msg+"</p>", true);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			throw new FalhaEmailException("Falha ao preparar o email", e);
		}
    	return  helper.getMimeMessage();
      
	
	}
}
