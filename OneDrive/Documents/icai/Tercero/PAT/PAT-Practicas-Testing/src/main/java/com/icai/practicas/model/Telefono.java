package com.icai.practicas.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public record Telefono(String telefonoValue) {

    private static final String patterns
            = "^(\\+\\d{1,3}( )?)?((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$"
            + "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?){2}\\d{3}$"
            + "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?)(\\d{2}[ ]?){2}\\d{2}$";
    private static final Pattern REGEXP = Pattern.compile(patterns);

    public boolean validar() {
        Matcher matcher = REGEXP.matcher(telefonoValue);
        return matcher.matches();
    }
}
