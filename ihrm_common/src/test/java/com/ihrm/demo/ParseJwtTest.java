package com.ihrm.demo;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

public class ParseJwtTest {

    /**
     * 解析jwtToken字符串
     */
    public static void main(String[] args) {
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI4OCIsInN1YiI6IuWwj-eZvSIsImlhdCI6MTU3MTIxMTgwMSwiY29tcGFueUlkIjoiMTIzNDU2IiwiY29tcGFueU5hbWUiOiLmsZ_oi4_kvKDmmbrmkq3lrqLmlZnogrLogqHku73mnInpmZDlhazlj7giLCIwIjoiMCIsIjEiOiIxIn0.HmzpqIjl8rG7G-RpTMBX7_yD3VNXHksOgH5unfH6QFE";
        Claims claims = Jwts.parser().setSigningKey("ihrm").parseClaimsJws(token).getBody();

        //私有数据存放在claims
        System.out.println(claims.getId());
        System.out.println( claims.getSubject());
        System.out.println(claims.getIssuedAt());
        System.out.println(claims.get("0"));
        System.out.println(claims.get("1"));


        //解析自定义claim中的内容
        String companyId = (String)claims.get("companyId");
        String companyName = (String)claims.get("companyName");

        System.out.println(companyId + "---" + companyName);
    }
}
