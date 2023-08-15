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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Entity getCategory() {
        return category;
    }

    public void setCategory(Entity category) {
        this.category = category;
    }

    public List<String> getPhotoUrls() {
        return photoUrls;
    }

    public void setPhotoUrls(List<String> photoUrls) {
        this.photoUrls = photoUrls;
    }

    public List<Entity> getTags() {
        return tags;
    }

    public void setTags(List<Entity> tags) {
        this.tags = tags;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}