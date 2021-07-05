
public class NotEnoughFundsException extends RuntimeException  {

	    /**
	 * 
	 */
	private static final long serialVersionUID = -5875825195209742382L;

		public NotEnoughFundsException(Integer amount, Integer balance) {
	        super("Attempted to withdraw " + amount + " with a balance of " + balance);
	    
	}

}
