package nl.jochumborger.test.api.exceptions;

/**
 * Created by jochum on 11/07/16.
 */
public class ActorCannotUseTheApiException extends RuntimeException {
    public ActorCannotUseTheApiException(String name) {
        super(name);
    }
}
