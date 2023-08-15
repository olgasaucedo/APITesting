package schemas;

import java.util.List;

public class Pet {

    private Integer id;
    private String name;
    private Entity category;
    private List<String> photoUrls;
    private List<Entity> tags;
    private String status;

    public Pet(Integer id, String name, Entity category, List<String> photoUrls, List<Entity> tags, String status) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.photoUrls = photoUrls;
        this.tags = tags;
        this.status = status;
    }
}