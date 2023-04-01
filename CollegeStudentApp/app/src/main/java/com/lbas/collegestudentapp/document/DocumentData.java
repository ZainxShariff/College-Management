package com.lbas.collegestudentapp.document;

public class DocumentData {

    private  String pdfTitle,pdfUrl;

    public DocumentData() {

    }

    public DocumentData(String name, String pdfUrl) {
        this.pdfTitle = name;
        this.pdfUrl = pdfUrl;
    }

    public String getPdfTitle() {
        return pdfTitle;
    }

    public void setPdfTitle(String name) {
        this.pdfTitle = name;
    }

    public String getPdfUrl() {
        return pdfUrl;
    }

    public void setPdfUrl(String pdfUrl) {
        this.pdfUrl = pdfUrl;
    }
}
