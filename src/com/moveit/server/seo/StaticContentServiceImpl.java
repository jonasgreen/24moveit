package com.moveit.server.seo;

import com.moveit.client.model.Route;
import com.moveit.server.repository.RouteRepository;
import com.moveit.server.services.ActionHandlerRegistry;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Random;


public class StaticContentServiceImpl extends HttpServlet {
    private static final long serialVersionUID = 1105152521548463464L;

    private Random random = new Random();
    private String PARAM = "ROUTE_ID";

    private String[] danish_cities = new String[]{"flyttefirma københavn", "flyttefirma odense", "flyttefirma esbjerg", "flyttefirma roskilde", "flyttefirma århus", "flyttefirma aalborg", "flyttefirma randers", "flyttefirma kolding", "flyttefirma horsens", "flyttefirma vejle", "flyttefirma helsingør", "flyttefirma herning", "flyttefirma hørsholm", "flyttefirma silkeborg", "flyttefirma næstved", "flyttefirma fredericia", "flyttefirma viborg"};
    private String[] us_cities = new String[]{"moving company new york", "moving company los angeles", "moving company chicago", "moving company houston", "moving company philidelphia", "moving company phoenix", "moving company san diego", "moving company dallas", "moving company san antonio", "moving company detroit", "moving company san jose", "moving company indianapolis", "moving company san fransico"};
    private String[] uk_cities = new String[]{"moving company london", "moving company birmingham", "moving company glasgow", "moving company liverpool", "moving company leeds", "moving company sheffield", "moving company edingburgh", "moving company bristol", "moving company manchester", "moving company coventry", "moving company kingston upon hull", "moving company bradford", "moving company cardiff", "moving company belfast", "moving company stoke-on-trent", "moving company wolverhampton", "moving company nottingham", "moving company plymouth", "moving company southampton"};
    private String[] australia_cities = new String[]{"moving company sydney", "moving company melbourne", "moving company brisbane", "moving company perth", "moving company adelaide", "moving company cold coast-tweed", "moving company newcastle", "moving company canberra", "moving company wollongong", "moving company sunshine coast", "moving company greater hobart", "moving company geelong", "moving company townsville", "moving company cairns", "moving company toowomba", "moving company darwin", "moving company launceston"};

    private String[] english_tags = new String[]{
            "a movers",
            "abc moving company",
            "all movers",
            "all movers san diego",
            "all my sons moving",
            "all my sons moving chicago",
            "all my sons moving company",
            "all my sons moving dallas",
            "all my sons moving houston",
            "all my sons moving indianapolis",
            "all my sons moving san antonio",
            "alpha movers",
            "american movers",
            "american movers san jose",
            "apartment movers",
            "apartment movers chicago",
            "apartment movers dallas",
            "apartment movers houston",
            "apartment movers los angeles",
            "apartment movers new york",
            "apartment movers phoenix",
            "apartment movers san antonio",
            "arpin moving company",
            "art movers",
            "art movers chicago",
            "art movers london",
            "art movers los angeles",
            "art movers new york"
            , "atlas movers"
            , "atlas moving company"
            , "aurora moving company"
            , "b movers"
            , "b movers melbourne"
            , "b movers san antonio"
            , "beacon moving company"
            , "bekin moving company"
            , "bekins moving"
            , "bekins moving houston"
            , "bekins moving san diego"
            , "big movers"
            , "body movers"
            , "brian brooks moving company"
            , "brothers moving company"
            , "car moving company"
            , "cheap movers"
            , "cheap movers brisbane"
            , "cheap movers chicago"
            , "cheap movers dallas"
            , "cheap movers houston"
            , "cheap movers london"
            , "cheap movers los angeles"
            , "cheap movers melbourne"
            , "cheap movers new york"
            , "cheap movers phoenix"
            , "cheap movers san antonio"
            , "cheap movers san diego"
            , "cheap movers san jose"
            , "cheap movers sydney"
            , "cheap moving companies"
            , "cheap moving companies dallas"
            , "cheap moving companies houston"
            , "cheap moving companies los angeles"
            , "cheap moving company"
            , "cheap moving company new york"
            , "cheapest moving company"
            , "chelsea movers"
            , "chinese moving company"
            , "city mover"
            , "city mover new york"
            , "city moving company"
            , "commercial moving companies"
            , "companies moving overseas"
            , "company moving premises"
            , "cool movers"
            , "corporate movers"
            , "corporate movers houston"
            , "corporate moving"
            , "corporate moving companies"
            , "courier company"
            , "courier company adelaide"
            , "courier company brisbane"
            , "courier company houston"
            , "courier company london"
            , "courier company melbourne"
            , "courier company perth"
            , "courier company sydney"
            , "cross country moving companies"
            , "cross country moving company"
            , "direct movers"
            , "directory movers"
            , "discount moving company"
            , "door to door moving"
            , "door to door moving houston"
            , "easy moving company"
            , "easy moving company dallas"
            , "easy moving company houston"
            , "ebay movers"
            , "email movers"
            , "emove"
            , "factory movers"
            , "family movers"
            , "fast moving company"
            , "father and son moving company"
            , "flat rate moving company"
            , "forth movers"
            , "franklin moving company"
            , "free moving company"
            , "free quotes from movers"
            , "freight companies"
            , "freight companies adelaide"
            , "freight companies brisbane"
            , "freight companies cairns"
            , "freight companies canberra"
            , "freight companies chicago"
            , "freight companies dallas"
            , "freight companies darwin"
            , "freight companies houston"
            , "freight companies london"
            , "freight companies los angeles"
            , "freight companies manchester"
            , "freight companies melbourne"
            , "freight companies new york"
            , "freight companies newcastle"
            , "freight companies perth"
            , "freight companies phoenix"
            , "freight companies sunshine coast"
            , "freight companies sydney"
            , "freight companies townsville"
            , "freight company"
            , "freight company adelaide"
            , "freight company brisbane"
            , "freight company dallas"
            , "freight company houston"
            , "freight company london"
            , "freight company los angeles"
            , "freight company melbourne"
            , "freight company perth"
            , "freight company phoenix"
            , "freight company sydney"
            , "full service moving companies"
            , "golan moving company"
            , "golans moving company"
            , "good movers"
            , "grabel moving company"
            , "graebel moving"
            , "graebel moving company"
            , "green movers"
            , "hawaiian moving company"
            , "help moving house"
            , "highland moving company"
            , "hill moving company"
            , "hire movers"
            , "hire movers melbourne"
            , "home mover"
            , "home mover new york"
            , "home moving services"
            , "house movers"
            , "house movers brisbane"
            , "house movers dallas"
            , "house movers houston"
            , "house movers london"
            , "house movers los angeles"
            , "house movers melbourne"
            , "house movers new york"
            , "house movers newcastle"
            , "house movers perth"
            , "house movers san antonio"
            , "house movers san diego"
            , "house movers sydney"
            , "house moving service"
            , "house moving service melbourne"
            , "house moving services"
            , "household goods moving"
            , "household moving companies"
            , "imagiation movers"
            , "imagination movers"
            , "imagination movers houston"
            , "imagination movers indianapolis"
            , "imagineation movers"
            , "imagintion movers"
            , "imagionation movers"
            , "imgination movers"
            , "imigination movers"
            , "in movers"
            , "in movers adelaide"
            , "in movers brisbane"
            , "in movers melbourne"
            , "in movers newcastle"
            , "in movers perth"
            , "in movers sydney"
            , "international movers"
            , "international movers brisbane"
            , "international movers chicago"
            , "international movers dallas"
            , "international movers houston"
            , "international movers london"
            , "international movers los angeles"
            , "international movers melbourne"
            , "international movers new york"
            , "international movers perth"
            , "international movers sydney"
            , "international moving company"
            , "international moving company chicago"
            , "international moving company manchester"
            , "international moving company new york"
            , "interstate mover"
            , "interstate moving"
            , "interstate moving adelaide"
            , "interstate moving brisbane"
            , "interstate moving melbourne"
            , "interstate moving perth"
            , "interstate moving sydney"
            , "jch movers"
            , "king movers"
            , "lawn movers"
            , "licensed movers"
            , "light movers"
            , "lmagination movers"
            , "load movers"
            , "local movers"
            , "local movers brisbane"
            , "local movers chicago"
            , "local movers dallas"
            , "local movers houston"
            , "local movers indianapolis"
            , "local movers los angeles"
            , "local movers melbourne"
            , "local movers new york"
            , "local movers phoenix"
            , "local movers san antonio"
            , "local movers san diego"
            , "local movers san jose"
            , "local moving"
            , "local moving brisbane"
            , "local moving chicago"
            , "local moving companies"
            , "local moving companies chicago"
            , "local moving companies dallas"
            , "local moving companies houston"
            , "local moving companies los angeles"
            , "local moving company"
            , "local moving company chicago"
            , "local moving company dallas"
            , "local moving company houston"
            , "local moving company new york"
            , "local moving melbourne"
            , "local moving new york"
            , "local moving phoenix"
            , "local moving sydney"
            , "long distance movers"
            , "long distance movers chicago"
            , "long distance movers dallas"
            , "long distance movers houston"
            , "long distance movers london"
            , "long distance movers los angeles"
            , "long distance movers new york"
            , "long distance moving"
            , "long distance moving chicago"
            , "long distance moving melbourne"
            , "mail movers"
            , "major movers"
            , "master movers"
            , "master movers indianapolis"
            , "matthew moving company"
            , "mature movers"
            , "mayflower movers"
            , "mayflower moving"
            , "mayflower moving san diego"
            , "metro movers"
            , "metro movers brisbane"
            , "metro movers melbourne"
            , "metro movers phoenix"
            , "mind movers"
            , "modern movers"
            , "monte moving company"
            , "move interstate"
            , "mover moving company"
            , "movers and packers"
            , "movers and packers adelaide"
            , "movers and packers chicago"
            , "movers and packers dallas"
            , "movers and packers houston"
            , "movers and packers london"
            , "movers and packers los angeles"
            , "movers and packers melbourne"
            , "movers and packers san diego"
            , "movers and packers sydney"
            , "movers and storage"
            , "movers and storage melbourne"
            , "movers and storage sydney"
            , "movers blog"
            , "movers canada"
            , "movers day"
            , "movers directory"
            , "movers estimate"
            , "movers estimates"
            , "movers forum"
            , "movers in"
            , "movers in adelaide"
            , "movers in birmingham"
            , "movers in brisbane"
            , "movers in bristol"
            , "movers in chicago"
            , "movers in dallas"
            , "movers in detroit"
            , "movers in houston"
            , "movers in indianapolis"
            , "movers in london"
            , "movers in los angeles"
            , "movers in manchester"
            , "movers in melbourne"
            , "movers in new york"
            , "movers in newcastle"
            , "movers in perth"
            , "movers in phoenix"
            , "movers in plymouth"
            , "movers in san antonio"
            , "movers in san diego"
            , "movers in san jose"
            , "movers in sydney"
            , "movers limited"
            , "movers long distance"
            , "movers moving"
            , "movers moving company"
            , "movers moving melbourne"
            , "movers national"
            , "movers near"
            , "movers near chicago"
            , "movers near dallas"
            , "movers near houston"
            , "movers near los angeles"
            , "movers near phoenix"
            , "movers online"
            , "movers pictures"
            , "movers price"
            , "movers program"
            , "movers rates"
            , "movers review"
            , "movers reviews"
            , "moving & storage"
            , "moving & storage chicago"
            , "moving & storage dallas"
            , "moving & storage houston"
            , "moving & storage indianapolis"
            , "moving & storage los angeles"
            , "moving & storage melbourne"
            , "moving & storage new york"
            , "moving & storage phoenix"
            , "moving & storage san antonio"
            , "moving & storage san diego"
            , "moving & storage san jose"
            , "moving address"
            , "moving companies"
            , "moving companies adelaide"
            , "moving companies australia"
            , "moving companies birmingham"
            , "moving companies brisbane"
            , "moving companies bristol"
            , "moving companies canberra"
            , "moving companies chicago"
            , "moving companies dallas"
            , "moving companies darwin"
            , "moving companies detroit"
            , "moving companies glasgow"
            , "moving companies houston"
            , "moving companies in the uk"
            , "moving companies indianapolis"
            , "moving companies leeds"
            , "moving companies london"
            , "moving companies long distance"
            , "moving companies los angeles"
            , "moving companies manchester"
            , "moving companies melbourne"
            , "moving companies new york"
            , "moving companies newcastle"
            , "moving companies perth"
            , "moving companies phoenix"
            , "moving companies plymouth"
            , "moving companies quotes"
            , "moving companies san antonio"
            , "moving companies san diego"
            , "moving companies san jose"
            , "moving companies sydney"
            , "moving companies uk"
            , "moving companies usa"
            , "moving companies west"
            , "moving company"
            , "moving company adelaide"
            , "moving company birmingham"
            , "moving company brisbane"
            , "moving company ca"
            , "moving company canada"
            , "moving company chicago"
            , "moving company cross country"
            , "moving company cross country indianapolis"
            , "moving company dallas"
            , "moving company detroit"
            , "moving company employment"
            , "moving company employment indianapolis"
            , "moving company employment los angeles"
            , "moving company employment san fransico"
            , "moving company employment san jose"
            , "moving company estimates"
            , "moving company estimates detroit"
            , "moving company estimates houston"
            , "moving company estimates indianapolis"
            , "moving company estimates san fransico"
            , "moving company for sale"
            , "moving company for sale detroit"
            , "moving company for sale houston"
            , "moving company for sale indianapolis"
            , "moving company for sale san fransico"
            , "moving company for sale san jose"
            , "moving company houston"
            , "moving company indianapolis"
            , "moving company la"
            , "moving company la houston"
            , "moving company la indianapolis"
            , "moving company license"
            , "moving company london"
            , "moving company los"
            , "moving company los angeles"
            , "moving company ma"
            , "moving company manchester"
            , "moving company melbourne"
            , "moving company mn"
            , "moving company mn dallas"
            , "moving company new york"
            , "moving company newcastle"
            , "moving company nj"
            , "moving company nz"
            , "moving company orange"
            , "moving company perth"
            , "moving company phoenix"
            , "moving company prices"
            , "moving company prices chicago"
            , "moving company quotes"
            , "moving company quotes los angeles"
            , "moving company rating"
            , "moving company ratings"
            , "moving company review"
            , "moving company reviews"
            , "moving company san antonio"
            , "moving company san diego"
            , "moving company san jose"
            , "moving company services"
            , "moving company services indianapolis"
            , "moving company services san fransico"
            , "moving company services san jose"
            , "moving company software"
            , "moving company software chicago"
            , "moving company software houston"
            , "moving company sydney"
            , "moving company uk"
            , "moving cost"
            , "moving cost adelaide"
            , "moving cost brisbane"
            , "moving cost melbourne"
            , "moving cost perth"
            , "moving cost sydney"
            , "moving estimate"
            , "moving europe"
            , "moving firm"
            , "moving guide"
            , "moving home"
            , "moving home brisbane"
            , "moving home coventry"
            , "moving home london"
            , "moving home melbourne"
            , "moving home perth"
            , "moving home sydney"
            , "moving house help"
            , "moving house help detroit"
            , "moving house help indianapolis"
            , "moving house help san fransico"
            , "moving house help san jose"
            , "moving house list"
            , "moving house list chicago"
            , "moving house list dallas"
            , "moving house list houston"
            , "moving house list los angeles"
            , "moving house list philidelphia"
            , "moving house list phoenix"
            , "moving house list san diego"
            , "moving house packing"
            , "moving international"
            , "moving international melbourne"
            , "moving international sydney"
            , "moving list"
            , "moving mover"
            , "moving office"
            , "moving office indianapolis"
            , "moving office melbourne"
            , "moving office san fransico"
            , "moving office san jose"
            , "moving office sydney"
            , "moving pool table"
            , "moving pool table houston"
            , "moving pool table los angeles"
            , "moving rates"
            , "moving service"
            , "moving service birmingham"
            , "moving service brisbane"
            , "moving service london"
            , "moving service melbourne"
            , "moving service sydney"
            , "moving to darwin"
            , "moving truck company"
            , "moving utilities"
            , "moving van lines"
            , "multi movers"
            , "multi movers detroit"
            , "multi movers indianapolis"
            , "multi movers san fransico"
            , "multi movers san jose"
            , "my three sons moving company"
            , "my three sons moving company chicago"
            , "my three sons moving company dallas"
            , "my three sons moving company houston"
            , "my three sons moving company los angeles"
            , "my three sons moving company philidelphia"
            , "my three sons moving company san diego"
            , "national moving"
            , "national moving detroit"
            , "national moving indianapolis"
            , "national moving san fransico"
            , "national moving san jose"
            , "net movers"
            , "net movers chicago"
            , "net movers dallas"
            , "net movers houston"
            , "net movers los angeles"
            , "net movers philidelphia"
            , "net movers phoenix"
            , "net movers san diego"
            , "north american moving company"
            , "oasis moving company"
            , "office mover"
            , "office moving service"
            , "online movers"
            , "out of state moving"
            , "overseas moving company"
            , "overseas moving company detroit"
            , "overseas moving company indianapolis"
            , "overseas moving company san fransico"
            , "overseas moving company san jose"
            , "oz movers"
            , "oz movers chicago"
            , "oz movers dallas"
            , "oz movers houston"
            , "oz movers los angeles"
            , "oz movers philidelphia"
            , "oz movers phoenix"
            , "oz movers san diego"
            , "packing moving company"
            , "pet movers"
            , "piano mover"
            , "piano mover london"
            , "piano mover melbourne"
            , "piano mover sydney"
            , "pool table company"
            , "pool table moving"
            , "pool table moving company"
            , "price movers"
            , "price movers bradford"
            , "professional movers"
            , "professional movers melbourne"
            , "ready movers"
            , "ready movers london"
            , "reliable movers"
            , "relocation inexpensive"
            , "relocation lov price"
            , "relocation moving"
            , "relocation moving companies"
            , "relocation moving company"
            , "reputable moving companies"
            , "residential movers"
            , "right movers"
            , "safe movers"
            , "safe movers san jose"
            , "safe moving company"
            , "second movers"
            , "share movers"
            , "share movers bradford"
            , "slow movers"
            , "small move company"
            , "special movers"
            , "state movers"
            , "state to state movers"
            , "state to state moving companies"
            , "stevens moving company"
            , "storage moving"
            , "storage moving adelaide"
            , "storage moving brisbane"
            , "storage moving melbourne"
            , "storage moving perth"
            , "storage moving sydney"
            , "suddath moving company"
            , "suddath moving company darwin"
            , "suddath moving company launceston"
            , "super movers"
            , "super movers brisbane"
            , "super movers melbourne"
            , "super movers sydney"
            , "the moving company nz"
            , "tmty movers"
            , "top movers"
            , "top moving companies"
            , "top moving companies san fransico"
            , "trowt movers"
            , "trowt movers bradford"
            , "trucking moving company"
            , "trucking moving company detroit"
            , "trucking moving company indianapolis"
            , "trucking moving company san fransico"
            , "trucking moving company san jose"
            , "two guys and a truck moving company"
            , "two guys and a truck moving company chicago"
            , "two guys and a truck moving company dallas"
            , "two guys and a truck moving company houston"
            , "two guys and a truck moving company los angeles"
            , "two guys and a truck moving company philidelphia"
            , "two guys and a truck moving company san diego"
            , "union moving company"
            , "va moving company"
            , "van lines"
            , "van lines moving company"
            , "west moving company"
            , "western movers"
            , "white movers"
            , "white movers bradford"
            , "white movers cardiff"
            , "white movers southampton"
            , "world moving company"
            , "world moving company coventry"
            , "world moving company london"

    };

    private String[] danish_tags = new String[]{"34 transport",
            "3d transport",
            "3x34 flytning",
            "ab flyt",
            "abc flyt",
            "abc flytte",
            "abc flyttefirma",
            "ac transport",
            "adam flyt",
            "adam flytte",
            "adam transport",
            "adams transport",
            "alex andersen vognmand",
            "alt flyt",
            "alternativ transport",
            "am transport",
            "an transport",
            "an vognmand",
            "anco transport",
            "ap transport",
            "arden transport",
            "auto transport",
            "baja transport",
            "bar transport",
            "billig flyt",
            "billig flytning",
            "billig flytte",
            "billig flyttebil",
            "billig flyttekasser",
            "billig flyttemand",
            "billig transport",
            "billige flyttefirmaer",
            "billige flyttekasser",
            "billigt flyttefirma",
            "bio transport",
            "bj flyt",
            "bk transport",
            "bliv selvstændig vognmand",
            "bliv vognmand",
            "bm transport",
            "brugte flyttekasser",
            "budkørsel",
            "bøgeskov flytte",
            "car transport",
            "cargo transport",
            "city flyt",
            "cj transport",
            "cm transport",
            "cp flyt",
            "dalmose vognmand",
            "dan transport",
            "danmark flytte",
            "dba.dk",
            "den rare vognmand",
            "denblåavis",
            "dhl transport",
            "discount flyt",
            "dtt transport",
            "ej transport",
            "el transport",
            "eva transport",
            "faciliteret transport",
            "fagfolkenes flytte",
            "fdl vognmand",
            "filtenborg vognmand",
            "flyt addresse",
            "flyt folkeregisteradresse",
            "flyt let",
            "flyt post",
            "flyt postadresse",
            "flyt til canada",
            "flyt til england",
            "flyt til italien",
            "flyt til japan",
            "flyt til schweiz",
            "flyt til usa",
            "flytning",
            "flytning danmark",
            "flytning jylland",
            "flytning klaver",
            "flytning priser",
            "flytning transport",
            "flytning udland",
            "flytninger",
            "flytte",
            "flytte adr",
            "flytte adresse",
            "flytte billigt",
            "flytte dk",
            "flytte folk",
            "flytte forretning",
            "flytte guide",
            "flytte hjem",
            "flytte hjem til danmark",
            "flytte hjælp",
            "flytte kasser",
            "flytte klar",
            "flytte klaver",
            "flytte lift",
            "flytte liste",
            "flytte meddelse",
            "flytte melding",
            "flytte møbler",
            "flytte norge",
            "flytte opbevaring",
            "flytte pakke",
            "flytte post",
            "flytte service",
            "flytte til bornholm",
            "flytte til canada",
            "flytte til england",
            "flytte til holland",
            "flytte til irland",
            "flytte til japan",
            "flytte til norge",
            "flytte til schweiz",
            "flytte til udland",
            "flytte til usa",
            "flytte tilbud",
            "flytte transport",
            "flytte udland",
            "flytte udlandet",
            "flytte vista",
            "flytte vogn",
            "flytteauktion",
            "flyttebil",
            "flyttebiler",
            "flyttefirma danmark",
            "flyttefirma kbh",
            "flyttefirma priser",
            "flyttefirma udlandet",
            "flyttefirmaer",
            "flytteforretning",
            "flytteforretninger",
            "flyttekasse",
            "flyttekasse mål",
            "flyttekasser",
            "flyttekasser amager",
            "flyttekasser bauhaus",
            "flyttekasser bilka",
            "flyttekasser dk",
            "flyttekasser harald nyborg",
            "flyttekasser lyngby",
            "flyttekasser mål",
            "flyttekasser pris",
            "flyttekasser salg",
            "flyttekasser tilbud",
            "flyttekasser østerbro",
            "flyttemand",
            "flyttemænd",
            "flytter til england",
            "flytter til spanien",
            "flytter til usa",
            "flytteservice",
            "flyttet",
            "flyttetilbud",
            "flyttetransport",
            "flyttevogn",
            "flytting",
            "fp transport",
            "fragtmand",
            "fragtmand priser",
            "fredebo transport",
            "fredsø vognmand",
            "fts transport",
            "give transport",
            "gj transport",
            "go transport",
            "godstransport",
            "goods transport",
            "gorilla flyt",
            "gren transport",
            "guldager vognmand",
            "guldhammer vognmand",
            "hc transport",
            "hee flyt",
            "heimdal flyt",
            "hf transport",
            "hit transport",
            "holte flyt",
            "ht transport",
            "hv transport",
            "hvorupgård transport",
            "ib andersen vognmand",
            "ih transport",
            "in transport",
            "inge norus når du flytter hjemmefra",
            "international transport",
            "international flytning",
            "ja transport",
            "jb transport",
            "jeg flytter",
            "jeg skal flytte",
            "jeg vil flytte",
            "jj transport",
            "jk transport",
            "jl transport",
            "jm transport",
            "johannes rasmussen vognmand",
            "johannes sørensen vognmand",
            "john maj vognmand",
            "johs sørensen vognmand",
            "jp transport",
            "jr transport",
            "js transport",
            "jt transport",
            "jørvi transport",
            "k transport",
            "kaj kjær vognmand",
            "karrebæk vognmand",
            "kasi group flytter",
            "kb transport",
            "kbl transport",
            "kf transport",
            "kj flyt",
            "kj transport",
            "klaverflytning",
            "ks transport",
            "kurer kørsel",
            "kurer priser",
            "kurer vognmand",
            "kurerkørsel",
            "kurertransport",
            "kurér",
            "køb flyttekasser",
            "købe flyttekasser",
            "køletransport",
            "lasse sørensen vognmand",
            "lastbil vognmand",
            "lej flyttekasser",
            "leje flyttekasser",
            "leo jensen vognmand",
            "lh transport",
            "liggende transport",
            "lm flyt",
            "lm transport",
            "lm transport ans",
            "lmt transport",
            "lundsøe transport",
            "lyngby flyt",
            "lyngby flytte",
            "m flyt",
            "m transport",
            "marie flytter",
            "marie flytter fra joakim",
            "marie flytter hjem",
            "mc transport",
            "melby vognmand",
            "mf flyt",
            "mh transport",
            "michael jensen vognmand",
            "mini flyt",
            "mini transport",
            "modul transport",
            "mogens jensen vognmand",
            "moko transport",
            "møbel transport",
            "møbelopbevaring",
            "møbeltransport",
            "national transport",
            "nielsen flyt",
            "nordic transport",
            "når du flytter",
            "når du skal flytte",
            "ob flyt",
            "obama flytter",
            "offenlig transport",
            "om transport",
            "pk transport",
            "porsborg flytte",
            "prima transport",
            "public transport",
            "q transport",
            "rail transport",
            "rise transport",
            "rk transport",
            "rs transport",
            "røverkøb flyttekasser",
            "safe flytning & transport",
            "sct transport",
            "sct vognmand",
            "selvstændig vognmand",
            "selvstændig vognmand søges",
            "silvan flyttekasse",
            "skal du flytte",
            "sos transport",
            "sp transport",
            "specialtransport",
            "stk transport",
            "store flyttekasser",
            "su transport",
            "super flyt",
            "sæsing vognmand",
            "team transport",
            "thimsen transport",
            "tilbud flytning",
            "tilbud flyttekasser",
            "tina transport",
            "tjw transport",
            "tks transport",
            "top transport",
            "torpmagle transport",
            "transport companies",
            "transport company",
            "transport england",
            "transport europa",
            "transport firma",
            "transport historie",
            "transport holland",
            "transport kasse",
            "transport kbh",
            "transport kørsel",
            "transport møbler",
            "transport nl",
            "transport pris",
            "transport priser",
            "transport se",
            "transport sector",
            "transport tilbud",
            "transport uk",
            "transport usa",
            "transport vognmænd",
            "transportfirma",
            "ts transport",
            "tung transport",
            "varetransport",
            "vbt transport",
            "vi flytter din bil",
            "vi skal flytte",
            "viggo jensen vognmand",
            "vindelsbæk transport",
            "vipperød vognmand",
            "vognmand alfred nielsen",
            "vognmand amager",
            "vognmand andersen",
            "vognmand arne nielsen",
            "vognmand barfod",
            "vognmand benny rasmussen",
            "vognmand bent hansen",
            "vognmand bjarne andersen",
            "vognmand bjarne pedersen",
            "vognmand bjerre",
            "vognmand bomholt",
            "vognmand bornholm",
            "vognmand brabrand",
            "vognmand brande",
            "vognmand brian",
            "vognmand brønderslev",
            "vognmand buhl",
            "vognmand carsten",
            "vognmand carsten nielsen",
            "vognmand container",
            "vognmand dk",
            "vognmand egon nielsen",
            "vognmand erik duus",
            "vognmand erik nielsen",
            "vognmand erik petersen",
            "vognmand erling andersen",
            "vognmand eskildsen",
            "vognmand faxe",
            "vognmand frank",
            "vognmand frank nørager",
            "vognmand frede andersen",
            "vognmand fyn",
            "vognmand give",
            "vognmand grenå",
            "vognmand greve",
            "vognmand grus",
            "vognmand hans hansen",
            "vognmand hansen",
            "vognmand hansen karise",
            "vognmand henning",
            "vognmand henrik andersen",
            "vognmand henrik guldager",
            "vognmand henrik sørensen",
            "vognmand henry møller",
            "vognmand jan jensen",
            "vognmand jan simonsen",
            "vognmand jens eriksen",
            "vognmand jens jensen",
            "vognmand jensen",
            "vognmand johannes",
            "vognmand john hansen",
            "vognmand john jensen",
            "vognmand john madsen",
            "vognmand jord",
            "vognmand jylland",
            "vognmand k knudsen",
            "vognmand kaj andersen",
            "vognmand kbh",
            "vognmand knud pedersen",
            "vognmand knud petersen",
            "vognmand konkurs",
            "vognmand korsør",
            "vognmand kran",
            "vognmand kristoffer larsen",
            "vognmand kørsel",
            "vognmand lars",
            "vognmand lars nielsen",
            "vognmand larsen",
            "vognmand leif hansen",
            "vognmand leif møller",
            "vognmand leth",
            "vognmand lolland",
            "vognmand m larsen",
            "vognmand martin bay",
            "vognmand martin hansen",
            "vognmand michael jespersen",
            "vognmand mogens hegelund",
            "vognmand morten larsen",
            "vognmand niels christiansen",
            "vognmand nielsen",
            "vognmand nilsen",
            "vognmand nordjylland",
            "vognmand nordsjælland",
            "vognmand nyborg",
            "vognmand nørresundby",
            "vognmand odder",
            "vognmand ole larsen",
            "vognmand palle",
            "vognmand per andersen",
            "vognmand per bjarne andersen",
            "vognmand per hansen",
            "vognmand per jensen",
            "vognmand per larsen",
            "vognmand poul møller",
            "vognmand poul pedersen",
            "vognmand preben andersen",
            "vognmand på",
            "vognmand på fyn",
            "vognmand ribe",
            "vognmand ringsted",
            "vognmand rødding",
            "vognmand sjælland",
            "vognmand skjern",
            "vognmand steen hansen",
            "vognmand søger",
            "vognmand søger chauffør",
            "vognmand søger kørsel",
            "vognmand søges",
            "vognmand sønderjylland",
            "vognmand søren hansen",
            "vognmand søren larsen",
            "vognmand sørensen",
            "vognmand tage",
            "vognmand torben jørgensen",
            "vognmand ølgod",
            "vognmand østjylland"};

    public void init() {
        ActionHandlerRegistry.init(getServletContext());
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        handleRequest(request, response);
    }


    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        handleRequest(request, response);
    }


    private void handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        StringBuffer sb = new StringBuffer();
        String p = request.getParameter(PARAM);
        if (p == null || p.equals("")) {
            generateTop(request, sb, null);
            generateIndexSite(sb);
        }
        else {
            RouteRepository repos = new RouteRepository();
            Route r = repos.get(Long.valueOf(p));

            boolean danish = generateTop(request, sb, r);
            generateRouteSite(r, sb, danish);
        }

        sb.append("</BODY></HTML>");
        out.println(sb.toString());
        out.close();

    }

    private void generateRouteSite(Route r, StringBuffer sb, boolean danish) {
        sb.append("<table>");
        sb.append("<tr>");
        sb.append("<td>").append(r.getCargoDescription()).append("</td>");
        sb.append("<td>");
        generateTags(sb, danish);
        sb.append("</td>");
        sb.append("<td>");
        generateCities(sb, danish);
        sb.append("</td>");

        sb.append("</tr>");
        sb.append("</table>");


    }

    private void generateCities(StringBuffer sb, boolean danish) {
        String[] cities;

        if (danish) {
            cities = danish_cities;
        }
        else {
            int i = random.nextInt(4);
            if (i == 0) {
                cities = us_cities;
            }
            else if (i == 1) {
                cities = us_cities;
            }
            else if (i == 2) {
                cities = uk_cities;
            }
            else {
                cities = australia_cities;
            }
        }
        int index = 0;
        while (8 > index++) {
            try {
                sb.append(" ").append(cities[random.nextInt(cities.length)]);
            }
            catch (Exception e) {
                //ignore
            }
        }

    }

    private void generateIndexSite(StringBuffer sb) {
        RouteRepository repos = new RouteRepository();
        Collection<Route> rs = repos.getAll();

        int count = 1;
        sb.append("<table>");
        for (Route r : rs) {
            sb.append("<tr>");
            sb.append("<td>").append(count++).append("</td>");
            sb.append("<td>").append(r.getCargoDescription()).append("</td>");
            sb.append("<td>").append("<a href=/gwtmodule/static?").append(PARAM).append("=").append(r.getId()).append(">here</a>").append("</td>");
            sb.append("</tr>");
        }
        sb.append("</table>");

    }

    private boolean generateTop(HttpServletRequest request, StringBuffer sb, Route r) {
        boolean danish = false;
        if (isNormalBrowser(request)) {
            sb.append("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\">\n<HTML>\n<HEAD><TITLE>24moveit.com</TITLE>");
            sb.append("<script type=\"text/javascript\">\n" + "<!--\n" + "window.location = \"http://www.24moveit.appspot.com/\"\n" + "//-->\n" + "</script>)");
            sb.append("</HEAD>\n<BODY>\n<H1>").append("Archive 24moveit</H1>\n");
        }
        else {
            if (r != null) {
                if (r.getFromPoint().getAddress().getNationalCode().equalsIgnoreCase("dk") || r.getToPoint().getAddress().getNationalCode().equalsIgnoreCase("dk")) {
                    danish = true;
                }
            }
            sb.append("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\">\n<HTML>\n<HEAD>");
            title(sb, danish);
            generateKeyWords(sb, danish);
            if (r != null) {
                generateDescription(sb, r);
            }
            sb.append(danish ? "\n<meta http-equiv=\"Content-Language\" content=\"da\" />" : "\n<meta http-equiv=\"Content-Language\" content=\" en-us\" />");
            sb.append("\n<meta name=\"googlebot\" content=\"noodp\" />");


            sb.append("</HEAD>\n<BODY>\n");
        }
        return danish;

    }


    private boolean isNormalBrowser(HttpServletRequest request) {

        String s = request.getHeader("User-Agent");
        if (s == null) {
            return false;
        }
        //s = s.toLowerCase();
        return (s.indexOf("msie") > -1)
                || (s.indexOf("opera") > -1)
                || (s.indexOf("safari") > -1)
                || (s.indexOf("chrome") > -1)
                || (s.indexOf("mozilla") > -1);
    }


    private void generateTags(StringBuffer sb, boolean danish) {
        String[] tags = danish ? danish_tags : english_tags;
        int index = 0;
        while (30 > index) {
            try {
                if (index != 0) {
                    sb.append(",");
                }
                sb.append(tags[random.nextInt(tags.length)]);
            }
            catch (Exception e) {
                //ignore
            }
            index++;
        }

    }

    private void generateKeyWords(StringBuffer sb, boolean danish) {
        sb.append("\n<meta name=\"keywords\" content=\"");
        generateTags(sb, danish);
        sb.append("\" />");
    }

    private void generateDescription(StringBuffer sb, Route r) {
        sb.append("\n<meta name=\"description\" content=\"");
        sb.append(r.getCargoDescription());
        sb.append("\" />");
    }

    private void title(StringBuffer sb, boolean danish) {
        sb.append("\n<title>");
        if (danish) {
            sb.append("100% GRATIS flyttepotal - 24moveit.appspot.com");
        }
        else {
            sb.append("100% FREE moving portal - 24moveit.appspot.com");
        }
        sb.append("</title>");
    }


}