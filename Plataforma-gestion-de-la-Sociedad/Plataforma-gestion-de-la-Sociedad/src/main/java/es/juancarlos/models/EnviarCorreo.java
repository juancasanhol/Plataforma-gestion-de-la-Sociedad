package es.juancarlos.models;

//import java.util.Properties;
//import javax.mail.Message;
//import javax.mail.MessagingException;
//import javax.mail.PasswordAuthentication;
//import javax.mail.Session;
//import javax.mail.Transport;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeMessage;

/**
 * 
 * @author Juan Carlos Sánchez Holguín 
 */
public class EnviarCorreo {
   
    /**
     *
     * @param destino   Correo destino del e-mail
     * @param asunto    Asunto del e-mail
     * @param mensaje   Mensaje del e-mail
     */
    public static void Enviar(String destino,String asunto,String mensaje){
        /*
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("juancasanhol@educarex.es", "51409975Es");
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("juancasanhol@educarex.es"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(destino));
            message.setSubject(asunto);
            message.setText(mensaje);

            Transport.send(message);
            

        } catch (MessagingException e) {
           
            e.printStackTrace();
        }
     */   
    }
}
// el salto de linea para el formateo del mensaje es como en java -->\n
//// EnviarCorreo.Enviar("", "", GeneradorMensaje.Mensaje("add","juancasanhol@educarex.es","123" ));
