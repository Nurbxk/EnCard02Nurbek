package com.example.encard02nurbek.common;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.engine.Resource;

public class Resourse<T> {

    public final T data;
    public final String message;
    public final Status status;



    public Resourse(T data, String message, Status status) {
        this.data = data;
        this.message = message;
        this.status = status;
    }

    public static <T> Resourse<T> success(@NonNull T data) {
        return new Resourse<>(data, null, Status.SUCCESS);
    }
    public static <T> Resourse<T> loading() {
        return new Resourse<>(null, null, Status.LOADING);

    }
    public static <T> Resourse<T> error(String message) {
        return new Resourse<>(null, message, Status.ERROR);
    }

    public enum Status {
        SUCCESS,
        LOADING,
        ERROR
    }
}


