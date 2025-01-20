package todolist.spring.project_todolist.exception;



public class BadRequestException extends RuntimeException {

   public BadRequestException(String message) {
       super(message);
   }

}
