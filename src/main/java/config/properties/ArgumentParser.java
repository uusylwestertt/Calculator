package config.properties;

import java.util.HashMap;

public class ArgumentParser {

    public HashMap<String, String> parametersFromGradle = new HashMap<>();


    protected   void getParameters() {
        try{
            String args = System.getProperty("appArgs");
            for (String parameter : args.split(";")) {
                if (!parameter.equals("")) {
                    addArgsToTheList(parameter);
                }
            }
        }catch (NullPointerException e){

        }

    }

    private  void addArgsToTheList(String parameter) {
        String[] splitedParameters = parameter.split(";");
        for (String nameOfParameter : splitedParameters) {
            String[] partial = nameOfParameter.split("=");
            if (partial.length == 1) {
                parametersFromGradle.put(partial[0], "");
            } else {
                parametersFromGradle.put(partial[0], partial[1]);
            }
        }
    }


    protected  boolean argumentListHaveContent() {
        return parametersFromGradle.size() > 0;
    }

}
