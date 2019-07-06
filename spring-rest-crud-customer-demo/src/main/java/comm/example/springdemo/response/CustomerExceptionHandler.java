package comm.example.springdemo.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<CustomerResponse> handleException(CustomerNotFoundException exec) {
		CustomerResponse exception = new CustomerResponse();
		exception.setStatus(HttpStatus.NOT_FOUND.value());
		exception.setMessage(exec.getMessage());
		exception.setTimeOccured(System.currentTimeMillis());
		return new ResponseEntity<CustomerResponse>(exception, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<CustomerResponse> handleAllException(Exception e) {
		CustomerResponse error = new CustomerResponse(HttpStatus.NOT_FOUND.value(),
				e.getMessage(), System.currentTimeMillis());
		
		return new ResponseEntity<CustomerResponse>(error, HttpStatus.NOT_FOUND);
	}
}
