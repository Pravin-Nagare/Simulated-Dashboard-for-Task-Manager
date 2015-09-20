package taskManager.util;


/** MessageImpl -- 	Class implements setMessage and getMessage of Message
 * 
 * @author Pravin Nagare
 */
public class MessageImpl implements Message{
	private String line;
	
	private Logger logger = Logger.getInstance();

	public MessageImpl(){
		logger.printToStdout(3, "Constructor of MessageImpl is called");
	}
	/** Set message for update
	 * @param 		String
	 */
	public void setMessage(String message){
		logger.printToStdout(2, "setMessage of MessageImpl is called");
		line = message;
	}
	

	/** Return message for observers
	 * @param 		No Arguments
	 * @exception 	No Exception
	 * @return 		String
	 */
	public String getMessage(){		
		logger.printToStdout(2, "getMessage of MessageImpl is called");
		return line;
	}
}
