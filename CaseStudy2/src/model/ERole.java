package model;

public enum ERole {
    STAFF(1,"Staff"), PT(2,"Pt");
    private long id;
    private String name;

    ERole() {
    }

    ERole(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static ERole findByName(String name) {
        for (ERole e : ERole.values()) {
            if (e.getName().equals(name)) {
                return e;
            }
        }
        return null;
    }
    public static ERole findById(int id) {
        for (ERole e : ERole.values()) {
            if (e.getId() == id) {
                return e;
            }
        }
        return null;
    }
}
