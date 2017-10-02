/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.caf82.naivebayes;

/**
 *
 * @author Алена
 */
class ModelNotFittedException extends Exception {
    ModelNotFittedException() {
        super();
    }
    ModelNotFittedException(String message) {
        super(message);
    }
    ModelNotFittedException(Throwable cause) {
        super(cause);
    }
    ModelNotFittedException(Throwable cause, String message) {
        super(message);
    }
}
