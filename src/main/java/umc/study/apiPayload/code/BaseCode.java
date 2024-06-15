package umc.study.apiPayload.code;

import lombok.Getter;

import java.awt.desktop.UserSessionEvent;
import java.security.cert.CertPathValidatorException;

public interface BaseCode {
    public ReasonDTO getReason();

    public ReasonDTO getReasonHttpStatus();
}
