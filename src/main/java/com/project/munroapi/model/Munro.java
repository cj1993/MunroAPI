package com.project.munroapi.model;

import com.opencsv.bean.CsvBindByName;

public class Munro {

    @CsvBindByName(column = "Running No")
    private String runningNo;

    @CsvBindByName(column = "DoBIH Number")
    private String doBIHNumber;

    @CsvBindByName(column = "Streetmap")
    private String streetMap;

    @CsvBindByName(column = "Geograph")
    private String geograph;

    @CsvBindByName(column = "Hill-bagging")
    private String hillBagging;

    @CsvBindByName(column = "bagging")
    private String bagging;

    @CsvBindByName(column = "Name")
    private String name;

    @CsvBindByName(column = "SMC Section")
    private String smcSection;

    @CsvBindByName(column = "RHB Section")
    private String rhbSection;

    @CsvBindByName(column = "_Section")
    private String section;

    @CsvBindByName(column = "Height (m)")
    private double heightMeters;

    @CsvBindByName(column = "Height (ft)")
    private double heightFeet;

    @CsvBindByName(column = "Map 1:50")
    private String map1To50;

    @CsvBindByName(column = "Map 1:25")
    private String map1To25;

    @CsvBindByName(column = "Grid Ref")
    private String gridRef;

    @CsvBindByName(column = "GridRefXY")
    private String gridRefXY;

    @CsvBindByName(column = "xcoord")
    private int xcoord;

    @CsvBindByName(column = "ycoord")
    private int ycoord;

    @CsvBindByName(column = "1891")
    private String year1891;

    @CsvBindByName(column = "1921")
    private String year1921;

    @CsvBindByName(column = "1933")
    private String year1933;

    @CsvBindByName(column = "1953")
    private String year1953;

    @CsvBindByName(column = "1969")
    private String year1969;

    @CsvBindByName(column = "1974")
    private String year1974;

    @CsvBindByName(column = "1981")
    private String year1981;

    @CsvBindByName(column = "1984")
    private String year1984;

    @CsvBindByName(column = "1990")
    private String year1990;

    @CsvBindByName(column = "1997")
    private String year1997;

    @CsvBindByName(column = "Post 1997")
    private String post1997;

    @CsvBindByName(column = "Comments")
    private String comments;

    public String getRunningNo() {
        return runningNo;
    }

    public void setRunningNo(String runningNo) {
        this.runningNo = runningNo;
    }

    public String getDoBIHNumber() {
        return doBIHNumber;
    }

    public void setDoBIHNumber(String doBIHNumber) {
        this.doBIHNumber = doBIHNumber;
    }

    public String getStreetMap() {
        return streetMap;
    }

    public void setStreetMap(String streetMap) {
        this.streetMap = streetMap;
    }

    public String getGeograph() {
        return geograph;
    }

    public void setGeograph(String geograph) {
        this.geograph = geograph;
    }

    public String getHillBagging() {
        return hillBagging;
    }

    public void setHillBagging(String hillBagging) {
        this.hillBagging = hillBagging;
    }

    public String getBagging() {
        return bagging;
    }

    public void setBagging(String bagging) {
        this.bagging = bagging;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSmcSection() {
        return smcSection;
    }

    public void setSmcSection(String smcSection) {
        this.smcSection = smcSection;
    }

    public String getRhbSection() {
        return rhbSection;
    }

    public void setRhbSection(String rhbSection) {
        this.rhbSection = rhbSection;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public double getHeightMeters() {
        return heightMeters;
    }

    public void setHeightMeters(int heightMeters) {
        this.heightMeters = heightMeters;
    }

    public double getHeightFeet() {
        return heightFeet;
    }

    public void setHeightFeet(int heightFeet) {
        this.heightFeet = heightFeet;
    }

    public String getMap1To50() {
        return map1To50;
    }

    public void setMap1To50(String map1To50) {
        this.map1To50 = map1To50;
    }

    public String getMap1To25() {
        return map1To25;
    }

    public void setMap1To25(String map1To25) {
        this.map1To25 = map1To25;
    }

    public String getGridRef() {
        return gridRef;
    }

    public void setGridRef(String gridRef) {
        this.gridRef = gridRef;
    }

    public String getGridRefXY() {
        return gridRefXY;
    }

    public void setGridRefXY(String gridRefXY) {
        this.gridRefXY = gridRefXY;
    }

    public int getXcoord() {
        return xcoord;
    }

    public void setXcoord(int xcoord) {
        this.xcoord = xcoord;
    }

    public int getYcoord() {
        return ycoord;
    }

    public void setYcoord(int ycoord) {
        this.ycoord = ycoord;
    }

    public String getYear1891() {
        return year1891;
    }

    public void setYear1891(String year1891) {
        this.year1891 = year1891;
    }

    public String getYear1921() {
        return year1921;
    }

    public void setYear1921(String year1921) {
        this.year1921 = year1921;
    }

    public String getYear1933() {
        return year1933;
    }

    public void setYear1933(String year1933) {
        this.year1933 = year1933;
    }

    public String getYear1953() {
        return year1953;
    }

    public void setYear1953(String year1953) {
        this.year1953 = year1953;
    }

    public String getYear1969() {
        return year1969;
    }

    public void setYear1969(String year1969) {
        this.year1969 = year1969;
    }

    public String getYear1974() {
        return year1974;
    }

    public void setYear1974(String year1974) {
        this.year1974 = year1974;
    }

    public String getYear1981() {
        return year1981;
    }

    public void setYear1981(String year1981) {
        this.year1981 = year1981;
    }

    public String getYear1984() {
        return year1984;
    }

    public void setYear1984(String year1984) {
        this.year1984 = year1984;
    }

    public String getYear1990() {
        return year1990;
    }

    public void setYear1990(String year1990) {
        this.year1990 = year1990;
    }

    public String getYear1997() {
        return year1997;
    }

    public void setYear1997(String year1997) {
        this.year1997 = year1997;
    }

    public String getPost1997() {
        return post1997;
    }

    public void setPost1997(String post1997) {
        this.post1997 = post1997;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
