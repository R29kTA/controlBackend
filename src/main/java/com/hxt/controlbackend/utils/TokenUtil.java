package com.hxt.controlbackend.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.hxt.controlbackend.exception.ConditionException;
import com.hxt.controlbackend.pojo.JwtToken;

import java.util.Calendar;
import java.util.Date;

public class TokenUtil {
    private static final String ISSUER = "HXT";
    private static final int ETIME = 60 * 60 * 12;
    public static JwtToken generateToken(Long userId) throws Exception{
        Algorithm algorithm = Algorithm.RSA256(RSAUtil.getPublicKey(),RSAUtil.getPrivateKey());
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.SECOND,ETIME);
        JwtToken jwtToken = new JwtToken();
        jwtToken.setExpires(calendar.getTime());
        String token = JWT
                .create()
                .withKeyId(String.valueOf(userId))
                .withIssuer(ISSUER)
                .withExpiresAt(calendar.getTime())
                .sign(algorithm);
        jwtToken.setAccessToken(token);
        jwtToken.setRefreshToken(token);
        return jwtToken;
    }
    public static Long verifyToken(String token){
        Algorithm algorithm;
        try {
             algorithm = Algorithm.RSA256(RSAUtil.getPublicKey(),RSAUtil.getPrivateKey());
             JWTVerifier jwtVerifier = JWT.require(algorithm).build();
             DecodedJWT jwt = jwtVerifier.verify(token);
             String userId = jwt.getKeyId();
             return Long.valueOf(userId);
        }catch (TokenExpiredException e){
            throw new ConditionException("555","token过期！");
        }catch (Exception e){
            throw new ConditionException("非法用户token！");
        }
    }
}
