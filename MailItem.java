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

/**
 * Constructor de la clase MailItem
 */ 
 public MailItem(String de, String para, String mensaje)    {
        from = de;
        to = para;
        message = mensaje;
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
* Metodo que imprime por pantalla los atributos de los parametros
*/
    public void print() {
        
        System.out.println("from: " + from);
        System.out.println("to: " + to);
        System.out.println("message: " + message);
}
}