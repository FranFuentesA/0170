/**
 * Mail
 * 
 * @author (Francico Jose Fuentes Alvarez) 
 * @version (24/11/2015)
 */
public class MailItem
{

    private String from;

    private String to;

    private String message;
    
    private String subject;

    /**
     * Constructor de la clase MailItem
     */ 
    public MailItem(String from, String to, String message,String subject)    {
        this.from = from;
        this.to = to;
        this.message = message;
        this.subject = subject;
    }

    /**
     * Metodo que devuelve el emisor del mensaje
     */
    public String getFrom()    {
        return from;
    }

    /**
     * Metodo que devuelve el destinatario del mensaje
     */
    public String getTo() {

        return to;
    }

    /**
     *  Metodo que devuelve el texto del mensaje
     */
    public String getMessage(){
        return message;
    }

    /**
     * Metodo que devuelve la cadena almacenada en subject
     */
    public String getSubject()
    {
        return subject;
    }

    /**
     * Metodo que imprime por pantalla los atributos de los parametros
     */
    public void printMail() {

        System.out.println("from: " + from);
        System.out.println("to: " + to);
        System.out.println ("Subject: " + subject);
        System.out.println("message: " + message);
    }
}