import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

/**
 *
 */
public class BrowserLangBuilder {


    static String text = "af \tAfrikaans \t\thr \tCroatian \t\tel \tGreek \t\tpl \tPolish \t\tsx \tSutu\n" +
            "sq \tAlbanian \t\tcs \tCzech \t\tgu \tGujurati \t\tpt \tPortuguese \t\tsw \tSwahili\n" +
            "ar \tArabic(Standard) \t\tda \tDanish \t\tht \tHaitian \t\tpt-br \tPortuguese(Brazil) \t\tsv \tSwedish\n" +
            "ar-dz \tArabic(Algeria) \t\tnl \tDutch(Standard) \t\the \tHebrew \t\tpa \tPunjabi \t\tsv-fi \tSwedish(Finland)\n" +
            "ar-bh \tArabic(Bahrain) \t\tnl-be \tDutch(Belgian) \t\thi \tHindi \t\tpa-in \tPunjabi(India) \t\tsv-sv \tSwedish(Sweden)\n" +
            "ar-eg \tArabic(Egypt) \t\ten \tEnglish \t\thu \tHungarian \t\tpa-pk \tPunjabi(Pakistan) \t\tta \tTamil\n" +
            "ar-iq \tArabic(Iraq) \t\ten-au \tEnglish(Australia) \t\tis \tIcelandic \t\tqu \tQuechua \t\ttt \tTatar\n" +
            "ar-jo \tArabic(Jordan) \t\ten-bz \tEnglish(Belize) \t\tid \tIndonesian \t\trm \tRhaeto-Romanic \t\tte \tTeluga\n" +
            "ar-kw \tArabic(Kuwait) \t\ten-ca \tEnglish(Canada) \t\tiu \tInuktitut \t\tro \tRomanian \t\tth \tThai\n" +
            "ar-lb \tArabic(Lebanon) \t\ten-ie \tEnglish(Ireland) \t\tga \tIrish \t\tro-mo \tRomanian(Moldavia) \t\ttig \tTigre\n" +
            "ar-ly \tArabic(Libya) \t\ten-jm \tEnglish(Jamaica) \t\tit \tItalian(Standard) \t\tru \tRussian \t\tts \tTsonga\n" +
            "ar-ma \tArabic(Morocco) \t\ten-nz \tEnglish(New Zealand) \t\tit-ch \tItalian(Switzerland) \t\tru-mo \tRussian(Moldavia) \t\ttn \tTswana\n" +
            "ar-om \tArabic(Oman) \t\ten-ph \tEnglish(Philippines) \t\tja \tJapanese \t\tsz \tSami(Lappish) \t\ttr \tTurkish\n" +
            "ar-qa \tArabic(Qatar) \t\ten-za \tEnglish(South Africa) \t\tkn \tKannada \t\tsg \tSango \t\ttk \tTurkmen\n" +
            "ar-sa \tArabic(Saudi Arabia) \t\ten-tt \tEnglish(Trinidad & Tobago) \t\tks \tKashmiri \t\tsa \tSanskrit \t\tuk \tUkrainian\n" +
            "ar-sy \tArabic(Syria) \t\ten-gb \tEnglish(United Kingdom) \t\tkk \tKazakh \t\tsc \tSardinian \t\thsb \tUpper Sorbian\n" +
            "ar-tn \tArabic(Tunisia) \t\ten-us \tEnglish(United States) \t\tkm \tKhmer \t\tgd \tScots Gaelic \t\tur \tUrdu\n" +
            "ar-ae \tArabic(U.A.E.) \t\ten-zw \tEnglish(Zimbabwe) \t\tky \tKirghiz \t\tsd \tSindhi \t\tve \tVenda\n" +
            "ar-ye \tArabic(Yemen) \t\teo \tEsperanto \t\ttlh \tKlingon \t\tsi \tSinghalese \t\tvi \tVietnamese\n" +
            "ar \tAragonese \t\tet \tEstonian \t\tko \tKorean \t\tsr \tSerbian \t\tvo \tVolapuk\n" +
            "hy \tArmenian \t\tfo \tFaeroese \t\tko-kp \tKorean(North Korea) \t\tsk \tSlovak \t\twa \tWalloon\n" +
            "as \tAssamese \t\tfa \tFarsi \t\tko-kr \tKorean(South Korea) \t\tsl \tSlovenian \t\tcy \tWelsh\n" +
            "ast \tAsturian \t\tfj \tFijian \t\tla \tLatin \t\tso \tSomani \t\txh \tXhosa\n" +
            "az \tAzerbaijani \t\tfi \tFinnish \t\tlv \tLatvian \t\tsb \tSorbian \t\tji \tYiddish\n" +
            "eu \tBasque \t\tfr \tFrench(Standard) \t\tlt \tLithuanian \t\tes \tSpanish \t\tzu \tZulu\n" +
            "bg \tBulgarian \t\tfr-be \tFrench(Belgium) \t\tlb \tLuxembourgish \t\tes-ar \tSpanish(Argentina) \t\t\t\n" +
            "be \tBelarusian \t\tfr-ca \tFrench(Canada) \t\tmk \tFYRO Macedonian \t\tes-bo \tSpanish(Bolivia) \t\t\t\n" +
            "bn \tBengali \t\tfr-fr \tFrench(France) \t\tms \tMalay \t\tes-cl \tSpanish(Chile) \t\t\t\n" +
            "bs \tBosnian \t\tfr-lu \tFrench(Luxembourg) \t\tml \tMalayalam \t\tes-co \tSpanish(Colombia) \t\t\t\n" +
            "br \tBreton \t\tfr-mc \tFrench(Monaco) \t\tmt \tMaltese \t\tes-cr \tSpanish(Costa Rica) \t\t\t\n" +
            "bg \tBulgarian \t\tfr-ch \tFrench(Switzerland) \t\tmi \tMaori \t\tes-do \tSpanish(Dominican Republic) \t\t\t\n" +
            "my \tBurmese \t\tfy \tFrisian \t\tmr \tMarathi \t\tes-ec \tSpanish(Ecuador) \t\t\t\n" +
            "ca \tCatalan \t\tfur \tFriulian \t\tmo \tMoldavian \t\tes-sv \tSpanish(El Salvador) \t\t\t\n" +
            "ch \tChamorro \t\tgd \tGaelic(Scots) \t\tnv \tNavajo \t\tes-gt \tSpanish(Guatemala) \t\t\t\n" +
            "ce \tChechen \t\tgd-ie \tGaelic(Irish) \t\tng \tNdonga \t\tes-hn \tSpanish(Honduras) \t\t\t\n" +
            "zh \tChinese \t\tgl \tGalacian \t\tne \tNepali \t\tes-mx \tSpanish(Mexico) \t\t\t\n" +
            "zh-hk \tChinese(Hong Kong) \t\tka \tGeorgian \t\tno \tNorwegian \t\tes-ni \tSpanish(Nicaragua) \t\t\t\n" +
            "zh-cn \tChinese(PRC) \t\tde \tGerman(Standard) \t\tnb \tNorwegian(Bokmal) \t\tes-pa \tSpanish(Panama) \t\t\t\n" +
            "zh-sg \tChinese(Singapore) \t\tde-at \tGerman(Austria) \t\tnn \tNorwegian(Nynorsk) \t\tes-py \tSpanish(Paraguay) \t\t\t\n" +
            "zh-tw \tChinese(Taiwan) \t\tde-de \tGerman(Germany) \t\toc \tOccitan \t\tes-pe \tSpanish(Peru) \t\t\t\n" +
            "cv \tChuvash \t\tde-li \tGerman(Liechtenstein) \t\tor \tOriya \t\tes-pr \tSpanish(Puerto Rico) \t\t\t\n" +
            "co \tCorsican \t\tde-lu \tGerman(Luxembourg) \t\tom \tOromo \t\tes-es \tSpanish(Spain) \t\t\t\n" +
            "cr \tCree \t\tde-ch \tGerman(Switzerland) \t\tfa \tPersian \t\tes-uy \tSpanish(Uruguay) \t\t\t\n" +
            "\t\t\t\t\t\tfa-ir \tPersian/Iran \t\tes-ve \tSpanish(Venezuela)\n" +
            "    ";


    public static void main(String[] args) {


        Map<String, String> map = new TreeMap<String, String>();

        StringTokenizer st = new StringTokenizer(text, "\t\n");
        String token = null;
        int i = 0;
        String code = null;


        while(st.hasMoreTokens()) {
            token = st.nextToken();
            if(token != null && !token.trim().equals("")){
                if(i == 0){
                    code = token.trim();
                    i++;
                }
                else {
                    map.put(code, "public static BrowserLanguageConstant "+code.replace('-', '_').toUpperCase()+ " = new BrowserLanguageConstant(\""+code+"\""+", "+"\""+token.trim()+"\""+", 0, 0);");
                    i = 0;
                }
            }
        }
        for (String s : map.values()) {
            System.out.println(s);
        }


    }

}
