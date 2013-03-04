/*
 * cette exception est lancée quand la validation d'une donnée a echoué
 */
package exception;

/**
 *
 * @author armel
 */
public class ValidationException extends RuntimeException {
    
    public ValidationException(String message ){
        
        super(message);
    }
    
     public ValidationException(){
        
        super("validation faillure");
    }
    
}
