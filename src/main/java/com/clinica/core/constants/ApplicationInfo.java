package com.clinica.core.constants;

public enum ApplicationInfo {

    TITLE("Clinica-Backend"),
    DESCRIPTION("Proyecto que provee Apis para el proceso de negocio de la clinica San Pedro"),
    VERSION("1.0"),
    TERMS_URL("https://test.io/terms-of-service"),
    LICENSE("APACHE LICENCE 2.O"),
    LICENCE_URL("https://www.apache.org/licenses/LICENSE-2.0.txt"),
    CONTACT_NAME("Elizabeth Valdez Pacheco"),
    CONTACT_URL("https://lenguajejs.com/"),
    CONTACT_EMAIL("elizabet.yuliana@hotmail.com");


    private String infoApi;

    private ApplicationInfo(String infoApi) {
        this.infoApi = infoApi;
    }

    public String getInfo() {
        return infoApi;
    }

}
