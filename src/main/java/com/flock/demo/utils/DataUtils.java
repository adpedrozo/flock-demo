package com.flock.demo.utils;

import com.flock.demo.model.LoginRequest;
import com.flock.demo.model.provinces.CoordinatesData;
import com.flock.demo.model.provinces.ProvincesData;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.text.Normalizer;

@Component
public class DataUtils {

    @Value("${login.valid.user}")
    private String validUser;

    @Value("${login.valid.password}")
    private String validPassword;

    private static Logger LOGGER = LoggerFactory.getLogger(DataUtils.class);

    public CoordinatesData getCoordinatesByName(ProvincesData provincesData, String provinceName){

        String normalizedInput = normalizeString(provinceName);
        Integer provincesCount = provincesData.getCantidad();
        for ( int i = 0 ; i < provincesCount ; i++ ){
            String normalizedSource = normalizeString(provincesData.getProvincias().get(i).getNombre());
            if ( normalizedSource.equals(normalizedInput) ){
                return new CoordinatesData(
                        provincesData.getProvincias().get(i).getNombre(),
                        provincesData.getProvincias().get(i).getCentroide().getLat(),
                        provincesData.getProvincias().get(i).getCentroide().getLon()
                );
            }
        }
        return new CoordinatesData(null,null,null);
    }

    private String normalizeString(String name){

        return Normalizer.normalize(name, Normalizer.Form.NFD)
                .replaceAll("[^\\p{ASCII}]", "").toLowerCase();

    }

    public boolean validateUser(LoginRequest loginRequest){
        return (loginRequest.getUser().equals(validUser) && loginRequest.getPassword().equals(validPassword));
    }

    public String createJWT(String user, String password){
        Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
        return Jwts.builder().
                claim("name",user).
                claim("password",password).
                signWith(key).compact();
    }
}
