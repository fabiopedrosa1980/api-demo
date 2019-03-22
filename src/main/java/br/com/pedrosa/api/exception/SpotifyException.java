package br.com.pedrosa.api.exception;

public class SpotifyException extends Exception{

    private static final long serialVersionUID = 1L;

    public SpotifyException(String message){
        super(message);
    }

}
