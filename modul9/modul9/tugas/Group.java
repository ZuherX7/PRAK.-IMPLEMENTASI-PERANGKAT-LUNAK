package modul9.tugas;

public class Group {
    public List getUsersSortedByMostRecentlyRegistered() {
        List users = new ArrayList();
        if (!userDirectoryExists()){
            return users;
            addFoundUsersTo(users);
            sortByMostRecentlyRegistered(users);
            return users;
        }
    }
}