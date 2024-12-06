
package swiftsupportclass;

import java.util.HashMap;

/**
 *
 * @author username00
 */
public class HashMapManageUser {
     private HashMap<String, String> userCredentials;

    public HashMapManageUser() {
        userCredentials = new HashMap<>();
        userCredentials.put("admin", "admin123");
        userCredentials.put("user", "user123");
    }

    public void addUser(String username, String password) {
        userCredentials.put(username, password);
    }

    public boolean validateUser(String username, String password) {
        return userCredentials.containsKey(username) && userCredentials.get(username).equals(password);
    }

}
