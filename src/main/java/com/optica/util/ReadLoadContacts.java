package com.optica.util;

import com.optica.domain.Contacts;
import ezvcard.Ezvcard;
import ezvcard.VCard;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReadLoadContacts {

    private static final String BEGIN = "BEGIN:VCARD";
    private static final String END = "END:VCARD";

    public static List<Contacts> readContactsFromVCard(InputStream file, Long userId) {

        List<Contacts> contacts = new ArrayList<>();
        List<VCard> vcards = null;
        try {
            vcards = Ezvcard.parse(file).all();
            vcards.stream()
                    .filter(vc-> vc.getFormattedName()!=null)
                    .filter(vc -> !vc.getTelephoneNumbers().isEmpty())
                    .forEach(vc -> {
                Contacts c = new Contacts();
                c.setName(vc.getFormattedName().getValue());
                c.setPhone(vc.getTelephoneNumbers().get(0).getText());
                c.setUserId(userId);
                contacts.add(c);

            });
            return contacts;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }


    }


}
