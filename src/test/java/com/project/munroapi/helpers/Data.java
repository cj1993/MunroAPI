package com.project.munroapi.helpers;

import com.project.munroapi.model.Munro;

import java.util.ArrayList;
import java.util.List;

public class Data {
    public List<Munro> populateTestData() {
        List<Munro> munroData = new ArrayList<>();

        Munro munro1 = new Munro();
        munro1.setRunningNo("1");
        munro1.setName("A munro");
        munro1.setHeightMeters(1050);
        munro1.setGridRef("xx11yy22");
        munro1.setPost1997(Constants.MUN);
        munroData.add(munro1);

        Munro munro2 = new Munro();
        munro2.setRunningNo("2");
        munro2.setName("C munro different");
        munro2.setHeightMeters(950);
        munro2.setGridRef("xx44tt77");
        munro2.setPost1997(Constants.MUN);
        munroData.add(munro2);

        Munro munro3 = new Munro();
        munro3.setRunningNo("3");
        munro3.setName("HH munro");
        munro3.setHeightMeters(1000);
        munro3.setGridRef("yy66ff44");
        munro3.setPost1997(Constants.TOP);
        munroData.add(munro3);

        Munro munro4 = new Munro();
        munro4.setRunningNo("4");
        munro4.setName("B Munro");
        munro4.setHeightMeters(1205);
        munro4.setGridRef("ff33gg55");
        munro4.setPost1997(Constants.MUN);
        munroData.add(munro4);

        Munro munro5 = new Munro();
        munro5.setRunningNo("5");
        munro5.setName("X Munro");
        munro5.setHeightMeters(999);
        munro5.setGridRef("jj88gg77");
        munro5.setPost1997(Constants.TOP);
        munroData.add(munro5);

        return munroData;
    }
}
