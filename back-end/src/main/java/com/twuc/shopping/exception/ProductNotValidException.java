package com.twuc.shopping.exception;

public class ProductNotValidException extends RuntimeException{
        private String errorMessage;

        public ProductNotValidException(String errorMessage) {
            this.errorMessage = errorMessage;
        }

        @Override
        public String getMessage() {
            return errorMessage;
        }
}
