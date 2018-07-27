package com.wujie.mylistview.pop;

public class SheetItem {
    private String logo;
    private String name;
    private String con;
    private boolean state;
    OnSheetItemClickListener itemClickListener;


    public SheetItem(OnSheetItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }
    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCon() {
        return con;
    }

    public void setCon(String con) {
        this.con = con;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public interface OnSheetItemClickListener {
        void onSheetItemClick(int which);
    }
}
