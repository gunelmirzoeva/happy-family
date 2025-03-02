import java.util.List;

public interface FamilyDao {
    List<Family> getAllFamilies();
    Family getFamilyById(int id);
    boolean deleteFamily(int index);
    boolean deleteFamily(Family family);
    void saveFamily(Family family);
}
