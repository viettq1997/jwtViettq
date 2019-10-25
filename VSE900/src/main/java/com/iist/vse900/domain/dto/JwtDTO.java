package com.iist.vse900.domain.dto;

public class JwtDTO {
    private String jwtSecret;

    private String jwtExpiration;

    private String JwtSignatureAlgorithm;

    private String jwtIssuer;

    private String jwtNotBefore;

    public String getJwtSecret() {
        return jwtSecret;
    }

    public void setJwtSecret(String jwtSecret) {
        this.jwtSecret = jwtSecret;
    }

    public String getJwtExpiration() {
        return jwtExpiration;
    }

    public void setJwtExpiration(String jwtExpiration) {
        this.jwtExpiration = jwtExpiration;
    }

    public String getJwtSignatureAlgorithm() {
        return JwtSignatureAlgorithm;
    }

    public void setJwtSignatureAlgorithm(String jwtSignatureAlgorithm) {
        JwtSignatureAlgorithm = jwtSignatureAlgorithm;
    }

    public String getJwtIssuer() {
        return jwtIssuer;
    }

    public void setJwtIssuer(String jwtIssuer) {
        this.jwtIssuer = jwtIssuer;
    }

    public String getJwtNotBefore() {
        return jwtNotBefore;
    }

    public void setJwtNotBefore(String jwtNotBefore) {
        this.jwtNotBefore = jwtNotBefore;
    }
}
