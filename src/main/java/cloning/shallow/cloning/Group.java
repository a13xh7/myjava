package cloning.shallow.cloning;

/**
 * Created by Yevhenii Tykhonov.
 */
public class Group {
    public int id;

    public Group(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                '}';
    }
}
