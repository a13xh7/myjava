package m12_json.ex_001_json;

import m12_json.ex_001_json.parser.JacksonDataBind;

/**
 * Created by Yevhenii Tykhonov.
 */
public class Main {
    public static void main(String[] args) {
        JacksonDataBind.parseJson(System.getProperty("user.dir") + "/person.json");
    }
}
