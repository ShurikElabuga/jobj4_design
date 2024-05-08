package ru.job4j.question;

import java.util.Set;
import java.util.Map;
import java.util.HashMap;

public class Analize {
    public static Info diff(Set<User> previous, Set<User> current) {
        int added = 0;
        int changed = 0;
        int deleted;
       Map<Integer, User> map = new HashMap<>();
       for (User us : previous) {
           map.put(us.getId(), us);
       }
       for (User ur : current) {
           if (!map.containsKey(ur.getId())) {
               added++;
           }
           if (!map.containsValue(ur) && map.containsKey(ur.getId())) {
               changed++;
           }
           map.remove(ur.getId());
       }
        deleted = map.size();
       return new Info(added, changed, deleted);
    }
}
