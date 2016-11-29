/**
 * 
 */
package br.com.makersweb.service.core;

import java.io.StringWriter;
import java.io.Writer;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.context.Context;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import br.com.makersweb.service.IEmailSenderService;
import br.com.makersweb.service.exception.BusinessException;
import br.com.makersweb.util.MakersWebUtil;

/**
 * @author anderson.aristides
 */
@Service
public class EmailSenderServiceImpl implements IEmailSenderService {

	private static final Logger logger = LogManager.getLogger(EmailSenderServiceImpl.class);
	private VelocityEngine velocityEngine;
	private JavaMailSender mailSender;

	/**
	 * @param velocityEngine
	 * @param mailSender
	 */
	@Autowired
	public EmailSenderServiceImpl(VelocityEngine velocityEngine, JavaMailSender mailSender) {
		this.velocityEngine = velocityEngine;
		this.mailSender = mailSender;
	}
	
	private String mergeTemplate(String templateName, Map<String, Object> data) {
		String encoding = MakersWebUtil.MAIL_ENCODING;
		Context context = this.createContext(data);
		Writer writer = new StringWriter();

		this.velocityEngine.mergeTemplate(templateName, encoding, context, writer);

		return writer.toString();
	}

	private Context createContext(Map<String, Object> data) {
		VelocityContext context = new VelocityContext();
		for (Map.Entry<String, Object> entry : data.entrySet()) {
			String key = entry.getKey();
			Object value = entry.getValue();
			context.put(key, value);
		}
		return context;
	}

	private void sendEmail(String email, String template, Map<String, Object> myData)
			throws MessagingException, BusinessException {
		this.sendEmail(email, template, myData, null);
	}

	private void sendEmail(String email, String template, Map<String, Object> myData, String[] copia)
			throws MessagingException, BusinessException {

		String message = this.mergeTemplate(template, myData);

		MimeMessage mimeMessage = this.mailSender.createMimeMessage();

		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, false);
		helper.setTo(email);
		if (copia != null) {
			helper.setCc(copia);
		}
		helper.setFrom(MakersWebUtil.EMAIL_NOREPLY_SENDER);
		helper.setText(message, true);
		helper.setSubject("["+MakersWebUtil.MAIL_SUBJECT+"] " + myData.get("subject"));

		this.mailSender.send(mimeMessage);
	}

	@Override
	public Boolean sendTestEmail(String email, Map<String, Object> data) {
		logger.info("Iniciou método sendTestEmail...");
		try {
			this.sendEmail(email, "email-test-body.vm", data);
		} catch (MessagingException e) {
			logger.error("Erro ao enviar e-mail de teste: " + e.getMessage());
			return false;
		}
		return true;
	}

}
