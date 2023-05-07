package org.techtown.weathercloset;

public class Note {     //각 아이템의 데이터를 담아둘 객체의 클래스 정의
    String contents;    //내용
    String picture;     //사진 이미지의 경로
    String createDateStr;       //후기 작성 일자
    String temperature;  //온도

    public Note(String contents, String picture, String createDateStr, String temperature) {
        this.contents = contents;
        this.picture = picture;
        this.createDateStr = createDateStr;
        this.temperature = temperature;
    }

    public String getContents() {
        return contents;
    }
    public void setContents(String contents) {
        this.contents = contents;
    }

    public String getPicture() {
        return picture;
    }
    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getCreateDateStr() {
        return createDateStr;
    }
    public void setCreateDateStr(String createDateStr) {this.createDateStr = createDateStr;}

    public String getTemperature() {return temperature;}
    public void setTemperature(String temperature) {this.temperature = temperature;}
}
