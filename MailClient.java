
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

    private MailItem lastMail;

    private boolean spam;

    private MailItem correo;

    /**
     *  constructor de la clase que crea un nuevo cliente desde el servidor y a su vez a un usuario
     */
    public MailClient(String user, MailServer server)
    {
        this.user = user;
        this.server = server;
    }

    /**
     * Metodo que devuelve el coreo electronico de usuario y detecta spam
     */
    public MailItem getNextMailItem()
    {
        if (correo.getMessage().contains("regalo") || (correo.getMessage().contains("promocion"))) {      
            spam = true; 
            correo = null;
        }  
        if (correo.getMessage().contains("trabajo")) {
            spam = false;       
        }
        return  server.getNextMailItem(user);
    }

    /**
     * Metodo que imprime por pantalla el correo electronico del usuario 
     */
    public void printNextMailItem()
    {
        MailItem mensaje = getNextMailItem();
        if (mensaje != null)  {
            mensaje.printMail();
        } else if (spam = true) {
           System.out.println("el correo contiene spam");
        }
         else if (spam = false) {
           System.out.println("el correo no contiene spam");
            } 
         else{
            System.out.println("no hay mensajes en la vandeja de correo");              
        }         
    }

    /**
     * Metodo que permite crear un mensaje que pertenece a la clase MailItem y lo cuelga en el servidor
     */
    public void sendMailItem(String to,String subject,String message)
    {
        MailItem email = new MailItem(user,to,subject,message);
        server.post(email);
    }

    /**
     * Metodo que permite saber cuantos correos tiene en el servidor cada usuario sin descargarlos.
     */
    public void howManyMail(){
        System.out.println("Tienes " + server.howManyMailItems(user) + " correo/s");
    }

    /**
     * Metodo que recupera el siguiente correo del servidor y genera una respuesta automatica.
     */
    public void getNextMailItemAutomaticRespond(){
        MailItem mail = getNextMailItem();
        if ((mail != null) && (spam = false)){
            String newSubject = "RE: " + mail.getSubject();
            String answer = "Estoy fuera de la oficina \n\n" + "Original message: " + mail.getMessage();
            MailItem autoRespond = new MailItem(user,mail.getFrom(),newSubject,answer);
            server.post(autoRespond);
            lastMail = mail;
        }
    }

    /**
     * Metodo que muestra por pantalla el Ãºltimo correo descargado
     */
    public void printLast(){
        if (lastMail != null){
            lastMail.printMail();
        }
        else{
            System.out.println("No se ha recibido ningun mensaje");
        }
    }
    
    
}
