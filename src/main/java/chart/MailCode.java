package chart;

import java.util.Properties;
import java.util.Random;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class MailCode {
private static String luutru_teencode;
	
    public static void guiTeenCodequa_gmail(String toEmail) {
        // Cấu hình thông tin email
        String fromEmail = "anhnvt.23Ite@vku.udn.vn";
        String password = "TuanAnh_205";

        // Tạo mã xác nhận ngẫu nhiên
        String maTeenCode = taoteenCode();
        luutru_teencode = maTeenCode;
        // Cấu hình thông tin máy chủ email
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        // Tạo phiên làm việc
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        });

        try {
            // Tạo đối tượng Message
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(fromEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
            message.setSubject("Confirm code");

            // Nội dung email
            String emailContent = "<!DOCTYPE html>\n" +
                    "<html>\n" +
                    "<head>\n" +
                    "  <title>IEC - Account Recovery</title>\n" +
                    "  <style>\n" +
                    "    body {\n" +
                    "      font-family: sans-serif;\n" +
                    "      display: flex;\n" +
                    "      justify-content: center;\n" + 
                    "      align-items: center;\n" +  
                    "      min-height: 100vh;\n" +
                    "      background-color: #f0f0f0;\n" +
                    "    }\n" +

                    "    .container {\n" +
                    "      background-color: #fff;\n" +
                    "      padding: 30px;\n" +
                    "      border-radius: 8px;\n" +
                    "      box-shadow: 0 2px 5px rgba(0, 0, 0, 0.2); /* Shadow effect */\n" +
                    "      text-align: center;\n" +
                    "    }\n" +

                    "    .code-box {\n" +
                    "      background-color: #e0e0e0;\n" +
                    "      padding: 20px;\n" +
                    "      border-radius: 5px;\n" +
                    "      font-size: 24px;\n" +
                    "      margin-bottom: 20px;\n" +
                    "      cursor: pointer; /* Make it look clickable */\n" +
                    "      transition: background-color 0.3s ease; /* Smooth transition */\n" +
                    "    }\n" +
                    
                    "    .code-box:hover {\n" + 
                    "      background-color: #d0d0d0; /* Lighter background on hover */\n" +
                    "    }\n" +
                    
                    "  </style>\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "  <div class=\"container\">\n" +
                    "    <h2>IEC - Account Recovery</h2>\n" +
                    "    <p>Your account recovery code is:</p>\n" +
                    "    <div class=\"code-box\">" + maTeenCode + "</div>\n" +
                    "    <p>Thank you for using IEC!</p>\n" +
                    "  </div>\n" +
                    "</body>\n" +
                    "</hytml>";


                MimeBodyPart htmlPart = new MimeBodyPart();
                htmlPart.setContent(emailContent, "text/html");

                MimeMultipart multipart = new MimeMultipart();
                multipart.addBodyPart(htmlPart);
                message.setContent(multipart); 

                Transport.send(message);
                
                System.out.println("Confirmation code sent to " + toEmail);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    public static String laymaTeenCode() {
    	return luutru_teencode;
    }
    
    private static  String taoteenCode() {
        // Tạo mã xác nhận ngẫu nhiên 4 chữ số
        Random random = new Random();
        int code = 1000 + random.nextInt(9000);
        return String.valueOf(code);
    }
}
