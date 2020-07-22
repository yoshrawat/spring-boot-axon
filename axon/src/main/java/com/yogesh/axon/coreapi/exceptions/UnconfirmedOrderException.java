/* (C)2020 */
package com.yogesh.axon.coreapi.exceptions;

public class UnconfirmedOrderException extends IllegalStateException {
    public UnconfirmedOrderException() {
        super("Cannot ship an order which has not been confirmed yet.");
    }
}
