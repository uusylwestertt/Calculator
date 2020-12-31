package config.enums;

public enum BrowserTypes {
    CHROME("chrome"), FIREFOX("firefox");

    String name;

    BrowserTypes(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
