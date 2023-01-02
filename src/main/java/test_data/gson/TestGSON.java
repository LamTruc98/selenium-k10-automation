package test_data.gson;

import com.google.gson.Gson;

public class TestGSON {
    public static void main(String[] args) {
        Gson gson = new Gson();

        // From JSON(String) to object
        String jsonStr = "{\n" +
                "  \"name\": \"Teo\",\n" +
                "  \"age\": 18\n" +
                "}";
        User teo = gson.fromJson(jsonStr, User.class);
        System.out.println(teo);

        teo.setName("Dai ca Teo");
        teo.setAge("19");

        // From object to JSON
        String convertedJSON = gson.toJson(teo);
        System.out.println(convertedJSON);

    }
}
