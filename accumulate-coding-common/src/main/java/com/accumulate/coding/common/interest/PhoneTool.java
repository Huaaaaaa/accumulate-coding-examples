package com.accumulate.coding.common.interest;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * @Author: Huaaaaaa
 * @DateTime: 2021/3/29  16:52
 * @Description: 手机号工具包测试
 */
public class PhoneTool {

    public static void main(String[] args) {
        Integer countryCode = getRegionByPhone("13603262179", "US");
        System.out.println("countryCode=" + countryCode);
    }

    /**
     * 获取所有国家的区号
     *
     * @param region
     * @return
     */
    public static HashMap<String, Integer> getPhonePrefix(String region) {
        Map regionPrefixMap = new HashMap<String, Integer>();
        String[] countries = Locale.getISOCountries();
        PhoneNumberUtil phoneNumberUtil = PhoneNumberUtil.getInstance();
        for (int i = 0; i < countries.length; i++) {
            String code = countries[i];
            Locale locale = new Locale("zh", code);
            String mDisplayName = locale.getDisplayName();
            mDisplayName = mDisplayName.substring(mDisplayName.indexOf("("), mDisplayName.indexOf(")"));
            regionPrefixMap.put(mDisplayName, phoneNumberUtil.getCountryCodeForRegion(code));
        }
        return (HashMap<String, Integer>) regionPrefixMap;
    }


    public static Integer getRegionByPhone(String phone, String region) {
        try {
            PhoneNumberUtil util = PhoneNumberUtil.getInstance();
            Phonenumber.PhoneNumber phoneNumber = util.parse(phone, region);
            int countryCode = phoneNumber.getCountryCode();
            boolean validNumber = util.isValidNumber(phoneNumber);
            if (!validNumber) {
                throw new IllegalArgumentException("手机号【" + phone + "】或地区【" + region + "】无效");
            }
            return countryCode;
        } catch (NumberParseException e) {
            throw new IllegalArgumentException("手机号【" + phone + "】或地区【" + region + "】无效");
        }
    }
}
