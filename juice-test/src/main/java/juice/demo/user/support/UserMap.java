package juice.demo.user.support;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserMap {
    private Map<String, Object> map = new HashMap<>();

    public void putName(String name) {
        this.map.put("name", name);
    }

    public void putAge(Integer age) {
        this.map.put("age", age);
    }

    public String getName() {
        return (String) this.map.get("name");
    }

    public Integer getAge() {
        return (Integer) this.map.get("age");
    }

    public Map<String, Object> getMap() {
        return this.map;
    }
}
