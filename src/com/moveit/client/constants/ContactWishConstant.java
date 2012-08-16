package com.moveit.client.constants;

import com.moveit.client.language.LanguagePage;
import com.moveit.client.language.LQuoteType;

/**
 *
 */
public class ContactWishConstant extends IntegerConstant {
    private static final long serialVersionUID = -5947664162138119847L;

    public static ContactWishConstant MAIL_AND_PHONE = new ContactWishConstant(LQuoteType.EMAIL_AND_PHONE, 1);
    public static ContactWishConstant MAIL = new ContactWishConstant(LQuoteType.EMAIL, 2);
    public static ContactWishConstant PHONE = new ContactWishConstant(LQuoteType.PHONE, 3);


    public ContactWishConstant(LanguagePage lp, Integer value) {
        super(lp, value);
    }


    public static KeyValueList<Integer> getList() {
        KeyValueList<Integer> list = new KeyValueList<Integer>();
        list.add(ContactWishConstant.MAIL_AND_PHONE.getText(), ContactWishConstant.MAIL_AND_PHONE.getValue());
        list.add(ContactWishConstant.MAIL.getText(), ContactWishConstant.MAIL.getValue());
        list.add(ContactWishConstant.PHONE.getText(), ContactWishConstant.PHONE.getValue());

        return list;
    }
}