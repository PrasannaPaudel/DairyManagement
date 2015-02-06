package org.muthaka.dairy.Generators;

import java.util.UUID;

/**
 * Created by MUTHAKA on 1/30/2015.
 */
public class UuidGen {
    public String uuidGen() {
        String uuid = UUID.randomUUID().toString();
        return uuid;
    }

}
