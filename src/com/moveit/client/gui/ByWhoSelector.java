package com.moveit.client.gui;

import com.moveit.client.guicomponents.*;
import com.moveit.client.html.HtmlContent;
import com.moveit.client.constants.OfferTypeConstant;

/**
 *
 */
public class ByWhoSelector extends HorizontalComponent implements PushDownImageHandler {


    private PushDownImage basis;
    private PushDownImage pro;
    private PushDownImage excl;
    private PushDownImage selected;

    private PushDownImage[] images;

    private String infoBasis;
    private String infoPro;
    private String infoExclusive;


    public ByWhoSelector() {
        super();
        init();
    }

    private void init() {

        basis = new PushDownImage(new ImageComponent("allOn.png"), new ImageComponent("allOff.png"));
        pro = new PushDownImage(new ImageComponent("proOn.png"), new ImageComponent("proOff.png"));
        excl = new PushDownImage(new ImageComponent("exclusivOn.png"), new ImageComponent("exclusivOff.png"));

        images = new PushDownImage[]{
                basis,
                pro,
                excl};

        Layout17 lSep = new Layout17(5, 30, 0, 30, null, Vertical.BOTTOM);

        for (PushDownImage link : images) {
            link.addPushDownHandler(this);
            add(link, lSep);
        }
        basis.setSelected(true);
        selected = basis;
    }

    public void pushedDown(PushDownImage pdl) {
        for (PushDownImage link : images) {
            if (pdl == link) {
                link.setSelected(true);
                selected = pdl;
            }
            else {
                link.setSelected(false);
            }
        }

        if (pdl == basis) {
            TipsManagerAddPage.getInstance().showTip(basis.getOnImage().getImage(), getInfoBasis());
        }
        else if (pdl == pro) {
            TipsManagerAddPage.getInstance().showTip(pro.getOnImage().getImage(), getInfoPro());
        }
        else {
            TipsManagerAddPage.getInstance().showTip(excl.getOnImage().getImage(), getInfoExclusive());
        }

    }

    public String getInfoBasis() {
        if (infoBasis == null) {
            HtmlContent hc = new HtmlContent();
            hc.addSection("tipsText", "Ved <b>Alle</b> er det både almindelige brugere og vognmænd, som kan give dig tilbud.");
            hc.addSection("tipsText", "Skal du fx transporterer fire fælge, en kasse bøger eller en cykel fra Kbh til Århus," +
                    " kan du være heldig, at en alm. bruger (eller vognmand) skal den vej og tager det billigt med.");

            hc.addSection("tipsText", "<b>Alle</b> vælges typisk af folk, der skal ha' transporteret noget ikke for stort og ikke for værdifuldt.");
            infoBasis = hc.getHtml();
        }
        return infoBasis;
    }

    public String getInfoPro() {
        if (infoPro == null) {
            HtmlContent hc = new HtmlContent();

            hc.addSection("tipsText", "Ved <b>Pro</b> er det kun vognmænd, som er cvr-registrerede og ikke har nogen anmærkninger hos forbrugerrådet," +
                    " som kan give dig tilbud.");
            hc.addSection("tipsText", "<b>Pro</b> giver dig større sikkerhed, da det kun er professionelle vognmænd, der transporterer dine ting.");
            hc.addSection("tipsText", "<b>Pro</b> vælges typisk af folk, der skal flytte lejlighed, ha' transporteret noget stort eller noget af væsentlig værdi.");
            infoPro = hc.getHtml();
        }
        return infoPro;
    }
    public String getInfoExclusive() {
        if (infoExclusive == null) {
            HtmlContent hc = new HtmlContent();
            hc.addSection("tipsText", "Ved <b>Exclusive</b> er det kun vognmænd som er medlem af <span class=a1><a href=\"http://www.flytning-dmf.dk\">Dansk Møbeltransport Forening (DMF)</a></span>, som kan give dig tilbud.");
            hc.addSection("tipsText", "<b>Exclusive</b> giver dig den bedste sikkerhed og kvalitet. Fx er det obligatorisk for alle vognmænd hos DMF at have en flytteansvarforsikring, som sikrer dig, hvis uheldet skulle være ude. Se <span class=a1><a href=\"http://www.dtl.eu/Om_DTL/Specialforeninger/Dansk_Moebeltransport_Forening.aspx\">her</a></span> hvilke andre krav DMF stiller til foreningens medlemmer.");
            hc.addSection("tipsText", "<b>Exclusive</b> vælges typisk af firmaer eller af folk, der vægter sikkerhed og kvalitet frem for pris.");
            infoExclusive = hc.getHtml();
        }
        return infoExclusive;
    }

    public void setFocus() {
        pushedDown(selected);

    }

    public OfferTypeConstant getSelectedOffer(){
        if (selected == basis) {
            return OfferTypeConstant.BASIS;
        }
        else if (selected == pro) {
            return OfferTypeConstant.PRO;
        }
        else {
            return OfferTypeConstant.EXCLUSIVE;
        }
    }
}