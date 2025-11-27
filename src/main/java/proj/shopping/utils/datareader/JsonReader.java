package proj.shopping.utils.datareader;

import com.jayway.jsonpath.JsonPath;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import proj.shopping.utils.logs.LogsManager;

import java.io.File;
import java.io.FileReader;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class JsonReader {
    private final String TEST_DATA_PATH = "src/test/resources/test-data" + File.separator;
    private String jsonReader;

    /**
     * Supports loading multiple JSON files (merges their contents).
     * Example:
     * new JsonReader("register-data.json", "login-data.json");
     */
    public JsonReader(String... jsonFileNames) {
        try {
            Map<String, Object> mergedData = new LinkedHashMap<>();

            for (String fileName : jsonFileNames) {
                String filePath = TEST_DATA_PATH + fileName;
                FileReader reader = new FileReader(filePath);

                JSONObject data = (JSONObject) new JSONParser().parse(reader);
                mergedData.putAll(data); // merge key-value pairs

                reader.close();
            }

            JSONObject combinedObject = new JSONObject(mergedData);
            jsonReader = combinedObject.toJSONString();
        } catch (Exception e) {
            LogsManager.error("Error reading json files - " + e.getMessage());
            jsonReader = "{}"; // Avoid null pointer exceptions
        }
    }

    public String getJsonData(String jsonPath) {
        try {
            Object data = JsonPath.read(jsonReader, jsonPath);
            if (data instanceof List) {
                return String.join(", ", (List<String>) data);
            }
            return data.toString();
        } catch (Exception e) {
            LogsManager.error("Error reading json path: " + jsonPath + " - " + e.getMessage());
            return "";
        }
    }
}
