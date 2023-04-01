package juice.demo.user.support;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserJsonObject {
    private JSONObject json = new JSONObject();

    public void putName(String name) throws JSONException {
        this.json.put("name", name);
    }

    public void putAge(Integer age) throws JSONException {
        this.json.put("age", age);
    }

    public String getName() throws JSONException {
        return (String) this.json.get("name");
    }

    public Integer getAge() throws JSONException {
        return (Integer) this.json.get("age");
    }

    public String getJsonStr() {
        return this.json.toString();
    }
}
