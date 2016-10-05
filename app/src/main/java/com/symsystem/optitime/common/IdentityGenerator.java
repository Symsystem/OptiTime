package com.symsystem.optitime.common;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.UUID;

/**
 * @author sym
 */

public class IdentityGenerator {

    private static final IdentityGenerator INSTANCE = new IdentityGenerator();

    private static final int ID_LENGTH = 25;
    private static final String SEPARATOR = "-";

    public IdentityGenerator() {
    }

    /**
     * @return a new universally unique identifier (UUID).
     */
    public String newIdentity() {
        return UUID.randomUUID().toString();
    }

    public String newIdentity(String code) {

        StringBuilder builder = new StringBuilder(ID_LENGTH);
        builder.append(code);
        builder.append(SEPARATOR);
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());
        builder.append(dateFormat.format(Calendar.getInstance().getTime()));
        builder.append(SEPARATOR);
        String[] uuid = UUID.randomUUID().toString().split(SEPARATOR);
        builder.append(uuid[uuid.length - 1]);

        return builder.toString().toUpperCase();
    }

    public static IdentityGenerator getInstance() {
        return INSTANCE;
    }
}
