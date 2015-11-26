
/**
 * Write a description of class MailClient here.
 * 
 * @author (francisco jose fuentes alvarez) 
 * @version (a version number or a date)
 */
public class MailClient
{
   //atributos de la clase mailclient 
   private MailServer server;
   
   private String user;
   
    /**
     *  constructor de la clase que crea un nuevo cliente desde el servidor y a su vez a un usuario
     */
    public MailClient(String user, MailServer server)
    {
        this.user = user;
        this.server = server;
    }
    /**
     * Metodo que devuelve el coreo electronico de usuario
     */
    public MailItem getNextMailItem()
    {
        return server.getNextMailItem(user);
    }
    /**
     * Metodo que imprime por pantalla el correo electronico del usuario
     */
    public void printNextMailItem()
    {
        MailItem mensaje = getNextMailItem();
        
        if(mensaje == null) {
            System.out.println("no hay mensajes en la vandeja de correo");
        }
        else {
            mensaje.print();
        }
    }
    /**
     * Metodo que permite crear un mensaje que pertenece a la clase MailItem y lo cuelga en el servidor
     */
    public void sendMailItem(String to, String message)
    {
        MailItem mensaje = new MailItem(user, to, message);
        server.post(mensaje);
    }
   
   
   
   
}
