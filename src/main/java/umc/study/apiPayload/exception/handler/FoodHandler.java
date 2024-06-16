package umc.study.apiPayload.exception.handler;

import umc.study.apiPayload.code.BaseErrorCode;
import umc.study.apiPayload.exception.GeneralException;

public class FoodHandler extends GeneralException {
    public FoodHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}